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
import org.joda.time.chrono.LenientChronology;
import org.joda.time.chrono.StrictChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for LocalDate.
 *
 * @author Stephen Colebourne
 */
public class TestLocalDate_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
//    private static final int OFFSET = 1;
    private static final GJChronology GJ_UTC = GJChronology.getInstanceUTC();
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
//    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final Chronology ISO_LONDON = ISOChronology.getInstance(LONDON);
//    private static final Chronology ISO_TOKYO = ISOChronology.getInstance(TOKYO);
//    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_PARIS = BuddhistChronology.getInstance(PARIS);
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
//    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();

    /** Mock zone simulating Asia/Gaza cutover at midnight 2007-04-01 */
    private static long CUTOVER_GAZA = 1175378400000L;
    private static int OFFSET_GAZA = 7200000;  // +02:00
    private static final DateTimeZone MOCK_GAZA = new MockZone(CUTOVER_GAZA, OFFSET_GAZA, 3600);

    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
//    private long TEST_TIME1 =
//        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 12L * DateTimeConstants.MILLIS_PER_HOUR
//        + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
//        
//    private long TEST_TIME2 =
//        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 14L * DateTimeConstants.MILLIS_PER_HOUR
//        + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private DateTimeZone zone = null;

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestLocalDate_Basics.class);
    }

    public TestLocalDate_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
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
public void testIsSupported_DurationFieldType300() { 
     LocalDate test = new LocalDate(); 
     assertEquals(false, test.isSupported(DurationFieldType.eras())); 
     assertEquals(true, test.isSupported(DurationFieldType.centuries())); 
     assertEquals(true, test.isSupported(DurationFieldType.years())); 
     assertEquals(true, test.isSupported(DurationFieldType.months())); 
     assertEquals(true, test.isSupported(DurationFieldType.weekyears())); 
     assertEquals(true, test.isSupported(DurationFieldType.weeks())); 
     assertEquals(true, test.isSupported(DurationFieldType.days())); 
     assertEquals(true, test.isSupported(DurationFieldType.hours())); 
     assertEquals(true, test.isSupported(DurationFieldType.minutes())); 
     assertEquals(true, test.isSupported(DurationFieldType.seconds())); 
     assertEquals(true, test.isSupported(DurationFieldType.millis())); 
 }
public void testParseLocalDate_year_month_week_2010301() { 
     Chronology chrono = GJChronology.getInstanceUTC(); 
     DateTimeFormatter f = DateTimeFormat.forPattern("yyyy-MM-ww").withChronology(chrono); 
     assertEquals(new LocalDate(2010, 1, 4, chrono), f.parseLocalDate("2010-01-01")); 
 }
public void testEqualsHashCode302() { 
     LocalDate test1 = new LocalDate(1970, 6, 9, GJ_UTC); 
     LocalDate test2 = new LocalDate(1970, 6, 9, GJ_UTC); 
     assertEquals(true, test1.equals(test2)); 
     assertEquals(true, test2.equals(test1)); 
     assertEquals(true, test1.equals(test1)); 
     assertEquals(true, test2.equals(test2)); 
     assertEquals(true, test1.hashCode() == test2.hashCode()); 
     assertEquals(true, test1.hashCode() == test1.hashCode()); 
     assertEquals(true, test2.hashCode() == test2.hashCode()); 
     LocalDate test3 = new LocalDate(1971, 6, 9); 
     assertEquals(false, test1.equals(test3)); 
     assertEquals(false, test2.equals(test3)); 
     assertEquals(false, test3.equals(test1)); 
     assertEquals(false, test3.equals(test2)); 
     assertEquals(false, test1.hashCode() == test3.hashCode()); 
     assertEquals(false, test2.hashCode() == test3.hashCode()); 
     assertEquals(false, test1.equals("Hello")); 
     assertEquals(true, test1.equals(new LocalDate(1970, 6, 9, GJ_UTC))); 
     assertEquals(false, test1.equals(new LocalDate(1971, 6, 9, GJ_UTC))); 
     assertEquals(false, test1.equals(new LocalDate(1971, 6, 9, GJ_UTC))); 
     assertEquals(false, test1.equals(new LocalDate(1971, 6, 9, GJ_UTC))); 
     assertEquals(false, test1.equals(new LocalDate(1971, 6, 9, GJ_UTC))); 
 }
public void testWithers303() { 
     LocalDate test = new LocalDate(1970, 6, 9, GJ_UTC); 
     check(test.withYear(2000), 2000, 6, 9); 
     check(test.withMonthOfYear(2), 1970, 2, 9); 
     check(test.withDayOfMonth(2), 1970, 6, 2); 
     check(test.withDayOfYear(6), 1970, 1, 6); 
     check(test.withDayOfWeek(6), 1970, 6, 13); 
     check(test.withWeekOfWeekyear(6), 1970, 2, 3); 
     check(test.withWeekyear(1971), 1971, 6, 15); 
     check(test.withYearOfCentury(60), 1960, 6, 9); 
     check(test.withCenturyOfEra(21), 2070, 6, 9); 
     check(test.withYearOfEra(1066), 1066, 6, 9); 
     check(test.withEra(DateTimeConstants.BC), -1970, 6, 9); 
     try { 
         test.withMonthOfYear(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withMonthOfYear(13); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToLocalDateTime_wrongChronologyLocalTime305() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     LocalTime tod = new LocalTime(12, 13, 14, 15, BUDDHIST_PARIS); 
     try { 
         base.toLocalDateTime(tod); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithField_DateTimeFieldType_int_2307() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     try { 
         test.withField(null, 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithFieldAdded_DurationFieldType_int_1308() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     LocalDate result = test.withFieldAdded(DurationFieldType.years(), 6); 
     assertEquals(new LocalDate(2004, 6, 9), test); 
     assertEquals(new LocalDate(2010, 6, 9), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_3309() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusDays_int310() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.plusDays(1); 
     LocalDate expected = new LocalDate(2002, 5, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusDays(0); 
     assertSame(test, result); 
 }
public void testMinusDays_int312() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.minusDays(1); 
     LocalDate expected = new LocalDate(2002, 5, 2, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 }
public void testWithFieldAdded_DurationFieldType_int_8440() { 
     LocalTime test = new LocalTime(0, 0, 0, 0); 
     LocalTime result = test.withFieldAdded(DurationFieldType.millis(), -1); 
     assertEquals(new LocalTime(23, 59, 59, 999), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.seconds(), -1); 
     assertEquals(new LocalTime(23, 59, 59, 0), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.minutes(), -1); 
     assertEquals(new LocalTime(23, 59, 0, 0), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.hours(), -1); 
     assertEquals(new LocalTime(23, 0, 0, 0), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_4442() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     LocalDate result = test.withFieldAdded(DurationFieldType.years(), 0); 
     assertSame(test, result); 
 }
public void testToDateTimeAtStartOfDay590() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtStartOfDay(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
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
            };
        }
        public int[] getValues() {
            return new int[] {1970, 6, 9};
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
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void check(LocalDate test, int hour, int min, int sec) {
        assertEquals(hour, test.getYear());
        assertEquals(min, test.getMonthOfYear());
        assertEquals(sec, test.getDayOfMonth());
    }
}
