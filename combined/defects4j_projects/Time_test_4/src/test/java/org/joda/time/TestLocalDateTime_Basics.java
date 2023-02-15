/*
 *  Copyright 2001-2013 Stephen Colebourne
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.joda.time;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for LocalDate.
 *
 * @author Stephen Colebourne
 */
public class TestLocalDateTime_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final GJChronology GJ_UTC = GJChronology.getInstanceUTC();
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology ISO_LONDON = ISOChronology.getInstance(LONDON);
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology GREGORIAN_UTC = GregorianChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);

//    private long TEST_TIME1 =
//        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 12L * DateTimeConstants.MILLIS_PER_HOUR
//        + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
//
//    private long TEST_TIME2 =
//        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 14L * DateTimeConstants.MILLIS_PER_HOUR
//        + 28L * DateTimeConstants.MILLIS_PER_MINUTE;

    private int MILLIS_OF_DAY_UTC =
        (int) (10L * DateTimeConstants.MILLIS_PER_HOUR
        + 20L * DateTimeConstants.MILLIS_PER_MINUTE
        + 30L * DateTimeConstants.MILLIS_PER_SECOND
        + 40L);

    private long TEST_TIME_NOW_UTC =
        (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY + MILLIS_OF_DAY_UTC;

    private DateTimeZone zone = null;

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestLocalDateTime_Basics.class);
    }

    public TestLocalDateTime_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW_UTC);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
        systemDefaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
        Locale.setDefault(systemDefaultLocale);
        systemDefaultLocale = null;
    }

    //-----------------------------------------------------------------------
public void testToDate_autumnDST7() { 
     LocalDateTime base = new LocalDateTime(2007, 10, 2, 0, 20, 30, 0); 
     SimpleTimeZone testZone = new SimpleTimeZone(3600000, "NoMidnight", Calendar.APRIL, 2, 0, 0, Calendar.OCTOBER, 2, 0, 3600000); 
     TimeZone currentZone = TimeZone.getDefault(); 
     try { 
         TimeZone.setDefault(testZone); 
         Date test = base.toDate(); 
         check(base, 2007, 10, 2, 0, 20, 30, 0); 
         assertEquals("Tue Oct 02 00:20:30 GMT+02:00 2007", test.toString()); 
     } finally { 
         TimeZone.setDefault(currentZone); 
     } 
 }
public void testIsBefore_YMD8() { 
     YearMonthDay test1 = new YearMonthDay(2005, 6, 2); 
     YearMonthDay test1a = new YearMonthDay(2005, 6, 2); 
     assertEquals(false, test1.isBefore(test1a)); 
     assertEquals(false, test1a.isBefore(test1)); 
     assertEquals(false, test1.isBefore(test1)); 
     assertEquals(false, test1a.isBefore(test1a)); 
     YearMonthDay test2 = new YearMonthDay(2005, 7, 2); 
     assertEquals(true, test1.isBefore(test2)); 
     assertEquals(false, test2.isBefore(test1)); 
     YearMonthDay test3 = new YearMonthDay(2005, 7, 2, GregorianChronology.getInstanceUTC()); 
     assertEquals(true, test1.isBefore(test3)); 
     assertEquals(false, test3.isBefore(test1)); 
     assertEquals(false, test3.isBefore(test2)); 
     try { 
         new YearMonthDay(2005, 7, 2).isBefore(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testEqualsHashCode_ISO126() { 
     Chronology chrono1 = ISOChronology.getInstanceUTC(); 
     Chronology chrono2 = ISOChronology.getInstanceUTC(); 
     Chronology chrono3 = ISOChronology.getInstance(); 
     assertEquals(true, chrono1.equals(chrono2)); 
     assertEquals(false, chrono1.equals(chrono3)); 
     DateTime dt1 = new DateTime(0L, chrono1); 
     DateTime dt2 = new DateTime(0L, chrono2); 
     DateTime dt3 = new DateTime(0L, chrono3); 
     assertEquals(true, dt1.equals(dt2)); 
     assertEquals(false, dt1.equals(dt3)); 
     assertEquals(true, chrono1.hashCode() == chrono2.hashCode()); 
     assertEquals(false, chrono1.hashCode() == chrono3.hashCode()); 
 }
public void testGetFieldType_int529() { 
     LocalDateTime test = new LocalDateTime(COPTIC_PARIS); 
     assertSame(DateTimeFieldType.year(), test.getFieldType(0)); 
     assertSame(DateTimeFieldType.monthOfYear(), test.getFieldType(1)); 
     assertSame(DateTimeFieldType.dayOfMonth(), test.getFieldType(2)); 
     assertSame(DateTimeFieldType.millisOfDay(), test.getFieldType(3)); 
     try { 
         test.getFieldType(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getFieldType(3); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 }
public void testIsAfter_LocalDateTime530() { 
     LocalDateTime test1 = new LocalDateTime(2005, 6, 2, 10, 20, 30, 40); 
     LocalDateTime test1a = new LocalDateTime(2005, 6, 2, 10, 20, 30, 40); 
     assertEquals(false, test1.isAfter(test1a)); 
     assertEquals(false, test1a.isAfter(test1)); 
     assertEquals(false, test1.isAfter(test1)); 
     assertEquals(false, test1a.isAfter(test1a)); 
     LocalDateTime test2 = new LocalDateTime(2005, 7, 2, 10, 20, 30, 40); 
     assertEquals(false, test1.isAfter(test2)); 
     assertEquals(true, test2.isAfter(test1)); 
     LocalDateTime test3 = new LocalDateTime(2005, 7, 2, 10, 20, 30, 40, GREGORIAN_UTC); 
     assertEquals(false, test1.isAfter(test3)); 
     assertEquals(true, test3.isAfter(test1)); 
     assertEquals(false, test3.isAfter(test2)); 
     try { 
         new LocalDateTime(2005, 7, 2, 10, 20, 30, 40).isAfter(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithTime_int_int_int532() { 
     LocalDateTime test = new LocalDateTime(2002, 6, 9, 10, 20, 30); 
     LocalDateTime result = test.withTime(12, 24, 0, 0); 
     assertEquals(new LocalDateTime(2002, 6, 9, 10, 20, 30), test); 
     assertEquals(new LocalDateTime(2002, 6, 9, 10, 20, 30), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_3533() { 
     LocalDateTime test = new LocalDateTime(2004, 6, 9, 10, 20, 30, 40); 
     LocalDateTime result = test.withFieldAdded(DurationFieldType.years(), 0); 
     assertSame(test, result); 
 }
public void testWithFieldAdded_DurationFieldType_int_4534() { 
     LocalDateTime test = new LocalDateTime(2004, 6, 9, 10, 20, 30, 40); 
     LocalDateTime result = test.withFieldAdded(DurationFieldType.years(), 0); 
     assertSame(test, result); 
 }
public void testMinusDays_int535() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.minusDays(1); 
     LocalDateTime expected = new LocalDateTime(2002, 5, 2, 10, 20, 30, 40, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 }
public void testToString_String539() { 
     LocalDateTime test = new LocalDateTime(1970, 6, 9, 10, 20, 30, 40); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("mar. 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("1970-06-09T10:20:30.040", test.toString(null, Locale.ENGLISH)); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", null)); 
     assertEquals("1970-06-09T10:20:30.040", test.toString(null, null)); 
 }
    

    

    

    

    

    

    

    

    

    

    
    
    class MockInstant extends MockPartial {
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.year(),
                COPTIC_UTC.monthOfYear(),
                COPTIC_UTC.dayOfMonth(),
                COPTIC_UTC.millisOfDay(),
            };
        }
        public int[] getValues() {
            return new int[] {1970, 6, 9, MILLIS_OF_DAY_UTC};
        }
    }

    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void check(LocalDateTime test, int year, int month, int day, int hour, int min, int sec, int mil) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(mil, test.getMillisOfSecond());
    }
}
