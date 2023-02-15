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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for LocalTime.
 *
 * @author Stephen Colebourne
 */
public class TestLocalTime_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);

    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;

//    private long TEST_TIME1 =
//        1L * DateTimeConstants.MILLIS_PER_HOUR
//        + 2L * DateTimeConstants.MILLIS_PER_MINUTE
//        + 3L * DateTimeConstants.MILLIS_PER_SECOND
//        + 4L;

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
        return new TestSuite(TestLocalTime_Basics.class);
    }

    public TestLocalTime_Basics(String name) {
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
public void testIsEqual_YM10() { 
     YearMonth test1 = new YearMonth(2005, 6); 
     YearMonth test1a = new YearMonth(2005, 6); 
     assertEquals(false, test1.isEqual(test1a)); 
     assertEquals(false, test1a.isEqual(test1)); 
     assertEquals(false, test1.isEqual(test1)); 
     assertEquals(false, test1a.isEqual(test1a)); 
     YearMonth test2 = new YearMonth(2005, 7); 
     assertEquals(true, test1.isEqual(test2)); 
     assertEquals(false, test2.isEqual(test1)); 
     YearMonth test3 = new YearMonth(2005, 7, GregorianChronology.getInstanceUTC()); 
     assertEquals(true, test1.isEqual(test3)); 
     assertEquals(false, test3.isEqual(test1)); 
     assertEquals(true, test3.isEqual(test2)); 
     try { 
         new YearMonth(2005, 7).isEqual(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testIsEqual_YM11() { 
     YearMonth test1 = new YearMonth(2005, 6); 
     YearMonth test1a = new YearMonth(2005, 6); 
     assertEquals(true, test1.isEqual(test1a)); 
     assertEquals(true, test1a.isEqual(test1)); 
     assertEquals(true, test1.isEqual(test1)); 
     assertEquals(true, test1a.isEqual(test1a)); 
     YearMonth test2 = new YearMonth(2005, 7); 
     assertEquals(false, test1.isEqual(test2)); 
     assertEquals(false, test2.isEqual(test1)); 
     YearMonth test3 = new YearMonth(2005, 7, GregorianChronology.getInstanceUTC()); 
     assertEquals(false, test1.isEqual(test3)); 
     assertEquals(true, test3.isEqual(test1)); 
     assertEquals(false, test3.isEqual(test2)); 
     try { 
         new YearMonth(2005, 7).isEqual(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
@SuppressWarnings("deprecation") 
 public void testToString_DTFormatter13() { 
     YearMonthDay test = new YearMonthDay(2002, 6, 9); 
     assertEquals("\ufffd 9/6", test.toString(DateTimeFormat.forPattern("yyyy HH"))); 
     assertEquals("2002-06-09", test.toString((DateTimeFormatter) null)); 
 }
public void testGetValue_int374() { 
     LocalTime test = new LocalTime(10, 20, 30, 40, COPTIC_PARIS); 
     assertEquals(10, test.getValue(0)); 
     assertEquals(20, test.getValue(1)); 
     assertEquals(30, test.getValue(2)); 
     assertEquals(40, test.getValue(3)); 
     try { 
         test.getValue(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getValue(5); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 }
public void testPropertyGetMinute377() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getLocalTime()); 
     assertEquals(20, test.minuteOfHour().get()); 
     assertEquals("20", test.minuteOfHour().getAsString()); 
     assertEquals("20", test.minuteOfHour().getAsText()); 
     assertEquals("20", test.minuteOfHour().getAsText(Locale.FRENCH)); 
     assertEquals("20", test.minuteOfHour().getAsShortText()); 
     assertEquals("20", test.minuteOfHour().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().minutes(), test.minuteOfHour().getDurationField()); 
     assertEquals(test.getChronology().hours(), test.minuteOfHour().getRangeDurationField()); 
     assertEquals(2, test.minuteOfHour().getMaximumTextLength(null)); 
     assertEquals(2, test.minuteOfHour().getMaximumShortTextLength(null)); 
 }
public void testPlusMinutes_int378() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusMinutes(1); 
     LocalTime expected = new LocalTime(1, 3, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusMinutes(0); 
     assertSame(test, result); 
 }
public void testIsAfter_LocalTime379() { 
     LocalTime test1 = new LocalTime(10, 20, 30, 40); 
     LocalTime test1a = new LocalTime(10, 20, 30, 40); 
     assertEquals(false, test1.isAfter(test1a)); 
     assertEquals(false, test1a.isAfter(test1)); 
     assertEquals(false, test1.isAfter(test1)); 
     assertEquals(false, test1a.isAfter(test1a)); 
     LocalTime test2 = new LocalTime(15, 20, 30, 40); 
     assertEquals(false, test1.isAfter(test2)); 
     assertEquals(true, test2.isAfter(test1)); 
     LocalTime test3 = new LocalTime(15, 20, 30, 40); 
     assertEquals(false, test1.isAfter(test3)); 
     assertEquals(true, test3.isAfter(test1)); 
     assertEquals(false, test3.isAfter(test2)); 
     try { 
         new LocalTime(10, 20, 30, 40).isAfter(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithField_DateTimeFieldType_int_3380() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     try { 
         test.withField(null, 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testMinus_RP381() { 
     LocalTime test = new LocalTime(10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalTime result = test.minus(new Period(1, 1, 1, 1, 1, 1, 1, 1)); 
     LocalTime expected = new LocalTime(9, 19, 29, 39, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minus((ReadablePeriod) null); 
     assertSame(test, result); 
 }
public void testPlus_RP382() { 
     LocalTime test = new LocalTime(10, 20, 30, 40, BUDDHIST_LONDON); 
     LocalTime result = test.plus(new Period(1, 2, 3, 4, 5, 6, 7, 8)); 
     LocalTime expected = new LocalTime(15, 26, 37, 48, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plus((ReadablePeriod) null); 
     assertSame(test, result); 
 }
public void testPlusHours_int383() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusHours(1); 
     LocalTime expected = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusHours(0); 
     assertSame(test, result); 
 }
public void testGetters385() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals(10, test.getHourOfDay()); 
     assertEquals(20, test.getMinuteOfHour()); 
     assertEquals(30, test.getSecondOfMinute()); 
     assertEquals(40, test.getMillisOfSecond()); 
     assertEquals(TEST_TIME_NOW, test.getMillisOfDay()); 
 }
public void testGetMinuteOfHour386() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals(10, test.getMinuteOfHour()); 
 }
public void testWithers388() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     check(test.withHourOfDay(6), 6, 20, 30, 40); 
     check(test.withMinuteOfHour(6), 10, 6, 30, 40); 
     check(test.withSecondOfMinute(6), 10, 20, 6, 40); 
     check(test.withMillisOfSecond(6), 10, 20, 30, 6); 
     try { 
         test.withHourOfDay(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withHourOfDay(24); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyGetMillis389() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertSame(test.getChronology().millisOfDay(), test.millisOfDay().getField()); 
     assertEquals("millisOfDay", test.millisOfDay().getName()); 
     assertEquals("Property[millisOfDay]", test.millisOfDay().toString()); 
     assertSame(test, test.millisOfDay().getLocalTime()); 
     assertEquals(10, test.millisOfDay().get()); 
     assertEquals("10", test.millisOfDay().getAsString()); 
     assertEquals("10", test.millisOfDay().getAsText()); 
     assertEquals("10", test.millisOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("10", test.millisOfDay().getAsShortText()); 
     assertEquals("10", test.millisOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().millis(), test.millisOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.millisOfDay().getRangeDurationField()); 
     assertEquals(2, test.millisOfDay().getMaximumTextLength(null)); 
     assertEquals(2, test.millisOfDay().getMaximumShortTextLength(null)); 
 }
public void testToString_String390() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals("10 20", test.toString("H m", Locale.ENGLISH)); 
     assertEquals("10:20:30.040", test.toString(null, Locale.ENGLISH)); 
     assertEquals("10 20", test.toString("H m", null)); 
     assertEquals("10:20:30.040", test.toString(null, null)); 
 }
public void testWithFieldAdded_DurationFieldType_int_8392() { 
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
    

    

    

    

    

    

    

    

    

    

    

    class MockInstant extends MockPartial {
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.hourOfDay(),
                COPTIC_UTC.minuteOfHour(),
                COPTIC_UTC.secondOfMinute(),
                COPTIC_UTC.millisOfSecond(),
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
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void check(LocalTime test, int hour, int min, int sec, int milli) {
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(milli, test.getMillisOfSecond());
    }
}
