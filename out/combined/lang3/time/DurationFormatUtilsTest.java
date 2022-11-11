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
@Test
public void testFormat9568() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String9652() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9694() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9696() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx9698() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:00:12", DurationFormatUtils.lexx("0:12:13.4")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:14:15.6")); 
     }
@Test
public void testFormat9699() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormatDurationWords9701() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testLexx_String9702() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     }
@Test
public void testFormatDurationWords9705() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9706() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9709() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9712() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9714() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9715() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormat9717() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS Z", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime())); 
     }
@Test
public void testLexx_String9718() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9720() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9724() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     }
@Test
public void testFormatDurationWords9725() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormatDurationWords9727() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9728() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9729() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormat9730() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormatDurationWords9731() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormatDurationWords9732() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9733() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9736() { 
         assertArrayEquals(null, TokenUtils.lexx(null)); 
         assertEquals(0, TokenUtils.lexx("").length); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, TokenUtils.lexx("ab de fg"))); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, TokenUtils.lexx("ab   de fg"))); 
  
         assertTrue(ArrayUtils.isEquals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, TokenUtils.lexx("ab:cd:ef"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "number", "5" }, TokenUtils.lexx("number5"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "foo", "B", "ar" }, TokenUtils.lexx("fooBar"))); 
         assertTrue(ArrayUtils.isEquals(new String[] { "foo", "200", "B", "ar" }, TokenUtils.lexx("foo200Bar"))); 
          
         assertTrue(ArrayUtils.isEquals(new String[] { "ASF", "Rules" }, TokenUtils.lexx("ASFRules"))); 
         assertTrue(ArrayUtils.isEquals(new String[] { "ASFRules" }, TokenUtils.lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9737() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9739() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9740() { 
         assertArrayEquals(new Token[0], lexx("")); 
         assertArrayEquals(new Token[]{Token.valueOf("a")}, lexx("a")); 
         assertArrayEquals(new Token[]{Token.valueOf("b")}, lexx("b")); 
         assertArrayEquals(new Token[]{Token.valueOf("c")}, lexx("c")); 
         assertArrayEquals(new Token[]{Token.valueOf("d"), Token.valueOf("e")}, lexx("d e")); 
         assertArrayEquals(new Token[]{Token.valueOf("1"), Token.valueOf("2")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("3")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("4"), Token.valueOf("5")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("6"), Token.valueOf("7")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("8"), Token.valueOf("9")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("10"), Token.valueOf("11")}, lexx("a b c")); 
         assertArrayEquals(new Token[]{Token.valueOf("-14"), Token.valueOf("-15")}, lexx("-16")); 
     }
@Test
public void testLexx_String9741() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9744() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9747() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx9748() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatDuration(time, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatDuration(time, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatDuration(time, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatDuration(time, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatDuration(time, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatDuration(time, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatDuration(time, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatDuration(time, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatDuration(time, "0:00:8.9")); 
         assertEquals("0:00:00.10", DurationFormatUtils.formatDuration(time, "0:0:10.11")); 
         assertEquals("0:00:00.12", DurationFormatUtils.formatDuration(time, "0:0:12.13")); 
         assertEquals("0:00:12.14", DurationFormatUtils.formatDuration(time, "0:0:14.15")); 
     }
@Test
public void testFormatDurationWords9749() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormat9750() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormatDurationWords9751() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testLexx_String9752() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat9753() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormat9754() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormatDurationWords9757() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx9758() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:00:12", DurationFormatUtils.lexx("0:12:13.4")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:14:15.6")); 
     }
@Test
public void testLexx_String9760() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9762() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormatDurationWords9763() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9765() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9766() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9768() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9769() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9772() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9773() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat9775() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String9776() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String9777() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat9781() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String9782() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9783() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9785() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9788() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testLexx_String9789() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9790() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9791() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9793() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat9797() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String9799() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9801() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testLexx_String9802() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords9804() { 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", StringUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(0, false, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", StringUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9807() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testFormatDurationWords9808() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9809() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx9814() { 
         assertEquals("0:00:00.000", DurationFormatUtils.lexx("0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.lexx("0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.lexx("0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.lexx("0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.lexx("0:00:00.4")); 
          
         assertEquals("0:00:00.5", DurationFormatUtils.lexx("0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.lexx("0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.lexx("0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.lexx("0:00:00.8")); 
         assertEquals("0:00:00.9", DurationFormatUtils.lexx("0:00:00.9")); 
          
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.10")); 
         assertEquals("0:00:00", DurationFormatUtils.lexx("0:00:00.11")); 
         assertEquals("0:12:12", DurationFormatUtils.lexx("0:12:12.13")); 
         assertEquals("0:13:14", DurationFormatUtils.lexx("0:13:14.15")); 
     }
@Test
public void testFormatDurationWords9819() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2, true, false)); 
     }
@Test
public void testLexx_String9820() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormatDurationWords_Long9823() { 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("0:00:00", DurationUtils.formatDurationWords(0L, false, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(0L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, true, false)); 
          
         assertEquals("00:00:00", DurationUtils.formatDurationWords(1L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(2L, true, false)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, false, true)); 
         assertEquals("00:00:00", DurationUtils.formatDurationWords(3L, true, false)); 
     }
@Test
public void testFormatPeriod11338() { 
         long time = 0; 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(time, 0, "0:00:00.000")); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(time, 1, "0:00:00.001")); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(time, 2, "0:00:00.2")); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(time, 3, "0:00:00.3")); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(time, 4, "0:00:00.4")); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(time, 5, "0:00:00.5")); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(time, 6, "0:00:00.6")); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(time, 7, "0:00:00.7")); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(time, 8, "0:00:00.8")); 
     }
@Test
public void testLexx11345() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(12, 14, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
     }
@Test
public void testLexx11362() { 
         assertEquals("0:00:00.000", DurationFormatUtils.formatPeriod(0, 0, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.001", DurationFormatUtils.formatPeriod(0, 1, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.2", DurationFormatUtils.formatPeriod(0, 2, "0:00:00.000", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.3", DurationFormatUtils.formatPeriod(0, 3, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.4", DurationFormatUtils.formatPeriod(0, 4, "0:00:00.001", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.5", DurationFormatUtils.formatPeriod(0, 5, "0:00:00.5", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.6", DurationFormatUtils.formatPeriod(0, 6, "0:00:00.6", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.7", DurationFormatUtils.formatPeriod(0, 7, "0:00:00.7", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.8", DurationFormatUtils.formatPeriod(12, 14, "0:00:00.8", false, TimeZone.getDefault())); 
         assertEquals("0:00:00.9", DurationFormatUtils.formatPeriod(14, 15, "0:00:00.9", false, TimeZone.getDefault())); 
     }
@Test
public void testLexx_String11840() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String11842() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String11843() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String11844() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat11846() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String11849() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testLexx_String11850() { 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three"), new Token("four") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("one"), new Token("two"), new Token("three") }, lexx("a b c")); 
         assertArrayEquals(new Token[] { new Token("x"), new Token("y"), new Token("z") }, lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
  
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
         assertEquals(Arrays.asList(new Token[] { new Token("one"), new Token("two"), new Token("three") }), lexx("a b c")); 
     }
@Test
public void testFormat11854() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testLexx_String11855() { 
         assertArrayEquals(null, lexx(null)); 
         assertEquals(0, lexx("").length); 
  
         assertTrue(Arrays.equals(new String[] { "ab", " ", "de", " ", 
                 "fg" }, lexx("ab de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", "   ", "de", " ", 
                 "fg" }, lexx("ab   de fg"))); 
  
         assertTrue(Arrays.equals(new String[] { "ab", ":", "cd", ":", 
                 "ef" }, lexx("ab:cd:ef"))); 
          
         assertTrue(Arrays.equals(new String[] { "number", "5" }, lexx("number5"))); 
          
         assertTrue(Arrays.equals(new String[] { "foo", "B", "ar" }, lexx("fooBar"))); 
         assertTrue(Arrays.equals(new String[] { "foo", "200", "B", "ar" }, lexx("foo200Bar"))); 
          
         assertTrue(Arrays.equals(new String[] { "ASF", "Rules" }, lexx("ASFRules"))); 
         assertTrue(Arrays.equals(new String[] { "ASFRules" }, lexx("ASFRules"))); 
     }
@Test
public void testFormat11861() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 989); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
     }
@Test
public void testFormat11868() { 
         final Calendar cal = Calendar.getInstance(); 
         cal.clear(); 
         cal.set(2004, Calendar.JANUARY, 23, 18, 33, 05); 
         cal.set(Calendar.MILLISECOND, 0); 
  
         final DatePrinter format = getInstance("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", TimeZone.getTimeZone("UTC")); 
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime())); 
  
         assertEquals("2004-02-23T09:00:00.000Z", format.format(cal.getTime().getTime())); 
  
         format = getInstance("Z"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
  
         format = getInstance("-0500"); 
         assertEquals("-0500", format.format(cal.getTime().getTime())); 
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
