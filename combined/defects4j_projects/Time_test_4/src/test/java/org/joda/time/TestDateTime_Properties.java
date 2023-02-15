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
public void testPropertyGetWeekyear240() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().weekyear(), test.weekyear().getField()); 
     assertEquals("weekyear", test.weekyear().getName()); 
     assertEquals("Property[weekyear]", test.weekyear().toString()); 
     assertSame(test, test.weekyear().getDateTime()); 
     assertEquals(2004, test.weekyear().get()); 
     assertEquals("2004", test.weekyear().getAsString()); 
     assertEquals("2004", test.weekyear().getAsText()); 
     assertEquals("2004", test.weekyear().getAsText(Locale.FRENCH)); 
     assertEquals("2004", test.weekyear().getAsShortText()); 
     assertEquals("2004", test.weekyear().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().weekyears(), test.weekyear().getDurationField()); 
     assertEquals(null, test.weekyear().getRangeDurationField()); 
     assertEquals(9, test.weekyear().getMaximumTextLength(null)); 
     assertEquals(9, test.weekyear().getMaximumShortTextLength(null)); 
 }
public void testPropertySetTextDayOfYear241() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.dayOfYear().setCopy("12"); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-06-12T00:00:00.000+01:00", copy.toString()); 
 }
public void testPropertyEqualsHashCodeStrict242() { 
     DateTime test1 = new DateTime(1970, 6, 9, 0, 0, 0, 0, StrictChronology.getInstance(COPTIC_PARIS)); 
     DateTime test2 = new DateTime(1970, 6, 9, 0, 0, 0, 0, StrictChronology.getInstance(COPTIC_PARIS)); 
     assertEquals(true, test1.dayOfMonth().equals(test2.dayOfMonth())); 
     assertEquals(true, test2.dayOfMonth().equals(test1.dayOfMonth())); 
     assertEquals(true, test1.dayOfMonth().equals(test1.dayOfMonth())); 
     assertEquals(true, test2.dayOfMonth().equals(test2.dayOfMonth())); 
     assertEquals(true, test1.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); 
     assertEquals(true, test1.dayOfMonth().hashCode() == test1.dayOfMonth().hashCode()); 
     assertEquals(true, test2.dayOfMonth().hashCode() == test2.dayOfMonth().hashCode()); 
 }
public void testPropertyGetMinute243() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getDateTime()); 
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
public void testPropertyAddYear244() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime copy = test.year().addToCopy(9); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2013-06-09T00:00:00.000+01:00", copy.toString()); 
     copy = test.year().addToCopy(0); 
     assertEquals(2004, copy.getYear()); 
     copy = test.year().addToCopy(292278993 - 2004 + 1); 
     assertEquals(-292275054, copy.getYear()); 
     copy = test.year().addToCopy(-292275054 - 2004 - 1); 
     assertEquals(292278993, copy.getYear()); 
 }
public void testPropertyGetMinute356() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getReadablePartial()); 
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
public void testPropertyGetMinute357() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().minuteOfHour(), test.minuteOfHour().getField()); 
     assertEquals("minuteOfHour", test.minuteOfHour().getName()); 
     assertEquals("Property[minuteOfHour]", test.minuteOfHour().toString()); 
     assertSame(test, test.minuteOfHour().getLocalDateTime()); 
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
public void testPropertyGetMaxMinValuesDayOfYear358() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertEquals(1, test.dayOfYear().getMinimumValue()); 
     assertEquals(1, test.dayOfYear().getMinimumValueOverall()); 
     assertEquals(366, test.dayOfYear().getMaximumValue()); 
     assertEquals(366, test.dayOfYear().getMaximumValueOverall()); 
     test = new DateTime(2002, 6, 9, 0, 0, 0, 0); 
     assertEquals(365, test.dayOfYear().getMaximumValue()); 
     assertEquals(366, test.dayOfYear().getMaximumValueOverall()); 
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
