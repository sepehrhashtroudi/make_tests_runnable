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
 * This class is a Junit unit test for DateMidnight.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestDateMidnight_Basics extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone NEWYORK = DateTimeZone.forID("America/New_York");

    // the default time zone is set to LONDON in setUp()
    // we have to hard code LONDON here (instead of ISOChronology.getInstance() etc.)
    // as TestAll sets up a different time zone for better all-round testing
    private static final ISOChronology ISO_DEFAULT = ISOChronology.getInstance(LONDON);
    private static final ISOChronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final GJChronology GJ_DEFAULT = GJChronology.getInstance(LONDON);
    private static final GregorianChronology GREGORIAN_DEFAULT = GregorianChronology.getInstance(LONDON);
    private static final GregorianChronology GREGORIAN_PARIS = GregorianChronology.getInstance(PARIS);
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
    private long TEST_TIME_NOW_UTC =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
    private long TEST_TIME_NOW_LONDON =
            TEST_TIME_NOW_UTC - DateTimeConstants.MILLIS_PER_HOUR;
//    private long TEST_TIME_NOW_PARIS =
//            TEST_TIME_NOW_UTC - 2*DateTimeConstants.MILLIS_PER_HOUR;
            
    // 2002-04-05
    private long TEST_TIME1_UTC =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
    private long TEST_TIME1_LONDON =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            - DateTimeConstants.MILLIS_PER_HOUR;
    private long TEST_TIME1_PARIS =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            - 2*DateTimeConstants.MILLIS_PER_HOUR;
        
    // 2003-05-06
    private long TEST_TIME2_UTC =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    private long TEST_TIME2_LONDON =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
             - DateTimeConstants.MILLIS_PER_HOUR;
    private long TEST_TIME2_PARIS =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
             - 2*DateTimeConstants.MILLIS_PER_HOUR;
    
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDateMidnight_Basics.class);
    }

    public TestDateMidnight_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW_UTC);
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
public void testSetMonthOfYear_int_dstOverlapSummer_addZero97() { 
     MutableDateTime test = new MutableDateTime(2011, 10, 30, 2, 30, 0, 0, DateTimeZone.forID("Europe/Berlin")); 
     assertEquals("2011-10-30T02:30:00.000+02:00", test.toString()); 
     test.setMonthOfYear(10); 
     assertEquals("2011-10-30T02:30:00.000+02:00", test.toString()); 
 }
public void testPropertySetMonthOfYear406() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().setCopy(12); 
     assertEquals(2004, copy.getYear()); 
     assertEquals(12, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyCompareToMonthOfYear619() { 
     DateMidnight test1 = new DateMidnight(TEST_TIME1_UTC); 
     DateMidnight test2 = new DateMidnight(TEST_TIME2_UTC); 
     assertEquals(true, test1.monthOfYear().compareTo(test2) < 0); 
     assertEquals(true, test2.monthOfYear().compareTo(test1) > 0); 
     assertEquals(true, test1.monthOfYear().compareTo(test1) == 0); 
     try { 
         test1.monthOfYear().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1_UTC); 
     DateTime dt2 = new DateTime(TEST_TIME2_UTC); 
     assertEquals(true, test1.monthOfYear().compareTo(dt2) < 0); 
     assertEquals(true, test2.monthOfYear().compareTo(dt1) > 0); 
     assertEquals(true, test1.monthOfYear().compareTo(dt1) == 0); 
     try { 
         test1.monthOfYear().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testConstructor_long_nullDateTimeZone620() throws Throwable { 
     DateMidnight test = new DateMidnight(TEST_TIME1_UTC); 
     assertEquals(ISOChronology.getInstance(), test.getChronology()); 
     assertEquals(TEST_TIME1_LONDON, test.getMillis()); 
 }
public void testConstructor_long1_Chronology621() throws Throwable { 
     DateMidnight test = new DateMidnight(TEST_TIME1_UTC); 
     assertEquals(ISOChronology.getInstance(), test.getChronology()); 
     assertEquals(TEST_TIME1_LONDON, test.getMillis()); 
 }
public void testWithZoneRetainFields_DateTimeZone1625() { 
     DateMidnight test = new DateMidnight(TEST_TIME1_UTC); 
     DateMidnight result = test.withZoneRetainFields(PARIS); 
     assertEquals(TEST_TIME1_LONDON, test.getMillis()); 
     assertEquals(TEST_TIME1_PARIS, result.getMillis()); 
     assertEquals(PARIS, result.getChronology()); 
     test = new DateMidnight(TEST_TIME1_UTC, PARIS); 
     result = test.withZoneRetainFields(null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateMidnight(TEST_TIME1_UTC); 
     result = test.withZoneRetainFields(PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateMidnight(TEST_TIME1_UTC); 
     result = test.withZoneRetainFields(PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
     test = new DateMidnight(TEST_TIME1_UTC); 
     result = test.withZoneRetainFields(null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(ISO_DEFAULT, result.getChronology()); 
 }
@SuppressWarnings("deprecation") 
 public void testWithFields_RPartial628() { 
     DateMidnight test = new DateMidnight(2004, 5, 6); 
     DateMidnight result = test.withFields(new YearMonthDay(2003, 4, 5)); 
     DateMidnight expected = new DateMidnight(2003, 4, 5); 
     assertEquals(expected, result); 
     test = new DateMidnight(TEST_TIME1_UTC); 
     result = test.withFields(null); 
     assertSame(test, result); 
 }
public void testWithFieldAdded1630() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight result = test.withFieldAdded(DurationFieldType.years(), 6); 
     assertEquals(new DateMidnight(2004, 6, 9), test); 
     assertEquals(new DateMidnight(2010, 6, 9), result); 
 }
public void testPlus_long631() { 
     DateMidnight test = new DateMidnight(TEST_TIME1_UTC, BUDDHIST_DEFAULT); 
     DateMidnight result = test.plus(123456789L); 
     DateMidnight expected = new DateMidnight(test.getMillis() + 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plus((ReadableDuration) null); 
     assertSame(test, result); 
 }
public void testPlusMonths_int632() { 
     DateMidnight test = new DateMidnight(2002, 5, 3, BUDDHIST_DEFAULT); 
     DateMidnight result = test.plusMonths(1); 
     DateMidnight expected = new DateMidnight(2002, 6, 3, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.plusMonths(0); 
     assertSame(test, result); 
 }
public void testMinus_long633() { 
     DateMidnight test = new DateMidnight(TEST_TIME1_UTC, BUDDHIST_DEFAULT); 
     DateMidnight result = test.minus(123456789L); 
     DateMidnight expected = new DateMidnight(test.getMillis() - 123456789L, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
 }
public void testMinusMonths_int634() { 
     DateMidnight test = new DateMidnight(2002, 5, 3, BUDDHIST_DEFAULT); 
     DateMidnight result = test.minusMonths(1); 
     DateMidnight expected = new DateMidnight(2002, 4, 3, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
 }
public void testMinusWeeks_int635() { 
     DateMidnight test = new DateMidnight(2002, 5, 3, BUDDHIST_DEFAULT); 
     DateMidnight result = test.minusWeeks(1); 
     DateMidnight expected = new DateMidnight(2002, 4, 26, BUDDHIST_DEFAULT); 
     assertEquals(expected, result); 
     result = test.minusWeeks(0); 
     assertSame(test, result); 
 }
public void testWithers637() { 
     DateMidnight test = new DateMidnight(1970, 6, 9, GJ_DEFAULT); 
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
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    
    
    class MockInstant extends AbstractInstant {
        public String toString() {
            return null;
        }
        public long getMillis() {
            return TEST_TIME1_LONDON;
        }
        public Chronology getChronology() {
            return ISO_DEFAULT;
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
    private void check(DateMidnight test, int year, int month, int day) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
    }

}
