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
import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for TimeOfDay.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestTimeOfDay_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final int OFFSET = 1;
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();
    
    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;
            
    private long TEST_TIME2 =
        1L * DateTimeConstants.MILLIS_PER_DAY
        + 5L * DateTimeConstants.MILLIS_PER_HOUR
        + 6L * DateTimeConstants.MILLIS_PER_MINUTE
        + 7L * DateTimeConstants.MILLIS_PER_SECOND
        + 8L;
        
    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestTimeOfDay_Basics.class);
    }

    public TestTimeOfDay_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
    }

    //-----------------------------------------------------------------------
@SuppressWarnings("deprecation") 
 public void testIsContiguous_RP1() { 
     YearMonthDay ymd = new YearMonthDay(2005, 6, 9); 
     assertEquals(true, DateTimeUtils.isContiguous(ymd)); 
     TimeOfDay tod = new TimeOfDay(12, 20, 30, 0); 
     assertEquals(true, DateTimeUtils.isContiguous(tod)); 
     Partial year = new Partial(DateTimeFieldType.year(), 2005); 
     assertEquals(true, DateTimeUtils.isContiguous(year)); 
     Partial hourOfDay = new Partial(DateTimeFieldType.hourOfDay(), 12); 
     assertEquals(true, DateTimeUtils.isContiguous(hourOfDay)); 
     Partial yearHour = year.with(DateTimeFieldType.hourOfDay(), 12); 
     assertEquals(false, DateTimeUtils.isContiguous(yearHour)); 
     Partial ymdd = new Partial(ymd).with(DateTimeFieldType.dayOfWeek(), 2); 
     assertEquals(false, DateTimeUtils.isContiguous(ymdd)); 
     Partial dd = new Partial(DateTimeFieldType.dayOfMonth(), 13).with(DateTimeFieldType.dayOfWeek(), 5); 
     assertEquals(false, DateTimeUtils.isContiguous(dd)); 
     try { 
         DateTimeUtils.isContiguous((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyAddHour129() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.hourOfDay().addToCopy(9); 
     check(test, 10, 20, 30, 40); 
     check(copy, 19, 20, 30, 40); 
     copy = test.hourOfDay().addToCopy(0); 
     check(copy, 10, 20, 30, 40); 
     copy = test.hourOfDay().addToCopy(13); 
     check(copy, 23, 20, 30, 40); 
     copy = test.hourOfDay().addToCopy(14); 
     check(copy, 0, 20, 30, 40); 
     copy = test.hourOfDay().addToCopy(-10); 
     check(copy, 0, 20, 30, 40); 
     copy = test.hourOfDay().addToCopy(-11); 
     check(copy, 23, 20, 30, 40); 
 }
public void testMinusMillis_int130() { 
     TimeOfDay test = new TimeOfDay(1, 2, 3, 4, BuddhistChronology.getInstance()); 
     TimeOfDay result = test.minusMillis(1); 
     TimeOfDay expected = new TimeOfDay(1, 2, 3, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusMillis(0); 
     assertSame(test, result); 
 }
public void testPropertyGetHourOfDay245() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().hourOfDay(), test.hourOfDay().getField()); 
     assertEquals("hourOfDay", test.hourOfDay().getName()); 
     assertEquals("Property[hourOfDay]", test.hourOfDay().toString()); 
     assertSame(test, test.hourOfDay().getDateTime()); 
     assertEquals(13, test.hourOfDay().get()); 
     assertEquals("13", test.hourOfDay().getAsString()); 
     assertEquals("13", test.hourOfDay().getAsText()); 
     assertEquals("13", test.hourOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("13", test.hourOfDay().getAsShortText()); 
     assertEquals("13", test.hourOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().hours(), test.hourOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.hourOfDay().getRangeDurationField()); 
     assertEquals(2, test.hourOfDay().getMaximumTextLength(null)); 
     assertEquals(2, test.hourOfDay().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetMinuteOfHour247() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getDateTime()); 
     assertEquals(23, test.minuteOfHour().get()); 
     assertEquals("23", test.minuteOfHour().getAsString()); 
     assertEquals("23", test.minuteOfHour().getAsText()); 
     assertEquals("23", test.minuteOfHour().getAsText(Locale.FRENCH)); 
     assertEquals("23", test.minuteOfHour().getAsShortText()); 
     assertEquals("23", test.minuteOfHour().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().minutes(), test.minuteOfHour().getDurationField()); 
     assertEquals(test.getChronology().hours(), test.minuteOfHour().getRangeDurationField()); 
     assertEquals(2, test.minuteOfHour().getMaximumTextLength(null)); 
     assertEquals(2, test.minuteOfHour().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetMillisOfSecond249() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().millisOfSecond(), test.millisOfSecond().getField()); 
     assertEquals("millisOfSecond", test.millisOfSecond().getName()); 
     assertEquals("Property[millisOfSecond]", test.millisOfSecond().toString()); 
     assertSame(test, test.millisOfSecond().getDateTime()); 
     assertEquals(53, test.millisOfSecond().get()); 
     assertEquals("53", test.millisOfSecond().getAsString()); 
     assertEquals("53", test.millisOfSecond().getAsText()); 
     assertEquals("53", test.millisOfSecond().getAsText(Locale.FRENCH)); 
     assertEquals("53", test.millisOfSecond().getAsShortText()); 
     assertEquals("53", test.millisOfSecond().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().millis(), test.millisOfSecond().getDurationField()); 
     assertEquals(test.getChronology().seconds(), test.millisOfSecond().getRangeDurationField()); 
     assertEquals(3, test.millisOfSecond().getMaximumTextLength(null)); 
     assertEquals(3, test.millisOfSecond().getMaximumShortTextLength(null)); 
 }
public void testPropertyAddMonthOfYear251() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.monthOfYear().addToCopy(6); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-12-09T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().addToCopy(7); 
     assertEquals("2005-01-09T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().addToCopy(-5); 
     assertEquals("2004-01-09T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().addToCopy(-6); 
     assertEquals("2003-12-09T00:00:00.000Z", copy.toString()); 
     test = new DateTime(2004, 1, 31, 0, 0, 0, 0); 
     copy = test.monthOfYear().addToCopy(1); 
     assertEquals("2004-01-31T00:00:00.000Z", test.toString()); 
     assertEquals("2004-02-29T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().addToCopy(2); 
     assertEquals("2004-03-31T00:00:00.000+01:00", copy.toString()); 
     copy = test.monthOfYear().addToCopy(3); 
     assertEquals("2004-04-30T00:00:00.000+01:00", copy.toString()); 
     test = new DateTime(2003, 1, 31, 0, 0, 0, 0); 
     copy = test.monthOfYear().addToCopy(1); 
     assertEquals("2003-02-28T00:00:00.000Z", copy.toString());
}

public void testPropertyWithMinimumValueMillisOfDayDSTGap255() { 
     DateTimeZone gaza = DateTimeZone.forID("Asia/Gaza"); 
     DateTime dt = new DateTime(2001, 4, 20, 18, 0, 0, 0, gaza); 
     DateTime test = dt.millisOfDay().withMinimumValue(); 
     assertEquals("2001-04-20T01:00:00.000+03:00", test.toString()); 
 }
public void testWithChronologyRetainFields_sameChrono562() { 
     TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); 
     TimeOfDay test = base.withChronologyRetainFields(COPTIC_TOKYO); 
     assertSame(base, test); 
 }
public void testWithField4563() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay result = test.withField(DateTimeFieldType.hourOfDay(), 10); 
     assertSame(test, result); 
 }
public void testPlus_RP564() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40, BuddhistChronology.getInstance()); 
     TimeOfDay result = test.plus(new Period(1, 2, 3, 4, 5, 6, 7, 8)); 
     TimeOfDay expected = new TimeOfDay(15, 26, 37, 48, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.plus((ReadablePeriod) null); 
     assertSame(test, result); 
 }
public void testToDateTimeToday_nullZone568() { 
     TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTimeToday((DateTimeZone) null); 
     check(base, 10, 20, 30, 40); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.hourOfDay().setCopy(10); 
     expected = expected.minuteOfHour().setCopy(20); 
     expected = expected.secondOfMinute().setCopy(30); 
     expected = expected.millisOfSecond().setCopy(40); 
     assertEquals(expected, test); 
 }
    

    

    

    

    

    

    

    

    

    

    class MockInstant extends MockPartial {
        public Chronology getChronology() {
            return CopticChronology.getInstanceUTC();
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                CopticChronology.getInstanceUTC().hourOfDay(),
                CopticChronology.getInstanceUTC().minuteOfHour(),
                CopticChronology.getInstanceUTC().secondOfMinute(),
                CopticChronology.getInstanceUTC().millisOfSecond(),
            };
        }
        public int[] getValues() {
            return new int[] {10, 20, 30, 40};
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
    

    

    // Removed as too complex
//    /**
//     * Merges two partial together, taking account of the different chronologies.
//     *
//     * @param main  the main partial
//     * @param base  the partial to use as a base to merge on top of
//     * @param instant  the instant to start from and to use for missing fields
//     * @return the merged instant
//     */
//    public long merge(ReadablePartial main, ReadablePartial base, long instant) {
//        DateTimeZone zone = main.getChronology().getZone();
//        instant = base.getChronology().withZone(zone).set(base, instant);
//        return set(main, instant);
//    }
//
//    //-----------------------------------------------------------------------
//    /**
//     * Converts this object to a DateTime using a YearMonthDay to fill in the
//     * missing fields and using the default time zone.
//     * This instance is immutable and unaffected by this method call.
//     * <p>
//     * The resulting chronology is determined by the chronology of this
//     * TimeOfDay plus the time zone.
//     * <p>
//     * This method makes use of the chronology of the specified YearMonthDay
//     * in the calculation. This can be significant when mixing chronologies.
//     * If the YearMonthDay is in the same chronology as this instance the
//     * method will perform exactly as you might expect.
//     * <p>
//     * If the chronologies differ, then both this TimeOfDay and the YearMonthDay
//     * are converted to the destination chronology and then merged. As a result
//     * it may be the case that the year, monthOfYear and dayOfMonth fields on
//     * the result are different from the values returned by the methods on the
//     * YearMonthDay.
//     * <p>
//     * See {@link DateTime#withFields(ReadablePartial)} for an algorithm that
//     * ignores the chronology.
//     *
//     * @param date  the date to use, null means today
//     * @return the DateTime instance
//     */
//    public DateTime toDateTime(YearMonthDay date) {
//        return toDateTime(date, null);
//    }
//
//    /**
//     * Converts this object to a DateTime using a YearMonthDay to fill in the
//     * missing fields.
//     * This instance is immutable and unaffected by this method call.
//     * <p>
//     * The resulting chronology is determined by the chronology of this
//     * TimeOfDay plus the time zone.
//     * <p>
//     * This method makes use of the chronology of the specified YearMonthDay
//     * in the calculation. This can be significant when mixing chronologies.
//     * If the YearMonthDay is in the same chronology as this instance the
//     * method will perform exactly as you might expect.
//     * <p>
//     * If the chronologies differ, then both this TimeOfDay and the YearMonthDay
//     * are converted to the destination chronology and then merged. As a result
//     * it may be the case that the year, monthOfYear and dayOfMonth fields on
//     * the result are different from the values returned by the methods on the
//     * YearMonthDay.
//     * <p>
//     * See {@link DateTime#withFields(ReadablePartial)} for an algorithm that
//     * ignores the chronology and just assigns the fields.
//     *
//     * @param date  the date to use, null means today
//     * @param zone  the zone to get the DateTime in, null means default
//     * @return the DateTime instance
//     */
//    public DateTime toDateTime(YearMonthDay date, DateTimeZone zone) {
//        Chronology chrono = getChronology().withZone(zone);
//        if (date == null) {
//            DateTime dt = new DateTime(chrono);
//            return dt.withFields(this);
//        } else {
//            long millis = chrono.merge(this, date, DateTimeUtils.currentTimeMillis());
//            return new DateTime(millis, chrono);
//        }
//    }
//
//    //-----------------------------------------------------------------------
//    public void testToDateTime_YMD() {
//        TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); // PARIS irrelevant
//        YearMonthDay ymd = new YearMonthDay(new DateMidnight(2004, 6, 9), BUDDHIST_TOKYO);
//        
//        DateTime test = base.toDateTime(ymd);
//        check(base, 10, 20, 30, 40);
//        DateTime expected = new DateTime(ymd.toDateMidnight(LONDON), COPTIC_LONDON);
//        expected = expected.hourOfDay().setCopy(10);
//        expected = expected.minuteOfHour().setCopy(20);
//        expected = expected.secondOfMinute().setCopy(30);
//        expected = expected.millisOfSecond().setCopy(40);
//        assertEquals(expected, test);
//    }
//
//    public void testToDateTime_nullYMD() {
//        TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); // PARIS irrelevant
//        
//        DateTime test = base.toDateTime((YearMonthDay) null);
//        check(base, 10, 20, 30, 40);
//        DateTime expected = new DateTime(COPTIC_LONDON);
//        expected = expected.hourOfDay().setCopy(10);
//        expected = expected.minuteOfHour().setCopy(20);
//        expected = expected.secondOfMinute().setCopy(30);
//        expected = expected.millisOfSecond().setCopy(40);
//        assertEquals(expected, test);
//    }
//
//    //-----------------------------------------------------------------------
//    public void testToDateTime_YMD_Zone() {
//        TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); // PARIS irrelevant
//        YearMonthDay ymd = new YearMonthDay(new DateMidnight(2004, 6, 9), BUDDHIST_LONDON);
//        
//        DateTime test = base.toDateTime(ymd, TOKYO);
//        check(base, 10, 20, 30, 40);
//        DateTime expected = new DateTime(ymd.toDateMidnight(TOKYO), COPTIC_TOKYO);
//        expected = expected.hourOfDay().setCopy(10);
//        expected = expected.minuteOfHour().setCopy(20);
//        expected = expected.secondOfMinute().setCopy(30);
//        expected = expected.millisOfSecond().setCopy(40);
//        assertEquals(expected, test);
//    }
//
//    public void testToDateTime_YMD_nullZone() {
//        TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); // PARIS irrelevant
//        YearMonthDay ymd = new YearMonthDay(new DateMidnight(2004, 6, 9), BUDDHIST_LONDON);
//        
//        DateTime test = base.toDateTime(ymd, null);
//        check(base, 10, 20, 30, 40);
//        DateTime expected = new DateTime(ymd.toDateMidnight(LONDON), COPTIC_LONDON);
//        expected = expected.hourOfDay().setCopy(10);
//        expected = expected.minuteOfHour().setCopy(20);
//        expected = expected.secondOfMinute().setCopy(30);
//        expected = expected.millisOfSecond().setCopy(40);
//        assertEquals(expected, test);
//    }
//
//    public void testToDateTime_nullYMD_Zone() {
//        TimeOfDay base = new TimeOfDay(10, 20, 30, 40, COPTIC_PARIS); // PARIS irrelevant
//        
//        DateTime test = base.toDateTime((YearMonthDay) null, TOKYO);
//        check(base, 10, 20, 30, 40);
//        DateTime expected = new DateTime(COPTIC_TOKYO);
//        expected = expected.hourOfDay().setCopy(10);
//        expected = expected.minuteOfHour().setCopy(20);
//        expected = expected.secondOfMinute().setCopy(30);
//        expected = expected.millisOfSecond().setCopy(40);
//        assertEquals(expected, test);
//    }

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void check(TimeOfDay test, int hour, int min, int sec, int milli) {
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(milli, test.getMillisOfSecond());
    }
}
