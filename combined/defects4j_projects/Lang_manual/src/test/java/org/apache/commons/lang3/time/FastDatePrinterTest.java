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

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import org.apache.commons.lang3.SerializationUtils;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.time.FastDatePrinter}.
 *
 * @since 3.0
 */
public class FastDatePrinterTest {
    
    private static final String YYYY_MM_DD = "yyyy/MM/dd";
    private static final TimeZone NEW_YORK = TimeZone.getTimeZone("America/New_York");
    private static final Locale SWEDEN = new Locale("sv", "SE");

        DatePrinter getInstance(final String format) {
        return getInstance(format, TimeZone.getDefault(), Locale.getDefault());
    }

    private DatePrinter getDateInstance(final int dateStyle, final Locale locale) {
        return getInstance(FormatCache.getPatternForStyle(Integer.valueOf(dateStyle), null, locale), TimeZone.getDefault(), Locale.getDefault());
    }

    private DatePrinter getInstance(final String format, final Locale locale) {
        return getInstance(format, TimeZone.getDefault(), locale);
    }

    private DatePrinter getInstance(final String format, final TimeZone timeZone) {
        return getInstance(format, timeZone, Locale.getDefault());
    }

    /**
     * Override this method in derived tests to change the construction of instances
     * @param format
     * @param timeZone
     * @param locale
     * @return
     */
    protected DatePrinter getInstance(final String format, final TimeZone timeZone, final Locale locale) {
        return new FastDatePrinter(format, timeZone, locale);
    }

@Test
public void test_getInstance_String_Locale14() { 
     final Locale realDefaultLocale = Locale.getDefault(); 
     try { 
         Locale.setDefault(Locale.US); 
         final FastDateFormat format1 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         final FastDateFormat format2 = FastDateFormat.getInstance("MM/DD/yyyy"); 
         final FastDateFormat format3 = FastDateFormat.getInstance("MM/DD/yyyy", Locale.GERMANY); 
         assertTrue(format1 != format2); 
         assertSame(format1, format3); 
         assertEquals(Locale.GERMANY, format1.getLocale()); 
     } finally { 
         Locale.setDefault(realDefaultLocale); 
     } 
 }
@Test
public void testShortDateStyleWithLocales24() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 }
@Test
public void testHashCode31() { 
     final FastDateFormat format1 = FastDateFormat.getInstance(); 
     final FastDateFormat format2 = FastDateFormat.getInstance(); 
     assertEquals(format1.hashCode(), format2.hashCode()); 
     assertEquals(format1.hashCode(), format2.hashCode()); 
     assertFalse(format1.hashCode() == format3.hashCode()); 
     assertFalse(format1.hashCode() == format4.hashCode()); 
     assertFalse(format1.hashCode() == format5.hashCode()); 
 }
@Test
public void testEquals48() { 
     final DateParser parser1 = getInstance(YMD_SLASH); 
     final DateParser parser2 = getInstance(YMD_SLASH); 
     assertEquals(parser1, parser2); 
     assertEquals(parser1.hashCode(), parser2.hashCode()); 
     assertFalse(parser1.equals(new Object())); 
 }
@Test
public void testAmPm117() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     final DateParser h = getInstance("yyyy-MM-dd hh a mm:ss", NEW_YORK, Locale.US); 
     final DateParser K = getInstance("yyyy-MM-dd KK a mm:ss", NEW_YORK, Locale.US); 
     final DateParser k = getInstance("yyyy-MM-dd kk:mm:ss", NEW_YORK, Locale.US); 
     final DateParser H = getInstance("yyyy-MM-dd HH:mm:ss", NEW_YORK, Locale.US); 
     cal.set(2010, 7, 1, 0, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 12 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 0 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 00:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 00:33:20")); 
     cal.set(2010, 7, 1, 3, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 03:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 03:33:20")); 
     cal.set(2010, 7, 1, 15, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 PM 33:20")
@Test
public void testTimeZoneDisplay188() { 
     final Locale usLocale = Locale.US; 
     final Locale swedishLocale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2004, 1, 3); 
     DatePrinter fdf = getDateInstance(FastDateFormat.SHORT, usLocale); 
     assertEquals("2/3/04", fdf.format(cal)); 
     fdf = getDateInstance(FastDateFormat.SHORT, swedishLocale); 
     assertEquals("2004-02-03", fdf.format(cal)); 
 }
@Test
public void testSMTP189() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2003, 5, 8, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), timeZone, DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.SMTP_DATETIME_FORMAT.format(cal); 
     assertEquals("Sun, 08 Jun 2003 10:11:12 -0300", text); 
     text = DateFormatUtils.formatUTC(cal.getTime().getTime(), DateFormatUtils.SMTP_DATETIME_FORMAT.getPattern(), DateFormatUtils.SMTP_DATETIME_FORMAT.getLocale()); 
     assertEquals("Sun, 08 Jun 2003 13:11:12 +0000", text); 
 }
@Test
public void testTimeZone190() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.ISO_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.ISO_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("T10:11:12-03:00", text); 
 }
@Test
public void testLang645191() { 
     final Locale locale = new Locale("sv", "SE"); 
     final Calendar cal = Calendar.getInstance(); 
     cal.set(2010, 0, 1, 12, 0, 0); 
     final Date d = cal.getTime(); 
     final DatePrinter fdf = getInstance("EEEE', week 'ww", locale); 
     assertEquals("fredag, week 53", fdf.format(d)); 
 }
@Test
public void testEquals192() { 
     final DatePrinter printer1 = getInstance(YYYY_MM_DD); 
     final DatePrinter printer2 = getInstance(YYYY_MM_DD); 
     assertEquals(printer1, printer2); 
     assertEquals(printer1.hashCode(), printer2.hashCode()); 
     assertFalse(printer1.equals(new Object())); 
 }
@Test
public void testDayOf193() throws Exception { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     cal.set(2003, 1, 10); 
     final DateParser fdf = getInstance("W w F D y", NEW_YORK, Locale.US); 
     assertEquals(cal.getTime(), fdf.parse("3 7 2 41 03")); 
 }
@Test
public void testUnpaddedAmPm194() throws ParseException { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     final DateParser h = getInstance("yyyy-MM-dd hh a mm:ss", NEW_YORK, Locale.US); 
     final DateParser K = getInstance("yyyy-MM-dd KK a mm:ss", NEW_YORK, Locale.US); 
     final DateParser k = getInstance("yyyy-MM-dd kk:mm:ss", NEW_YORK, Locale.US); 
     final DateParser H = getInstance("yyyy-MM-dd HH:mm:ss", NEW_YORK, Locale.US); 
     cal.set(2010, 7, 1, 0, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 12 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 0 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 00:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 00:33:20")); 
     cal.set(2010, 7, 1, 3, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 03:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 03:33:20")); 
     cal.set(2010, 7, 1, 15, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 PM 33
@Test
public void testLocaleMatches195() { 
     final DatePrinter printer = getInstance(YYYY_MM_DD, NEW_YORK); 
     assertEquals(NEW_YORK, printer.getLocale()); 
 }
@Test
public void testTimeISO196() { 
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
     text = DurationFormatUtils.format(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P32Y1M22DT9H11M12.001S", text); 
     cal.set(1971, 1, 3, 10, 30, 0); 
     cal.set(Calendar.MILLISECOND, 0); 
     text = DurationFormatUtils.format(base.getTime().getTime(), cal.getTime().getTime(), DurationFormatUtils.ISO_EXTENDED_FORMAT_PATTERN, false, timeZone); 
     assertEquals("P1Y1M2DT10H30M0.000S", text); 
 }
@Test
public void testTimeZone197() { 
     final TimeZone timeZone = TimeZone.getTimeZone("GMT-3"); 
     final Calendar cal = Calendar.getInstance(timeZone); 
     cal.set(2002, 1, 23, 10, 11, 12); 
     String text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12", text); 
     text = DateFormatUtils.ISO_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("T10:11:12", text); 
     text = DateFormatUtils.format(cal.getTime(), DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.format(cal.getTime().getTime(), DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT.getPattern(), timeZone); 
     assertEquals("T10:11:12-03:00", text); 
     text = DateFormatUtils.ISO_TIME_TIME_ZONE_FORMAT.format(cal); 
     assertEquals("T10:11:12-03:00", text); 
 }
@Test
public void testPaddedNumberField225() { 
     final Calendar cal = Calendar.getInstance(NEW_YORK, Locale.US); 
     cal.clear(); 
     final DateParser h = getInstance("yyyy-MM-dd hh a mm:ss", NEW_YORK, Locale.US); 
     final DateParser K = getInstance("yyyy-MM-dd KK a mm:ss", NEW_YORK, Locale.US); 
     final DateParser k = getInstance("yyyy-MM-dd kk:mm:ss", NEW_YORK, Locale.US); 
     final DateParser H = getInstance("yyyy-MM-dd HH:mm:ss", NEW_YORK, Locale.US); 
     cal.set(2010, 7, 1, 0, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 12 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 0 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 00:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 00:33:20")); 
     cal.set(2010, 7, 1, 3, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), K.parse("2010-08-01 3 AM 33:20")); 
     assertEquals(cal.getTime(), k.parse("2010-08-01 03:33:20")); 
     assertEquals(cal.getTime(), H.parse("2010-08-01 03:33:20")); 
     cal.set(2010, 7, 1, 15, 33, 20); 
     assertEquals(cal.getTime(), h.parse("2010-08-01 3 PM 33:20")
@Test
public void testMultipartKey226() { 
     final Calendar c = Calendar.getInstance(); 
     c.set(2005, 0, 1, 12, 0, 0); 
     final MultipartKey key = new MultipartKey(c.getTime(), c.getTime()); 
     final FastDateFormat format1 = FastDateFormat.getInstance(); 
     final FastDateFormat format2 = FastDateFormat.getInstance(); 
     final int year = c.get(Calendar.YEAR); 
     final int month = c.get(Calendar.MONTH) + 1; 
     final int day = c.get(Calendar.DAY_OF_MONTH); 
     final int hour = c.get(Calendar.HOUR_OF_DAY); 
     assertEquals(year, format1.get(year)); 
     assertEquals(month, format2.get(year)); 
     assertEquals(month, format3.get(month)); 
     assertEquals(day, format1.get(day)); 
     assertEquals(hour, format2.get(month)); 
     assertEquals(day, format3.get(day)); 
     assertEquals(hour, format1.get(hour)); 
     assertEquals(day, format2.get(hour)); 
     assertEquals(hour, format3.get(day)); 
     assertEquals(day, format1.get(hour)); 
     assertEquals(hour, format2.get(hour)); 
     assertEquals(day, format3.get(day)); 
     assertEquals(hour, format1.get(hour)); 
     assertEquals(day, format2.get(hour)); 
     assertEquals(hour, format3.get(day)); 
     assertEquals(hour, format1.get(hour)); 
 }
@Test
public void testMultipartKey227() { 
     final Calendar c = Calendar.getInstance(); 
     c.set(2005, 0, 1, 12, 0, 0); 
     final MultipartKey key = new MultipartKey(); 
     assertEquals(c.getTime(), key.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
     assertEquals(c.getTime(), c.getTime()); 
 }
@Test
public void testMilleniumBug279() { 
     final Calendar cal = Calendar.getInstance(); 
     final DatePrinter format = getInstance("dd.MM.yyyy"); 
     cal.set(1000, 0, 1); 
     assertEquals("01.01.1000", format.format(cal)); 
 }
@Test
public void testParseSync280() throws InterruptedException { 
     final String pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS Z"; 
     final FastDateFormat formatter = FastDateFormat.getInstance(pattern); 
     final long sdfTime = measureTime(formatter, new SimpleDateFormat(pattern) { 
  
         private static final long serialVersionUID = 1L; 
  
         @Override 
         public Object parseObject(final String formattedDate) throws ParseException { 
             synchronized (this) { 
                 return super.parse(formattedDate); 
             } 
         } 
     }); 
     final long fdfTime = measureTime(formatter, FastDateFormat.getInstance(pattern)); 
     final String times = ">>FastDateFormatTest: FastDateParser:" + fdfTime + "  SimpleDateFormat:" + sdfTime; 
     System.out.println(times); 
 }
    

    /**
     * Test case for {@link FastDateParser#FastDateParser(String, TimeZone, Locale)}.
     */
    

    /**
     * Tests that pre-1000AD years get padded with yyyy
     */
    
    /**
     * Show Bug #39410 is solved
     */
    

    /**
     * testLowYearPadding showed that the date was buggy
     * This test confirms it, getting 366 back as a date
     */
    

    

    

    
    
    
    
    
    
    
    
    
    
    
    
    
// Defects4J: flaky method
//     @Test
//     public void testCalendarTimezoneRespected() {
//         final String[] availableZones = TimeZone.getAvailableIDs();
//         final TimeZone currentZone = TimeZone.getDefault();
//         
//         TimeZone anotherZone = null;
//         for (final String zone : availableZones) {
//             if (!zone.equals(currentZone.getID())) {
//                 anotherZone = TimeZone.getTimeZone(zone);
//             }
//         }
//         
//         assertNotNull("Cannot find another timezone", anotherZone);
//         
//         final String pattern = "h:mma z";
//         final Calendar cal = Calendar.getInstance(anotherZone);
//         
//         final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
//         sdf.setTimeZone(anotherZone);
//         final String expectedValue = sdf.format(cal.getTime());
//         final String actualValue = FastDateFormat.getInstance(pattern).format(cal);
//         assertEquals(expectedValue, actualValue);
//     }
}
