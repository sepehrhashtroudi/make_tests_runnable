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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for DateTime.
 *
 * @author Stephen Colebourne
 */
public class TestDateTime_Basics extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    // the default time zone is set to LONDON in setUp()
    // we have to hard code LONDON here (instead of ISOChronology.getInstance() etc.)
    // as TestAll sets up a different time zone for better all-round testing
    private static final ISOChronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final ISOChronology ISO_DEFAULT = ISOChronology.getInstance(LONDON);
    private static final ISOChronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final GJChronology GJ_DEFAULT = GJChronology.getInstance(LONDON);
    private static final GregorianChronology GREGORIAN_DEFAULT = GregorianChronology.getInstance(LONDON);
    private static final GregorianChronology GREGORIAN_PARIS = GregorianChronology.getInstance(PARIS);
    private static final BuddhistChronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();
    private static final BuddhistChronology BUDDHIST_DEFAULT = BuddhistChronology.getInstance(LONDON);
    private static final CopticChronology COPTIC_DEFAULT = CopticChronology.getInstance(LONDON);
    
    long y2002days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365;
    long y2003days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365 + 365;
    
    // 2002-06-09
    private long TEST_TIME_NOW =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    // 2002-04-05
    private long TEST_TIME1 =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    // 2003-05-06
    private long TEST_TIME2 =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDateTime_Basics.class);
    }

    public TestDateTime_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
    }

    //-----------------------------------------------------------------------

public void testPlusYears_int151() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.plusYears(1); 
     DateTime expected = new DateTime(2003, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plusYears(0); 
     assertSame(test, result); 
 } 


public void testWithers410() { 
     DateTime test = new DateTime(1970, 6, 9, 10, 20, 30, 40, GJ_DEFAULT); 
     check(test.withYear(2000), 2000, 6, 9, 10, 20, 30, 40); 
     check(test.withMonthOfYear(2), 1970, 2, 9, 10, 20, 30, 40); 
     check(test.withDayOfMonth(2), 1970, 6, 2, 10, 20, 30, 40); 
     check(test.withDayOfYear(6), 1970, 1, 6, 10, 20, 30, 40); 
     check(test.withDayOfWeek(6), 1970, 6, 13, 10, 20, 30, 40); 
     check(test.withWeekOfWeekyear(6), 1970, 2, 3, 10, 20, 30, 40); 
     check(test.withWeekyear(1971), 1971, 6, 15, 10, 20, 30, 40); 
     check(test.withYearOfCentury(60), 1960, 6, 9, 10, 20, 30, 40); 
     check(test.withCenturyOfEra(21), 2070, 6, 9, 10, 20, 30, 40); 
     check(test.withYearOfEra(1066), 1066, 6, 9, 10, 20, 30, 40); 
     check(test.withEra(DateTimeConstants.BC), -1970, 6, 9, 10, 20, 30, 40); 
     check(test.withHourOfDay(6), 1970, 6, 9, 6, 20, 30, 40); 
     check(test.withMinuteOfHour(6), 1970, 6, 9, 10, 6, 30, 40); 
     check(test.withSecondOfMinute(6), 1970, 6, 9, 10, 20, 6, 40); 
     check(test.withMillisOfSecond(6), 1970, 6, 9, 10, 20, 30, 6); 
     check(test.withMillisOfDay(61234), 1970, 6, 9, 0, 1, 1, 234); 
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


public void testToDateTimeISO580() { 
     DateTime test = new DateTime(TEST_TIME1); 
     DateTime result = test.toDateTimeISO(); 
     assertSame(test, result); 
     test = new DateTime(TEST_TIME1, ISO_PARIS); 
     result = test.toDateTimeISO(); 
     assertSame(DateTime.class, result.getClass()); 
     assertSame(ISOChronology.class, result.getChronology().getClass()); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_PARIS, result.getChronology()); 
     assertNotSame(test, result); 
     test = new DateTime(TEST_TIME1, BUDDHIST_DEFAULT); 
     result = test.toDateTimeISO(); 
     assertSame(DateTime.class, result.getClass()); 
     assertSame(ISOChronology.class, result.getChronology().getClass()); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     assertNotSame(test, result); 
     test = new DateTime(TEST_TIME1, new MockNullZoneChronology()); 
     result = test.toDateTimeISO(); 
     assertSame(DateTime.class, result.getClass()); 
     assertSame(ISOChronology.class, result.getChronology().getClass()); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     assertNotSame(test, result); 
 } 


public void testToDateTime_DateTimeZone581() { 
     DateTime test = new DateTime(TEST_TIME1); 
     DateTime result = test.toDateTime(LONDON); 
     assertSame(test, result); 
     test = new DateTime(TEST_TIME1); 
     result = test.toDateTime(PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(PARIS, result.getZone()); 
     test = new DateTime(TEST_TIME1, PARIS); 
     result = test.toDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(LONDON, result.getZone()); 
     test = new DateTime(TEST_TIME1); 
     result = test.toDateTime((DateTimeZone) null); 
     assertSame(test, result); 
 } 


public void testToDateTime_Chronology582() { 
     DateTime test = new DateTime(TEST_TIME1); 
     DateTime result = test.toDateTime(ISO_DEFAULT); 
     assertSame(test, result); 
     test = new DateTime(TEST_TIME1); 
     result = test.toDateTime(GREGORIAN_PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(GREGORIAN_PARIS, result.getChronology()); 
     test = new DateTime(TEST_TIME1, GREGORIAN_PARIS); 
     result = test.toDateTime((Chronology) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateTime(TEST_TIME1); 
     result = test.toDateTime((Chronology) null); 
     assertSame(test, result); 
 } 


public void testWithDate_int_int_int583() { 
     DateTime test = new DateTime(2002, 4, 5, 1, 2, 3, 4, ISO_UTC); 
     DateTime result = test.withDate(2003, 5, 6); 
     DateTime expected = new DateTime(2003, 5, 6, 1, 2, 3, 4, ISO_UTC); 
     assertEquals(expected, result); 
     test = new DateTime(TEST_TIME1); 
     try { 
         test.withDate(2003, 13, 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithTime_int_int_int584() { 
     DateTime test = new DateTime(TEST_TIME1 - 12345L, BUDDHIST_UTC); 
     DateTime result = test.withTime(12, 24, 0, 0); 
     assertEquals(TEST_TIME1, result.getMillis()); 
     assertEquals(BUDDHIST_UTC, result.getChronology()); 
     test = new DateTime(TEST_TIME1); 
     try { 
         test.withTime(25, 1, 1, 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


@SuppressWarnings("deprecation") 
 public void testWithFields_RPartial585() { 
     DateTime test = new DateTime(2004, 5, 6, 7, 8, 9, 0); 
     DateTime result = test.withFields(new YearMonthDay(2003, 4, 5)); 
     DateTime expected = new DateTime(2003, 4, 5, 7, 8, 9, 0); 
     assertEquals(expected, result); 
     test = new DateTime(TEST_TIME1); 
     result = test.withFields(null); 
     assertSame(test, result); 
 } 


public void testWithField2586() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     try { 
         test.withField(null, 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithFieldAdded2587() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithFieldAdded4588() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime result = test.withFieldAdded(DurationFieldType.years(), 0); 
     assertSame(test, result); 
 } 


public void testWithFieldAdded1589() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime result = test.withFieldAdded(DurationFieldType.years(), 6); 
     assertEquals(new DateTime(2004, 6, 9, 0, 0, 0, 0), test); 
     assertEquals(new DateTime(2010, 6, 9, 0, 0, 0, 0), result); 
 } 


public void testWithDurationAdded_RD_int590() { 
     DateTime test = new DateTime(TEST_TIME1, BUDDHIST_DEFAULT); 
     DateTime result = test.withDurationAdded(new Duration(123456789L), 1); 
     DateTime expected = new DateTime(TEST_TIME1 + 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.withDurationAdded(null, 1); 
     assertSame(test, result); 
     result = test.withDurationAdded(new Duration(123456789L), 0); 
     assertSame(test, result); 
     result = test.withDurationAdded(new Duration(123456789L), 2); 
     expected = new DateTime(TEST_TIME1 + (2L * 123456789L), BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.withDurationAdded(new Duration(123456789L), -3); 
     expected = new DateTime(TEST_TIME1 - (3L * 123456789L), BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
 } 


public void testWithDurationAdded_long_int591() { 
     DateTime test = new DateTime(TEST_TIME1, BUDDHIST_DEFAULT); 
     DateTime result = test.withDurationAdded(123456789L, 1); 
     DateTime expected = new DateTime(TEST_TIME1 + 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.withDurationAdded(123456789L, 0); 
     assertSame(test, result); 
     result = test.withDurationAdded(123456789L, 2); 
     expected = new DateTime(TEST_TIME1 + (2L * 123456789L), BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.withDurationAdded(123456789L, -3); 
     expected = new DateTime(TEST_TIME1 - (3L * 123456789L), BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
 } 


public void testPlus_RP592() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.plus(new Period(1, 2, 3, 4, 5, 6, 7, 8)); 
     DateTime expected = new DateTime(2003, 7, 28, 6, 8, 10, 12, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plus((ReadablePeriod) null); 
     assertSame(test, result); 
 } 


public void testPlus_long593() { 
     DateTime test = new DateTime(TEST_TIME1, BUDDHIST_DEFAULT); 
     DateTime result = test.plus(123456789L); 
     DateTime expected = new DateTime(TEST_TIME1 + 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
 } 


public void testPlusMonths_int594() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.plusMonths(1); 
     DateTime expected = new DateTime(2002, 6, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plusMonths(0); 
     assertSame(test, result); 
 } 


public void testPlusDays_int596() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.plusDays(1); 
     DateTime expected = new DateTime(2002, 5, 4, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plusDays(0); 
     assertSame(test, result); 
 } 


public void testPlusMillis_int598() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.plusMillis(1); 
     DateTime expected = new DateTime(2002, 5, 3, 1, 2, 3, 5, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plusMillis(0); 
     assertSame(test, result); 
 } 


public void testMinus_long599() { 
     DateTime test = new DateTime(TEST_TIME1, BUDDHIST_DEFAULT); 
     DateTime result = test.minus(123456789L); 
     DateTime expected = new DateTime(TEST_TIME1 - 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
 } 


public void testMinusMonths_int600() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusMonths(1); 
     DateTime expected = new DateTime(2002, 4, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
 } 


public void testMinusWeeks_int601() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusWeeks(1); 
     DateTime expected = new DateTime(2002, 4, 26, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusWeeks(0); 
     assertSame(test, result); 
 } 


public void testMinusDays_int602() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusDays(1); 
     DateTime expected = new DateTime(2002, 5, 2, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 } 


public void testMinusHours_int604() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusHours(1); 
     DateTime expected = new DateTime(2002, 5, 3, 0, 2, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusHours(0); 
     assertSame(test, result); 
 } 


public void testMinusMinutes_int605() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusMinutes(1); 
     DateTime expected = new DateTime(2002, 5, 3, 1, 1, 3, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusMinutes(0); 
     assertSame(test, result); 
 } 


public void testMinusSeconds_int606() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusSeconds(1); 
     DateTime expected = new DateTime(2002, 5, 3, 1, 2, 2, 4, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusSeconds(0); 
     assertSame(test, result); 
 } 


public void testMinusMillis_int607() { 
     DateTime test = new DateTime(2002, 5, 3, 1, 2, 3, 4, BUDDHIST_DEFAULT); 
     DateTime result = test.minusMillis(1); 
     DateTime expected = new DateTime(2002, 5, 3, 1, 2, 3, 3, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusMillis(0); 
     assertSame(test, result); 
 } 


public void testProperty608() { 
     DateTime test = new DateTime(); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     DateTimeFieldType bad = new DateTimeFieldType("bad") { 
  
         private static final long serialVersionUID = 1L; 
  
         public DurationFieldType getDurationType() { 
             return DurationFieldType.weeks(); 
         } 
  
         public DurationFieldType getRangeDurationType() { 
             return null; 
         } 
  
         public DateTimeField getField(Chronology chronology) { 
             return UnsupportedDateTimeField.getInstance(this, UnsupportedDurationField.getInstance(getDurationType())); 
         } 
     }; 
     try { 
         test.property(bad); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


@SuppressWarnings("deprecation") 
 public void testToTimeOfDay609() { 
     DateTime base = new DateTime(TEST_TIME1, COPTIC_DEFAULT); 
     TimeOfDay test = base.toTimeOfDay(); 
     assertEquals(new TimeOfDay(TEST_TIME1, COPTIC_DEFAULT), test); 
 } 


public void testToLocalDateTime610() { 
     DateTime base = new DateTime(TEST_TIME1, COPTIC_DEFAULT); 
     LocalDateTime test = base.toLocalDateTime(); 
     assertEquals(new LocalDateTime(TEST_TIME1, COPTIC_DEFAULT), test); 
 } 


public void testToLocalTime611() { 
     DateTime base = new DateTime(TEST_TIME1, COPTIC_DEFAULT); 
     LocalTime test = base.toLocalTime(); 
     assertEquals(new LocalTime(TEST_TIME1, COPTIC_DEFAULT), test); 
 } 


public void testToString_String_Locale1402() { 
     DateTime test = new DateTime(TEST_TIME_NOW); 
     assertEquals("Sun 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("dim. 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, Locale.ENGLISH)); 
     assertEquals("Sun 9/6", test.toString("EEE d/M", null)); 
     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, null)); 
 } 


public void testToInstant1405() { 
     DateTime test = new DateTime(TEST_TIME1); 
     Instant result = test.toInstant(); 
     assertEquals(TEST_TIME1, result.getMillis()); 
 } 


public void testToMutableDateTime_DateTimeZone1407() { 
     DateTime test = new DateTime(TEST_TIME1); 
     MutableDateTime result = test.toMutableDateTime(LONDON); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateTime(TEST_TIME1); 
     result = test.toMutableDateTime(PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_PARIS, result.getChronology()); 
     test = new DateTime(TEST_TIME1, PARIS); 
     result = test.toMutableDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateTime(TEST_TIME1); 
     result = test.toMutableDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
 } 


@SuppressWarnings("deprecation") 
 public void testToString_DTFormatter1413() { 
     DateMidnight test = new DateMidnight(TEST_TIME_NOW); 
     assertEquals("2002 00", test.toString(DateTimeFormat.forPattern("yyyy HH"))); 
     assertEquals("2002-06-09T00:00:00.000+01:00", test.toString((DateTimeFormatter) null)); 
 } 

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    
    
    class MockInstant extends AbstractInstant {
        public String toString() {
            return null;
        }
        public long getMillis() {
            return TEST_TIME1;
        }
        public Chronology getChronology() {
            return ISO_DEFAULT;
        }
    }

    class MockEqualsChronology extends BaseChronology {
        private static final long serialVersionUID = 1L;
        public boolean equals(Object obj) {
            return obj instanceof MockEqualsChronology;
        }
        public DateTimeZone getZone() {
            return null;
        }
        public Chronology withUTC() {
            return this;
        }
        public Chronology withZone(DateTimeZone zone) {
            return this;
        }
        public String toString() {
            return "";
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
    private void check(DateTime test, int year, int month, int day, int hour, int min, int sec, int mil) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(mil, test.getMillisOfSecond());
    }

}
