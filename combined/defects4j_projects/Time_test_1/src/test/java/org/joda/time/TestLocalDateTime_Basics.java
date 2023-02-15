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
public void testIsSupported_DateTimeFieldType647() { 
     LocalDateTime test = new LocalDateTime(); 
     assertEquals(false, test.isSupported(DateTimeFieldType.era())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.centuryOfEra())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.yearOfCentury())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.yearOfEra())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.year())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.monthOfYear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfMonth())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.weekyear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfWeek())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfYear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.halfdayOfDay())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.hourOfHalfday())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.clockhourOfDay())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.clockhourOfHalfday())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.hourOfDay())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.minuteOfHour())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.minuteOfDay())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.secondOfMinute())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.secondOfDay())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.millisOfSecond())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.millisOfDay()));
}

public void testToDateTime648() { 
     LocalDateTime base = new LocalDateTime(2005, 6, 9, 6, 7, 8, 9, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9, COPTIC_LONDON); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTime(); 
     check(base, 2005, 6, 9, 6, 7, 8, 9); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.year().setCopy(2005); 
     expected = expected.monthOfYear().setCopy(6); 
     expected = expected.dayOfMonth().setCopy(9); 
     assertEquals(expected, test); 
 }
public void testWithDate_int_int_int650() { 
     LocalDateTime test = new LocalDateTime(2002, 4, 5, 10, 20, 30, 40); 
     LocalDateTime result = test.withDate(2003, 5, 6); 
     check(test, 2003, 5, 6, 10, 20, 30, 40); 
     check(result, 2003, 5, 6, 10, 20, 30, 40); 
 }
public void testMinusMillis_int653() { 
     LocalDateTime test = new LocalDateTime(2002, 5, 3, 10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalDateTime result = test.minusMillis(1); 
     LocalDateTime expected = new LocalDateTime(2002, 5, 3, 10, 20, 30, 41, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusMillis(0); 
     assertSame(test, result); 
 }
public void testProperty655() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     assertEquals(test.millisOfDay(), test.property(DateTimeFieldType.millisOfDay())); 
     assertEquals(test, test.property(DateTimeFieldType.minuteOfHour()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.secondOfMinute()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.millisOfDay()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.hourOfHalfday()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.halfdayOfDay()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfHalfday()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfDay()).getLocalDateTime()); 
     try { 
         test.property(DateTimeFieldType.dayOfWeek()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testProperty656() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     assertEquals(test.millisOfDay(), test.property(DateTimeFieldType.millisOfDay())); 
     assertEquals(test, test.property(DateTimeFieldType.minuteOfHour()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.secondOfDay()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.millisOfDay()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.hourOfHalfday()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.halfdayOfDay()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfHalfday()).getLocalDateTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfDay()).getLocalDateTime()); 
     try { 
         test.property(DateTimeFieldType.dayOfWeek()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyGetEra657() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().era(), test.era().getField()); 
     assertEquals("era", test.era().getName()); 
     assertEquals("Property[era]", test.era().toString()); 
     assertSame(test, test.era().getLocalDateTime()); 
     assertEquals(20, test.era().get()); 
     assertEquals("20", test.era().getAsString()); 
     assertEquals("20", test.era().getAsText()); 
     assertEquals("20", test.era().getField().getAsText(1, Locale.ENGLISH)); 
     assertEquals("ap. J.-C.", test.era().getAsText(Locale.FRENCH)); 
     assertEquals("20", test.era().getField().getAsText(1, Locale.FRENCH)); 
     assertEquals("20", test.era().getAsShortText()); 
     assertEquals("20", test.era().getField().getAsShortText(1, Locale.ENGLISH)); 
     assertEquals("ap. J.-C.", test.era().getAsShortText(Locale.FRENCH)); 
     assertEquals("ap. J.-C.", test.era().getField().getAsShortText(1, Locale.FRENCH)); 
     assertEquals(test.getChronology().eras(), test.era().getDurationField()); 
     assertEquals(null, test.era().getRangeDurationField()); 
     assertEquals(2, test.era().getMaximumTextLength(null)); 
     assertEquals(9, test.era().getMaximumTextLength(Locale.FRENCH)); 
     assertEquals(2, test.era().getMaximumShortTextLength(null)); 
     assertEquals(9, test.era().getMaximumShortTextLength(Locale.FRENCH)); 
 }
public void testPropertyGetCenturyOfEra658() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().centuryOfEra(), test.centuryOfEra().getField()); 
     assertEquals("centuryOfEra", test.centuryOfEra().getName()); 
     assertEquals("Property[centuryOfEra]", test.centuryOfEra().toString()); 
     assertSame(test, test.centuryOfEra().getLocalDateTime()); 
     assertEquals(20, test.centuryOfEra().get()); 
     assertEquals("20", test.centuryOfEra().getAsString()); 
     assertEquals("20", test.centuryOfEra().getAsText()); 
     assertEquals("20", test.centuryOfEra().getAsText(Locale.FRENCH)); 
     assertEquals("20", test.centuryOfEra().getAsShortText()); 
     assertEquals("20", test.centuryOfEra().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().centuries(), test.centuryOfEra().getDurationField()); 
     assertEquals(test.getChronology().eras(), test.centuryOfEra().getRangeDurationField()); 
     assertEquals(7, test.centuryOfEra().getMaximumTextLength(null)); 
     assertEquals(7, test.centuryOfEra().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetYearOfCentury659() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().yearOfCentury(), test.yearOfCentury().getField()); 
     assertEquals("yearOfCentury", test.yearOfCentury().getName()); 
     assertEquals("Property[yearOfCentury]", test.yearOfCentury().toString()); 
     assertSame(test, test.yearOfCentury().getLocalDateTime()); 
     assertEquals(4, test.yearOfCentury().get()); 
     assertEquals("4", test.yearOfCentury().getAsString()); 
     assertEquals("4", test.yearOfCentury().getAsText()); 
     assertEquals("4", test.yearOfCentury().getAsText(Locale.FRENCH)); 
     assertEquals("4", test.yearOfCentury().getAsShortText()); 
     assertEquals("4", test.yearOfCentury().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.yearOfCentury().getDurationField()); 
     assertEquals(test.getChronology().centuries(), test.yearOfCentury().getRangeDurationField()); 
     assertEquals(2, test.yearOfCentury().getMaximumTextLength(null)); 
     assertEquals(2, test.yearOfCentury().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetYearOfEra660() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().yearOfEra(), test.yearOfEra().getField()); 
     assertEquals("yearOfEra", test.yearOfEra().getName()); 
     assertEquals("Property[yearOfEra]", test.yearOfEra().toString()); 
     assertSame(test, test.yearOfEra().getLocalDateTime()); 
     assertEquals(2005, test.yearOfEra().get()); 
     assertEquals("2005", test.yearOfEra().getAsString()); 
     assertEquals("2005", test.yearOfEra().getAsText()); 
     assertEquals("2005", test.yearOfEra().getAsText(Locale.FRENCH)); 
     assertEquals("2005", test.yearOfEra().getAsShortText()); 
     assertEquals("2005", test.yearOfEra().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.yearOfEra().getDurationField()); 
     assertEquals(test.getChronology().eras(), test.yearOfEra().getRangeDurationField()); 
     assertEquals(9, test.yearOfEra().getMaximumTextLength(null)); 
     assertEquals(9, test.yearOfEra().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetWeekyear661() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().weekyear(), test.weekyear().getField()); 
     assertEquals("weekyear", test.weekyear().getName()); 
     assertEquals("Property[weekyear]", test.weekyear().toString()); 
     assertSame(test, test.weekyear().getLocalDateTime()); 
     assertEquals(2005, test.weekyear().get()); 
     assertEquals("2005", test.weekyear().getAsString()); 
     assertEquals("2005", test.weekyear().getAsText()); 
     assertEquals("2005", test.weekyear().getAsText(Locale.FRENCH)); 
     assertEquals("2005", test.weekyear().getAsShortText()); 
     assertEquals("2005", test.weekyear().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().weekyears(), test.weekyear().getDurationField()); 
     assertEquals(null, test.weekyear().getRangeDurationField()); 
     assertEquals(9, test.weekyear().getMaximumTextLength(null)); 
     assertEquals(9, test.weekyear().getMaximumShortTextLength(null)); 
 }
public void testPropertySetWeekOfWeekyear662() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 7, 10, 20, 30, 40); 
     LocalDateTime copy = test.weekOfWeekyear().setCopy(4); 
     check(test, 2005, 6, 7, 10, 20, 30, 40); 
     check(copy, 2005, 6, 7, 10, 20, 30, 40); 
     try { 
         test.weekOfWeekyear().setCopy(54); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.weekOfWeekyear().setCopy(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyAddToCopyMonth664() { 
     LocalDateTime test = new LocalDateTime(1972, 6, 9, 10, 20, 30, 40); 
     LocalDateTime copy = test.monthOfYear().addToCopy(6); 
     check(test, 1972, 6, 9, 10, 20, 30, 40); 
     check(copy, 1972, 12, 9, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(7); 
     check(copy, 1973, 1, 9, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(-5); 
     check(copy, 1972, 1, 9, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(-6); 
     check(copy, 1971, 12, 9, 10, 20, 30, 40); 
     test = new LocalDateTime(1972, 1, 31, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(1); 
     check(copy, 1972, 2, 29, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(2); 
     check(copy, 1972, 3, 31, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(3); 
     check(copy, 1972, 4, 30, 10, 20, 30, 40); 
     test = new LocalDateTime(1971, 1, 31, 10, 20, 30, 40); 
     copy = test.monthOfYear().addToCopy(1); 
     check(copy, 1971, 2, 28, 10, 20, 30, 40); 
 }
public void testPropertyWithMaxMinValueHour665() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 0, 20, 30, 40); 
     check(test.hourOfDay().withMaximumValue(), 2005, 6, 9, 23, 20, 30, 40); 
     check(test.hourOfDay().withMinimumValue(), 2005, 6, 9, 0, 20, 30, 40); 
 }
public void testToString_DTFormatter666() { 
     LocalDateTime test = new LocalDateTime(2002, 6, 9, 10, 20, 30, 40); 
     assertEquals("2002 10", test.toString(DateTimeFormat.forPattern("yyyy HH"))); 
     assertEquals("2002-06-09T10:20:30.040", test.toString((DateTimeFormatter) null)); 
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
