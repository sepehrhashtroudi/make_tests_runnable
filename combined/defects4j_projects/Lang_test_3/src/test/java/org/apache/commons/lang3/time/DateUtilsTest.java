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

import static org.apache.commons.lang3.JavaVersion.JAVA_1_4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.TimeZone;

import junit.framework.AssertionFailedError;

import org.apache.commons.lang3.SystemUtils;

import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.time.DateUtils}.
 *
 */
public class DateUtilsTest {

    private static final long MILLIS_TEST;
    static {
        final GregorianCalendar cal = new GregorianCalendar(2000, 6, 5, 4, 3, 2);
        cal.set(Calendar.MILLISECOND, 1);
        MILLIS_TEST = cal.getTime().getTime();
        System.out.println("DateUtilsTest: Default Locale="+Locale.getDefault());
    }

    DateFormat dateParser = null;
    DateFormat dateTimeParser = null;
    DateFormat timeZoneDateParser = null;
    Date dateAmPm1 = null;
    Date dateAmPm2 = null;
    Date dateAmPm3 = null;
    Date dateAmPm4 = null;
    Date date0 = null;
    Date date1 = null;
    Date date2 = null;
    Date date3 = null;
    Date date4 = null;
    Date date5 = null;
    Date date6 = null;
    Date date7 = null;
    Date date8 = null;
    Calendar calAmPm1 = null;
    Calendar calAmPm2 = null;
    Calendar calAmPm3 = null;
    Calendar calAmPm4 = null;
    Calendar cal1 = null;
    Calendar cal2 = null;
    Calendar cal3 = null;
    Calendar cal4 = null;
    Calendar cal5 = null;
    Calendar cal6 = null;
    Calendar cal7 = null;
    Calendar cal8 = null;
    TimeZone zone = null;
    TimeZone defaultZone = null;


    @Before
    public void setUp() throws Exception {


        dateParser = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        dateTimeParser = new SimpleDateFormat("MMM dd, yyyy H:mm:ss.SSS", Locale.ENGLISH);

        dateAmPm1 = dateTimeParser.parse("February 3, 2002 01:10:00.000");
        dateAmPm2 = dateTimeParser.parse("February 3, 2002 11:10:00.000");
        dateAmPm3 = dateTimeParser.parse("February 3, 2002 13:10:00.000");
        dateAmPm4 = dateTimeParser.parse("February 3, 2002 19:10:00.000");
        date0 = dateTimeParser.parse("February 3, 2002 12:34:56.789");
        date1 = dateTimeParser.parse("February 12, 2002 12:34:56.789");
        date2 = dateTimeParser.parse("November 18, 2001 1:23:11.321");
        defaultZone = TimeZone.getDefault();
        zone = TimeZone.getTimeZone("MET");
        TimeZone.setDefault(zone);
        dateTimeParser.setTimeZone(zone);
        date3 = dateTimeParser.parse("March 30, 2003 05:30:45.000");
        date4 = dateTimeParser.parse("March 30, 2003 01:10:00.000");
        date5 = dateTimeParser.parse("March 30, 2003 01:40:00.000");
        date6 = dateTimeParser.parse("March 30, 2003 02:10:00.000");
        date7 = dateTimeParser.parse("March 30, 2003 02:40:00.000");
        date8 = dateTimeParser.parse("October 26, 2003 05:30:45.000");
        dateTimeParser.setTimeZone(defaultZone);
        TimeZone.setDefault(defaultZone);
        calAmPm1 = Calendar.getInstance();
        calAmPm1.setTime(dateAmPm1);
        calAmPm2 = Calendar.getInstance();
        calAmPm2.setTime(dateAmPm2);
        calAmPm3 = Calendar.getInstance();
        calAmPm3.setTime(dateAmPm3);
        calAmPm4 = Calendar.getInstance();
        calAmPm4.setTime(dateAmPm4);
        cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        TimeZone.setDefault(zone);
        cal3 = Calendar.getInstance();
        cal3.setTime(date3);
        cal4 = Calendar.getInstance();
        cal4.setTime(date4);
        cal5 = Calendar.getInstance();
        cal5.setTime(date5);
        cal6 = Calendar.getInstance();
        cal6.setTime(date6);
        cal7 = Calendar.getInstance();
        cal7.setTime(date7);
        cal8 = Calendar.getInstance();
        cal8.setTime(date8);
        TimeZone.setDefault(defaultZone);
    }

    //-----------------------------------------------------------------------
@Test
public void testIsSameDay232() { 
     assertTrue(DateUtils.isSameDay(date1, date2)); 
     assertFalse(DateUtils.isSameDay(date1, null)); 
     assertFalse(DateUtils.isSameDay(null, date2)); 
     try { 
         DateUtils.isSameDay(date1, null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameDay(date1, date2); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameDay(date2, null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameDay(date1, date2); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testIsSameDay_Cal236() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameDay(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameDay(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameDay(cal1, cal2)); 
     try { 
         DateUtils.isSameDay((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testIsSameInstant237() throws Exception { 
     assertTrue(DateUtils.isSameInstant(date1, date2)); 
     try { 
         DateUtils.isSameInstant(null, date2); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameInstant(date1, null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameInstant(date1, date2); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         DateUtils.isSameInstant(date2, null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertFalse(DateUtils.isSameInstant(date1, date2)); 
     assertTrue(DateUtils.isSameInstant(date2, date1)); 
     assertFalse(DateUtils.isSameInstant(date2, date2)); 
     assertFalse(DateUtils.isSameInstant(date1, null)); 
     assertFalse(DateUtils.isSameInstant(null, date2)); 
 }
@Test
public void testIsSameInstant_Cal240() { 
     final GregorianCalendar cal1 = new GregorianCalendar(TimeZone.getTimeZone("GMT+1")); 
     final GregorianCalendar cal2 = new GregorianCalendar(TimeZone.getTimeZone("GMT-1")); 
     cal1.set(2004, 6, 9, 13, 45, 0); 
     cal1.set(Calendar.MILLISECOND, 0); 
     cal2.set(2004, 6, 9, 13, 45, 0); 
     cal2.set(Calendar.MILLISECOND, 0); 
     assertTrue(DateUtils.isSameInstant(cal1, cal2)); 
     final Calendar cal3 = Calendar.getInstance(); 
     final Calendar cal4 = Calendar.getInstance(); 
     cal3.set(2004, 6, 9, 4, 0, 0); 
     cal4.set(2004, 6, 9, 16, 0, 0); 
     cal3.set(Calendar.MILLISECOND, 0); 
     cal4.set(Calendar.MILLISECOND, 0); 
     assertFalse("LANG-677", DateUtils.isSameInstant(cal3, cal4)); 
     cal2.set(2004, 6, 9, 11, 45, 0); 
     assertFalse(DateUtils.isSameInstant(cal1, cal2)); 
     try { 
         DateUtils.isSameInstant((Calendar) null, (Calendar) null); 
         fail(); 
     } catch (final IllegalArgumentException ex) { 
     } 
 }
@Test
public void testLANG799_DE_OK241() throws ParseException { 
     final Locale dflt = Locale.getDefault(); 
     Locale.setDefault(Locale.GERMAN); 
     try { 
         DateUtils.parseDate("Mi, 09 Apr 2008 23:55:38 GMT", "EEE, dd MMM yyyy HH:mm:ss zzz"); 
         DateUtils.parseDateStrictly("Mi, 09 Apr 2008 23:55:38 GMT", "EEE, dd MMM yyyy HH:mm:ss zzz"); 
     } finally { 
         Locale.setDefault(dflt); 
     } 
 }
@Test
public void testLang530242() throws ParseException { 
     final Date d = new Date(); 
     final String isoDateStr = DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.format(d); 
     final Date d2 = DateUtils.parseDate(isoDateStr, new String[] { DateFormatUtils.ISO_DATETIME_TIME_ZONE_FORMAT.getPattern() }); 
     assertEquals("Date not equal to itself ISO formatted and parsed", d.getTime(), d2.getTime() + d.getTime() % 1000); 
 }
@Test
public void testSetMinutes243() throws Exception { 
     final Date base = new Date(MILLIS_TEST); 
     Date result = DateUtils.setMinutes(base, 0); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 3, 2, 1); 
     result = DateUtils.setMinutes(base, 59); 
     assertNotSame(base, result); 
     assertDate(base, 2000, 6, 5, 4, 3, 2, 1); 
     assertDate(result, 2000, 6, 5, 4, 4, 2, 1); 
     try { 
         result = DateUtils.setMinutes(base, 60); 
         fail("DateUtils.setMinutes did not throw an expected IllegalArguementException."); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    // LANG-486
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void assertDate(final Date date, final int year, final int month, final int day, final int hour, final int min, final int sec, final int mil) throws Exception {
        final GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(date);
        assertEquals(year, cal.get(Calendar.YEAR));
        assertEquals(month, cal.get(Calendar.MONTH));
        assertEquals(day, cal.get(Calendar.DAY_OF_MONTH));
        assertEquals(hour, cal.get(Calendar.HOUR_OF_DAY));
        assertEquals(min, cal.get(Calendar.MINUTE));
        assertEquals(sec, cal.get(Calendar.SECOND));
        assertEquals(mil, cal.get(Calendar.MILLISECOND));
    }

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    /**
     * Tests various values with the round method
     */
    

    /**
     * Tests the Changes Made by LANG-346 to the DateUtils.modify() private method invoked
     * by DateUtils.round().
     */
    

    /**
     * Tests various values with the trunc method
     */
    

    /**
     * Tests for LANG-59
     *
     * see http://issues.apache.org/jira/browse/LANG-59
     */
    

    // http://issues.apache.org/jira/browse/LANG-530
    
    
    /**
     * Tests various values with the ceiling method
     */
    

    /**
     * Tests the iterator exceptions
     */
    

    /**
     * Tests the calendar iterator for week ranges
     */
    
            
    /**
     * Tests the calendar iterator for month-based ranges
     */
    

    

    // Parse German date with English Locale
    

    

    // Parse English date with German Locale
    
    
    // Parse German date with English Locale, specifying German Locale override
    
    
    /**
     * This checks that this is a 7 element iterator of Calendar objects
     * that are dates (no time), and exactly 1 day spaced after each other.
     */
    private static void assertWeekIterator(final Iterator<?> it, final Calendar start) {
        final Calendar end = (Calendar) start.clone();
        end.add(Calendar.DATE, 6);

        assertWeekIterator(it, start, end);
    }

    /**
     * Convenience method for when working with Date objects
     */
    private static void assertWeekIterator(final Iterator<?> it, final Date start, final Date end) {
        final Calendar calStart = Calendar.getInstance();
        calStart.setTime(start);
        final Calendar calEnd = Calendar.getInstance();
        calEnd.setTime(end);

        assertWeekIterator(it, calStart, calEnd);
    }

    /**
     * This checks that this is a 7 divisble iterator of Calendar objects
     * that are dates (no time), and exactly 1 day spaced after each other
     * (in addition to the proper start and stop dates)
     */
    private static void assertWeekIterator(final Iterator<?> it, final Calendar start, final Calendar end) {
        Calendar cal = (Calendar) it.next();
        assertCalendarsEquals("", start, cal, 0);
        Calendar last = null;
        int count = 1;
        while (it.hasNext()) {
            //Check this is just a date (no time component)
            assertCalendarsEquals("", cal, DateUtils.truncate(cal, Calendar.DATE), 0);

            last = cal;
            cal = (Calendar) it.next();
            count++;

            //Check that this is one day more than the last date
            last.add(Calendar.DATE, 1);
            assertCalendarsEquals("", last, cal, 0);
        }
        if (count % 7 != 0) {
            throw new AssertionFailedError("There were " + count + " days in this iterator");
        }
        assertCalendarsEquals("", end, cal, 0);
    }

    /**
     * Used to check that Calendar objects are close enough
     * delta is in milliseconds
     */
    private static void assertCalendarsEquals(final String message, final Calendar cal1, final Calendar cal2, final long delta) {
        if (Math.abs(cal1.getTime().getTime() - cal2.getTime().getTime()) > delta) {
            throw new AssertionFailedError(
                    message + " expected " + cal1.getTime() + " but got " + cal2.getTime());
        }
    }

    void warn(final String msg) {
        System.err.println(msg);
    }
}

