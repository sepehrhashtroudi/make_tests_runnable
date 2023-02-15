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

import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class is a Junit unit test for TimeOfDay.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestTimeOfDay_Properties extends TestCase {

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
        return new TestSuite(TestTimeOfDay_Properties.class);
    }

    public TestTimeOfDay_Properties(String name) {
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
public void testPropertyGetHourOfDay193() { 
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
public void testPropertyGetMaxMinValuesDay194() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     assertEquals(1, test.dayOfMonth().getMinimumValue()); 
     assertEquals(1, test.dayOfMonth().getMinimumValueOverall()); 
     assertEquals(30, test.dayOfMonth().getMaximumValue()); 
     assertEquals(31, test.dayOfMonth().getMaximumValueOverall()); 
     test = new YearMonthDay(1972, 7, 9); 
     assertEquals(31, test.dayOfMonth().getMaximumValue()); 
     test = new YearMonthDay(1972, 2, 9); 
     assertEquals(29, test.dayOfMonth().getMaximumValue()); 
     test = new YearMonthDay(1971, 2, 9); 
     assertEquals(28, test.dayOfMonth().getMaximumValue()); 
 }
public void testPropertySetMinute475() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.minuteOfHour().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 12, 30, 40); 
     try { 
         test.minuteOfHour().setCopy(60); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.minuteOfHour().setCopy(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertySetMilli480() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.millisOfSecond().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 30, 49); 
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
public void testPropertyGetMinute481() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getTimeOfDay()); 
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
public void testPropertyAddWrapFieldHour482() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.hourOfDay().addWrapFieldToCopy(9); 
     check(test, 10, 20, 30, 40); 
     check(copy, 19, 20, 30, 40); 
     copy = test.hourOfDay().addWrapFieldToCopy(0); 
     check(copy, 10, 20, 30, 40); 
     copy = test.hourOfDay().addWrapFieldToCopy(18); 
     check(copy, 4, 20, 30, 40); 
     copy = test.hourOfDay().addWrapFieldToCopy(-15); 
     check(copy, 19, 20, 30, 40); 
     copy = test.hourOfDay().addWrapFieldToCopy(-15); 
     check(copy, 19, 20, 30, 40); 
 }
    

    

    

    

    

    

    

    

    

    

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
