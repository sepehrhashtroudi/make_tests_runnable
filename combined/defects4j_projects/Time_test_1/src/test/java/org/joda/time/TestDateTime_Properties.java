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

import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.chrono.StrictChronology;

/**
 * This class is a Junit unit test for DateTime.
 *
 * @author Stephen Colebourne
 * @author Mike Schrag
 */
public class TestDateTime_Properties extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);

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
        return new TestSuite(TestDateTime_Properties.class);
    }

    public TestDateTime_Properties(String name) {
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
public void testPropertyGetYearOfEra243() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().yearOfEra(), test.yearOfEra().getField()); 
     assertEquals("yearOfEra", test.yearOfEra().getName()); 
     assertEquals("Property[yearOfEra]", test.yearOfEra().toString()); 
     assertSame(test, test.yearOfEra().getDateTime()); 
     assertEquals(2004, test.yearOfEra().get()); 
     assertEquals("2004", test.yearOfEra().getAsString()); 
     assertEquals("2004", test.yearOfEra().getAsText()); 
     assertEquals("2004", test.yearOfEra().getAsText(Locale.FRENCH)); 
     assertEquals("2004", test.yearOfEra().getAsShortText()); 
     assertEquals("2004", test.yearOfEra().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.yearOfEra().getDurationField()); 
     assertEquals(test.getChronology().eras(), test.yearOfEra().getRangeDurationField()); 
     assertEquals(9, test.yearOfEra().getMaximumTextLength(null)); 
     assertEquals(9, test.yearOfEra().getMaximumShortTextLength(null)); 
 }
public void testPropertySetCopyYear244() { 
     DateTime test = new DateTime(1972, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.year().setCopy(12); 
     assertEquals("1972-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("1972-12-09T00:00:00.000Z", copy.toString()); 
     try { 
         test.year().setCopy(13); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.year().setCopy(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyGetMinuteOfDay246() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     assertSame(test.getChronology().minuteOfDay(), test.minuteOfDay().getField()); 
     assertEquals("minuteOfDay", test.minuteOfDay().getName()); 
     assertEquals("Property[minuteOfDay]", test.minuteOfDay().toString()); 
     assertSame(test, test.minuteOfDay().getDateTime()); 
     assertEquals(803, test.minuteOfDay().get()); 
     assertEquals("803", test.minuteOfDay().getAsString()); 
     assertEquals("803", test.minuteOfDay().getAsText()); 
     assertEquals("803", test.minuteOfDay().getAsText(Locale.FRENCH)); 
     assertEquals("803", test.minuteOfDay().getAsShortText()); 
     assertEquals("803", test.minuteOfDay().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().minutes(), test.minuteOfDay().getDurationField()); 
     assertEquals(test.getChronology().days(), test.minuteOfDay().getRangeDurationField()); 
     assertEquals(4, test.minuteOfDay().getMaximumTextLength(null)); 
     assertEquals(4, test.minuteOfDay().getMaximumShortTextLength(null)); 
 }
public void testPropertySetTextMonthOfYear256() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.monthOfYear().setCopy("8"); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-08-09T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().setCopy("December"); 
     assertEquals("2004-08-09T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().setCopy("Dec"); 
     assertEquals("2004-12-09T00:00:00.000Z", copy.toString()); 
     test = new DateTime(2004, 1, 31, 0, 0, 0, 0); 
     copy = test.monthOfYear().setCopy("1"); 
     assertEquals("2004-01-31T00:00:00.000Z", test.toString()); 
     assertEquals("2004-02-29T00:00:00.000Z", copy.toString()); 
     copy = test.monthOfYear().setCopy("2"); 
     assertEquals("2004-03-31T00:00:00.000+01:00", copy.toString()); 
     copy = test.monthOfYear().setCopy("3"); 
     assertEquals("2004-04-30T00:00:00.000Z", copy.toString()); 
     test = new DateTime(2003, 1, 31, 0, 0, 0, 0); 
     copy = test.monthOfYear().setCopy("4"); 
     assertEquals("2003-02-28T00:00:00.000Z", copy.toString());
}

public void testPropertySetTextMonthOfYear257() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.monthOfYear().setCopy("8"); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-08-09T00:00:00.000Z", copy.toString()); 
     try { 
         test.monthOfYear().setCopy("December"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.monthOfYear().setCopy("Dec"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyRoundHalfFloorHourOfDay258() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 30, 0, 0); 
     DateTime copy = test.hourOfDay().roundHalfFloorCopy(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", copy.toString()); 
     test = new DateTime(2004, 6, 9, 13, 30, 0, 1); 
     copy = test.hourOfDay().roundHalfFloorCopy(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", copy.toString()); 
     test = new DateTime(2004, 6, 9, 13, 29, 59, 999); 
     copy = test.hourOfDay().roundHalfFloorCopy(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", copy.toString()); 
 }
public void testPropertyRoundHalfCeilingHourOfDay259() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 30, 0, 0); 
     DateTime copy = test.hourOfDay().roundHalfCeilingCopy(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", copy.toString()); 
     test = new DateTime(2004, 6, 9, 13, 30, 0, 1); 
     copy = test.hourOfDay().roundHalfCeilingCopy(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", copy.toString()); 
     test = new DateTime(2004, 6, 9, 13, 29, 59, 999); 
     copy = test.hourOfDay().roundHalfCeilingCopy(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", copy.toString()); 
 }
public void testPropertyGetDifferenceMonthOfYear444() { 
     DateMidnight test1 = new DateMidnight(2004, 6, 9); 
     DateMidnight test2 = new DateMidnight(2004, 8, 9); 
     assertEquals(-2, test1.monthOfYear().getDifference(test2)); 
     assertEquals(2, test2.monthOfYear().getDifference(test1)); 
     assertEquals(-2L, test1.monthOfYear().getDifferenceAsLong(test2)); 
     assertEquals(2L, test2.monthOfYear().getDifferenceAsLong(test1)); 
 }
public void testPropertyAddWrapFieldMonthOfYear448() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.monthOfYear().addWrapField(8); 
     assertEquals("2004-02-09T00:00:00.000Z", test.toString()); 
 }
public void testPropertyToIntervalMillisOfSecond450() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     Interval testInterval = test.millisOfSecond().toInterval(); 
     assertEquals(new DateTime(2004, 6, 9, 13, 23, 43, 53), testInterval.getStart()); 
     assertEquals(new DateTime(2004, 6, 9, 13, 23, 43, 54), testInterval.getEnd()); 
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
