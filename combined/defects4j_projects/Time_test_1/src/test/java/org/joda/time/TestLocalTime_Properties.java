/*
 *  Copyright 2001-2006 Stephen Colebourne
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

import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class is a Junit unit test for TimeOfDay.
 *
 * @author Stephen Colebourne
 */
public class TestLocalTime_Properties extends TestCase {

    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");

    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;

    private long TEST_TIME1 =
        1L * DateTimeConstants.MILLIS_PER_HOUR
        + 2L * DateTimeConstants.MILLIS_PER_MINUTE
        + 3L * DateTimeConstants.MILLIS_PER_SECOND
        + 4L;

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
        return new TestSuite(TestLocalTime_Properties.class);
    }

    public TestLocalTime_Properties(String name) {
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
public void testPropertyCompareToSecond461() { 
     LocalTime test1 = new LocalTime(TEST_TIME1); 
     LocalTime test2 = new LocalTime(TEST_TIME2); 
     assertEquals(true, test1.secondOfMinute().compareTo(test2) < 0); 
     assertEquals(true, test2.secondOfMinute().compareTo(test1) > 0); 
     assertEquals(true, test1.secondOfMinute().compareTo(test1) == 0); 
     try { 
         test1.secondOfMinute().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.secondOfMinute().compareTo(dt2) < 0); 
     assertEquals(true, test2.secondOfMinute().compareTo(dt1) > 0); 
     assertEquals(true, test1.secondOfMinute().compareTo(dt1) == 0); 
     try { 
         test1.secondOfMinute().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testProperty465() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals(test.hourOfDay(), test.property(DateTimeFieldType.hourOfDay())); 
     assertEquals(test.minuteOfHour(), test.property(DateTimeFieldType.minuteOfHour())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     assertEquals(test.millisOfDay(), test.property(DateTimeFieldType.millisOfDay())); 
     assertEquals(test, test.property(DateTimeFieldType.minuteOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.secondOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.millisOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.hourOfHalfday()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.halfdayOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfHalfday()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfDay()).getLocalTime()); 
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
public void testPropertyGetMinute475() { 
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
public void testPropertySetTextSecond476() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.secondOfMinute().setCopy("12"); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 12, 40); 
 }
public void testPropertyWithMaximumValueHour478() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.hourOfDay().withMaximumValue(); 
     check(test, 10, 20, 30, 40); 
     check(copy, 23, 20, 30, 40); 
 }
public void testPropertyWithMinimumValueHour479() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.hourOfDay().withMinimumValue(); 
     check(test, 10, 20, 30, 40); 
     check(copy, 0, 20, 30, 40); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

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
