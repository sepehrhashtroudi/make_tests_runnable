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

public void testPropertyCompareToMinute951() { 
     LocalTime test1 = new LocalTime(TEST_TIME1); 
     LocalTime test2 = new LocalTime(TEST_TIME2); 
     assertEquals(true, test1.minuteOfHour().compareTo(test2) < 0); 
     assertEquals(true, test2.minuteOfHour().compareTo(test1) > 0); 
     assertEquals(true, test1.minuteOfHour().compareTo(test1) == 0); 
     try { 
         test1.minuteOfHour().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.minuteOfHour().compareTo(dt2) < 0); 
     assertEquals(true, test2.minuteOfHour().compareTo(dt1) > 0); 
     assertEquals(true, test1.minuteOfHour().compareTo(dt1) == 0); 
     try { 
         test1.minuteOfHour().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testPropertyGetHour973() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertSame(test.getChronology().hourOfDay(), test.hourOfDay().getField()); 
     assertEquals("hourOfDay", test.hourOfDay().getName()); 
     assertEquals("Property[hourOfDay]", test.hourOfDay().toString()); 
     assertSame(test, test.hourOfDay().getLocalTime()); 
     assertEquals(10, test.hourOfDay().get()); 
     assertEquals("10", test.hourOfDay().getAsString()); 
     assertEquals("10", test.hourOfDay().getAsText()); 
     assertEquals("10", test.hourOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("10", test.hourOfDay().getAsShortText()); 
     assertEquals("10", test.hourOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().hours(), test.hourOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.hourOfDay().getRangeDurationField()); 
     assertEquals(2, test.hourOfDay().getMaximumTextLength(null)); 
     assertEquals(2, test.hourOfDay().getMaximumShortTextLength(null)); 
 } 


public void testPropertySetTextSecond974() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.secondOfMinute().setCopy("12"); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 12, 40); 
 } 


public void testPropertySetMilli975() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.millisOfSecond().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 30, 12); 
     try { 
         test.millisOfSecond().setCopy(1000); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.millisOfSecond().setCopy(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testPropertyPlusHour979() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.hourOfDay().addCopy(9); 
     check(test, 10, 20, 30, 40); 
     check(copy, 19, 20, 30, 40); 
     copy = test.hourOfDay().addCopy(0); 
     check(copy, 10, 20, 30, 40); 
     copy = test.hourOfDay().addCopy(13); 
     check(copy, 23, 20, 30, 40); 
     copy = test.hourOfDay().addCopy(14); 
     check(copy, 0, 20, 30, 40); 
     copy = test.hourOfDay().addCopy(-10); 
     check(copy, 0, 20, 30, 40); 
     copy = test.hourOfDay().addCopy(-11); 
     check(copy, 23, 20, 30, 40); 
 } 


public void testPropertyPlusNoWrapMinute980() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.minuteOfHour().addNoWrapToCopy(9); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 29, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(39); 
     check(copy, 10, 59, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(40); 
     check(copy, 11, 0, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(1 * 60 + 45); 
     check(copy, 12, 5, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(13 * 60 + 39); 
     check(copy, 23, 59, 30, 40); 
     try { 
         test.minuteOfHour().addNoWrapToCopy(13 * 60 + 40); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 10, 20, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(-9); 
     check(copy, 10, 11, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(-19); 
     check(copy, 10, 1, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(-20); 
     check(copy, 10, 0, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(-21); 
     check(copy, 9, 59, 30, 40); 
     copy = test.minuteOfHour().addNoWrapToCopy(-(10 * 60 + 20)); 
     check(copy, 0, 0, 30, 40); 
     try { 
         test.minuteOfHour().addNoWrapToCopy(-(10 * 60 + 21)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 10, 20, 30, 40); 
 } 


public void testPropertySetSecond981() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime copy = test.secondOfMinute().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 12, 40); 
     try { 
         test.secondOfMinute().setCopy(60); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.secondOfMinute().setCopy(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testPropertyWithMaxMinValueHour982() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     check(test.hourOfDay().withMaximumValue(), 23, 20, 30, 40); 
     check(test.hourOfDay().withMinimumValue(), 0, 20, 30, 40); 
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
