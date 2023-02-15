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
 * This class is a Junit unit test for DateTime.
 *
 * @author Stephen Colebourne
 * @author Mike Schrag
 */
public class TestMutableDateTime_Properties extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    //private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    
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
            
    // 2002-04-05 Fri
    private long TEST_TIME1 =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    // 2003-05-06 Tue
    private long TEST_TIME2 =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private DateTimeZone zone = null;
    private Locale locale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMutableDateTime_Properties.class);
    }

    public TestMutableDateTime_Properties(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        locale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        Locale.setDefault(locale);
        zone = null;
    }

    //-----------------------------------------------------------------------
public void testPropertyGetYearOfCentury437() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().yearOfCentury(), test.yearOfCentury().getField()); 
     assertEquals("yearOfCentury", test.yearOfCentury().getName()); 
     assertEquals("Property[yearOfCentury]", test.yearOfCentury().toString()); 
     assertEquals(2004, test.yearOfCentury().get()); 
     assertEquals("2004", test.yearOfCentury().getAsText()); 
     assertEquals("2004", test.yearOfCentury().getAsText(Locale.FRENCH)); 
     assertEquals("2004", test.yearOfCentury().getAsShortText()); 
     assertEquals("2004", test.yearOfCentury().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.yearOfCentury().getDurationField()); 
     assertEquals(test.getChronology().centuries(), test.yearOfCentury().getRangeDurationField()); 
     assertEquals(9, test.yearOfCentury().getMaximumTextLength(null)); 
     assertEquals(9, test.yearOfCentury().getMaximumShortTextLength(null)); 
 }
public void testPropertyCompareToDayOfYear439() { 
     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); 
     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfYear().compareTo(test2) < 0); 
     assertEquals(true, test2.dayOfYear().compareTo(test1) > 0); 
     assertEquals(true, test1.dayOfYear().compareTo(test1) == 0); 
     try { 
         test1.dayOfYear().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfYear().compareTo(dt2) < 0); 
     assertEquals(true, test2.dayOfYear().compareTo(dt1) > 0); 
     assertEquals(true, test1.dayOfYear().compareTo(dt1) == 0); 
     try { 
         test1.dayOfYear().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyGetMinuteOfDay440() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().minuteOfDay(), test.minuteOfDay().getField()); 
     assertEquals("minuteOfDay", test.minuteOfDay().getName()); 
     assertEquals("Property[minuteOfDay]", test.minuteOfDay().toString()); 
     assertSame(test, test.minuteOfDay().getMutableDateTime()); 
     assertEquals(53, test.minuteOfDay().get()); 
     assertEquals("53", test.minuteOfDay().getAsString()); 
     assertEquals("53", test.minuteOfDay().getAsText()); 
     assertEquals("53", test.minuteOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("53", test.minuteOfDay().getAsShortText()); 
     assertEquals("53", test.minuteOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().minutes(), test.minuteOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.minuteOfDay().getRangeDurationField()); 
     assertEquals(3, test.minuteOfDay().getMaximumTextLength(null)); 
     assertEquals(3, test.minuteOfDay().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetMinuteOfHour441() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getMutableDateTime()); 
     assertEquals(53, test.minuteOfHour().get()); 
     assertEquals("53", test.minuteOfHour().getAsString()); 
     assertEquals("53", test.minuteOfHour().getAsText()); 
     assertEquals("53", test.minuteOfHour().getAsText(Locale.FRENCH)); 
     assertEquals("53", test.minuteOfHour().getAsShortText()); 
     assertEquals("53", test.minuteOfHour().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().minutes(), test.minuteOfHour().getDurationField()); 
     assertEquals(test.getChronology().hours(), test.minuteOfHour().getRangeDurationField()); 
     assertEquals(3, test.minuteOfHour().getMaximumTextLength(null)); 
     assertEquals(3, test.minuteOfHour().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetSecondOfDay442() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().secondOfDay(), test.secondOfDay().getField()); 
     assertEquals("secondOfDay", test.secondOfDay().getName()); 
     assertEquals("Property[secondOfDay]", test.secondOfDay().toString()); 
     assertSame(test, test.secondOfDay().getMutableDateTime()); 
     assertEquals(53, test.secondOfDay().get()); 
     assertEquals("53", test.secondOfDay().getAsString()); 
     assertEquals("53", test.secondOfDay().getAsText()); 
     assertEquals("53", test.secondOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("53", test.secondOfDay().getAsShortText()); 
     assertEquals("53", test.secondOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().seconds(), test.secondOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.secondOfDay().getRangeDurationField()); 
     assertEquals(3, test.secondOfDay().getMaximumTextLength(null)); 
     assertEquals(3, test.secondOfDay().getMaximumShortTextLength(null)); 
 }
public void testPropertyAddWrapFieldYear447() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.year().addWrapField(1); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.year().addWrapField(2); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.year().addWrapField(3); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.year().addWrapField(4); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
 }
public void testPropertyAddWrapFieldYear448() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.year().addWrapField(4); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
 }
public void testPropertyRoundCeilingHourOfDay449() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 0); 
     test.hourOfDay().roundCeiling(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
 }
public void testPropertyRoundCeilingHourOfDay450() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 0); 
     test.hourOfDay().roundCeiling(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 1); 
     test.hourOfDay().roundCeiling(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 13, 29, 59, 999); 
     test.hourOfDay().roundCeiling(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
 }
public void testPropertyRoundHalfFloorHourOfDay451() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 0); 
     test.hourOfDay().roundHalfFloor(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 1); 
     test.hourOfDay().roundHalfFloor(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 13, 29, 59, 999); 
     test.hourOfDay().roundHalfFloor(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
 }
public void testPropertySetWeekOfWeekyear516() { 
     DateTime test = new DateTime(2004, 6, 7, 0, 0, 0, 0); 
     DateTime copy = test.weekOfWeekyear().setCopy(4); 
     assertEquals("2004-06-07T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-01-19T00:00:00.000Z", copy.toString()); 
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
    

    

    

    

    

    

    

    

    

}
