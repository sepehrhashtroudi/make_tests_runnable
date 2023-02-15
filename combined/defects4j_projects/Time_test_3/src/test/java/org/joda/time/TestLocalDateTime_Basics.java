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
public void testEqualsHashCode_ISO104() { 
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
public void testParse_noFormatter151() throws Throwable { 
     assertEquals(new LocalDate(2010, 6, 30), LocalDate.parse("2010-06-30")); 
     assertEquals(new LocalDate(2010, 1, 2), LocalDate.parse("2010-002")); 
 }
public void testGet_DateTimeFieldType512() { 
     LocalDate test = new LocalDate(); 
     assertEquals(1970, test.get(DateTimeFieldType.year())); 
     assertEquals(6, test.get(DateTimeFieldType.monthOfYear())); 
     assertEquals(9, test.get(DateTimeFieldType.dayOfMonth())); 
     assertEquals(2, test.get(DateTimeFieldType.dayOfWeek())); 
     assertEquals(160, test.get(DateTimeFieldType.dayOfYear())); 
     assertEquals(24, test.get(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(1970, test.get(DateTimeFieldType.weekyear())); 
     try { 
         test.get(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.get(DateTimeFieldType.hourOfDay()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testMinusMinutes_int517() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.minusMinutes(1); 
     LocalTime expected = new LocalTime(1, 1, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusMinutes(0); 
     assertSame(test, result); 
 }
public void testFactory_fromCalendarFields546() throws Exception { 
     GregorianCalendar cal = new GregorianCalendar(1970, 1, 3, 4, 5, 6); 
     cal.set(Calendar.MILLISECOND, 7); 
     LocalDateTime expected = new LocalDateTime(1970, 2, 3, 4, 5, 6, 7); 
     assertEquals(expected, LocalDateTime.fromCalendarFields(cal)); 
     try { 
         LocalDateTime.fromCalendarFields((Calendar) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyWithMaxMinValueHour552() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 0, 20, 30, 40); 
     check(test.hourOfDay().withMaximumValue(), 2005, 6, 9, 23, 20, 30, 40); 
     check(test.hourOfDay().withMinimumValue(), 2005, 6, 9, 0, 20, 30, 40); 
 }
public void testPropertyHashCode553() { 
     LocalDateTime test1 = new LocalDateTime(2005, 11, 8, 10, 20, 30, 40); 
     LocalDateTime test2 = new LocalDateTime(2005, 11, 9, 10, 20, 30, 40); 
     assertEquals(true, test1.dayOfMonth().hashCode() == test1.dayOfMonth().hashCode()); 
     assertEquals(false, test1.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); 
     assertEquals(true, test1.monthOfYear().hashCode() == test1.monthOfYear().hashCode()); 
     assertEquals(true, test1.monthOfYear().hashCode() == test2.monthOfYear().hashCode()); 
 }
public void testProperty554() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40, GJ_UTC); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); 
     assertEquals(test.dayOfYear(), test.property(DateTimeFieldType.dayOfYear())); 
     assertEquals(test.weekOfWeekyear(), test.property(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(test.weekyear(), test.property(DateTimeFieldType.weekyear())); 
     assertEquals(test.yearOfCentury(), test.property(DateTimeFieldType.yearOfCentury())); 
     assertEquals(test.yearOfEra(), test.property(DateTimeFieldType.yearOfEra())); 
     assertEquals(test.centuryOfEra(), test.property(DateTimeFieldType.centuryOfEra())); 
     assertEquals(test.era(), test.property(DateTimeFieldType.era())); 
     assertEquals(test.hourOfDay(), test.property(DateTimeFieldType.hourOfDay())); 
     assertEquals(test.minuteOfHour(), test.property(DateTimeFieldType.minuteOfHour())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     assertEquals(test.millisOfDay(), test.property(DateTimeFieldType.millisOfDay())); 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     assertEquals(test, test.property(DateTimeFieldType.minuteOfDay()).getLocalDateTime()); 
 }
public void testIsAfter_LocalDateTime555() { 
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
public void testToDate_springDST_2Hour40Savings556() { 
     LocalDateTime base = new LocalDateTime(2007, 4, 2, 0, 20, 30, 0); 
     SimpleTimeZone testZone = new SimpleTimeZone(3600000, "NoMidnight", Calendar.APRIL, 2, 0, 0, Calendar.OCTOBER, 2, 0, 3600000, (3600000 / 6) * 16); 
     TimeZone currentZone = TimeZone.getDefault(); 
     try { 
         TimeZone.setDefault(testZone); 
         Date test = base.toDate(); 
         check(base, 2007, 4, 2, 0, 20, 30, 0); 
         assertEquals("Mon Apr 02 01:40:00 GMT+03:40 2007", test.toString()); 
     } finally { 
         TimeZone.setDefault(currentZone); 
     } 
 }
public void testToDate_autumnDST557() { 
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
public void testToDate_autumnDST_Zone558() { 
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
public void testToDate_springDST559() { 
     LocalDateTime base = new LocalDateTime(2007, 4, 2, 0, 20, 0, 0); 
     SimpleTimeZone testZone = new SimpleTimeZone(3600000, "NoMidnight", Calendar.APRIL, 2, 0, 0, Calendar.OCTOBER, 2, 0, 3600000); 
     TimeZone currentZone = TimeZone.getDefault(); 
     try { 
         TimeZone.setDefault(testZone); 
         Date test = base.toDate(); 
         check(base, 2007, 4, 2, 0, 20, 0, 0); 
         assertEquals("Mon Apr 02 01:00:00 GMT+02:00 2007", test.toString()); 
     } finally { 
         TimeZone.setDefault(currentZone); 
     } 
 }
public void testToDate_autumnDST560() { 
     LocalDateTime base = new LocalDateTime(2007, 10, 2, 0, 20, 0, 0); 
     SimpleTimeZone testZone = new SimpleTimeZone(3600000, "NoMidnight", Calendar.APRIL, 2, 0, 0, Calendar.OCTOBER, 2, 0, 3600000); 
     TimeZone currentZone = TimeZone.getDefault(); 
     try { 
         TimeZone.setDefault(testZone); 
         Date test = base.toDate(); 
         check(base, 2007, 10, 2, 0, 20, 0, 0); 
         assertEquals("Tue Oct 02 00:20:00 GMT+02:00 2007", test.toString()); 
     } finally { 
         TimeZone.setDefault(currentZone); 
     } 
 }
public void testWithField_DateTimeFieldType_int_1561() { 
     LocalDateTime test = new LocalDateTime(2004, 6, 9, 10, 20, 30, 40); 
     LocalDateTime result = test.withField(DateTimeFieldType.year(), 2006); 
     assertEquals(new LocalDateTime(2004, 6, 9, 10, 20, 30, 40), test); 
     assertEquals(new LocalDateTime(2006, 6, 9, 10, 20, 30, 40), result); 
 }
public void testWithField_DateTimeFieldType_int_2562() { 
     LocalDateTime test = new LocalDateTime(2004, 6, 9, 10, 20, 30, 40); 
     try { 
         test.withField(null, 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithFieldAdded_DurationFieldType_int_2563() { 
     LocalDateTime test = new LocalDateTime(2004, 6, 9, 10, 20, 30, 40); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusHours_int564() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.plusHours(1); 
     LocalDateTime expected = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusHours(0); 
     assertSame(test, result); 
 }
public void testPlusMillis_int565() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.plusMillis(1); 
     LocalDateTime expected = new LocalDateTime(2002, 5, 3, 10, 20, 30, 39, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusMillis(0); 
     assertSame(test, result); 
 }
public void testMinusMonths_int566() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.minusMonths(1); 
     LocalDateTime expected = new LocalDateTime(2002, 4, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
 }
public void testMinusWeeks_int567() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.minusWeeks(1); 
     LocalDateTime expected = new LocalDateTime(2002, 4, 26, 10, 20, 30, 40, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusWeeks(0); 
     assertSame(test, result); 
 }
public void testMinusHours_int568() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.minusHours(1); 
     LocalDateTime expected = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusHours(0); 
     assertSame(test, result); 
 }
public void testGetters569() { 
     LocalDateTime test = new LocalDateTime(1970, 6, 9, 10, 20, 30, 40, GJ_UTC); 
     assertEquals(1970, test.getYear()); 
     assertEquals(6, test.getMonthOfYear()); 
     assertEquals(9, test.getDayOfMonth()); 
     assertEquals(160, test.getDayOfYear()); 
     assertEquals(2, test.getDayOfWeek()); 
     assertEquals(24, test.getWeekOfWeekyear()); 
     assertEquals(1970, test.getWeekyear()); 
     assertEquals(70, test.getYearOfCentury()); 
     assertEquals(20, test.getCenturyOfEra()); 
     assertEquals(1970, test.getYearOfEra()); 
     assertEquals(DateTimeConstants.AD, test.getEra()); 
     assertEquals(10, test.getHourOfDay()); 
     assertEquals(20, test.getMinuteOfHour()); 
     assertEquals(30, test.getSecondOfMinute()); 
     assertEquals(40, test.getMillisOfSecond()); 
     assertEquals(MILLIS_OF_DAY_UTC, test.getMillisOfDay()); 
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
