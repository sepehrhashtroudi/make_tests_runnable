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
@SuppressWarnings("deprecation")
public class TestDateMidnight_Properties extends TestCase {
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
        return new TestSuite(TestDateMidnight_Properties.class);
    }

    public TestDateMidnight_Properties(String name) {
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
public void testPropertyGetMonth573() { 
     LocalDateTime test = new LocalDateTime(1972, 6, 9, 10, 20, 30, 40); 
     assertSame(test.getChronology().monthOfYear(), test.monthOfYear().getField()); 
     assertEquals("monthOfYear", test.monthOfYear().getName()); 
     assertEquals("Property[monthOfYear]", test.monthOfYear().toString()); 
     assertSame(test, test.monthOfYear().getLocalDateTime()); 
     assertEquals(6, test.monthOfYear().get()); 
     assertEquals("6", test.monthOfYear().getAsString()); 
     assertEquals("June", test.monthOfYear().getAsText()); 
     assertEquals("juin", test.monthOfYear().getAsText(Locale.FRENCH)); 
     assertEquals("Jun", test.monthOfYear().getAsShortText()); 
     assertEquals("juin", test.monthOfYear().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().months(), test.monthOfYear().getDurationField()); 
     assertEquals(test.getChronology().years(), test.monthOfYear().getRangeDurationField()); 
     assertEquals(9, test.monthOfYear().getMaximumTextLength(null)); 
     assertEquals(3, test.monthOfYear().getMaximumShortTextLength(null)); 
     test = new LocalDateTime(1972, 7, 9, 10, 20, 30, 40); 
     assertEquals("juillet", test.monthOfYear().getAsText(Locale.FRENCH)); 
     assertEquals("juil.", test.monthOfYear().getAsShortText(Locale.FRENCH)); 
 }
public void testPropertyToIntervalYearOfCentury588() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     Interval testInterval = test.yearOfCentury().toInterval(); 
     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); 
     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); 
 }
public void testPropertyGetYearOfCentury589() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     assertSame(test.getChronology().yearOfCentury(), test.yearOfCentury().getField()); 
     assertEquals("yearOfCentury", test.yearOfCentury().getName()); 
     assertEquals("Property[yearOfCentury]", test.yearOfCentury().toString()); 
     assertSame(test, test.yearOfCentury().getDateMidnight()); 
     assertEquals(20, test.yearOfCentury().get()); 
     assertEquals("20", test.yearOfCentury().getAsText()); 
     assertEquals("20", test.yearOfCentury().getAsText(Locale.FRENCH)); 
     assertEquals("20", test.yearOfCentury().getAsShortText()); 
     assertEquals("20", test.yearOfCentury().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.yearOfCentury().getDurationField()); 
     assertEquals(test.getChronology().centuries(), test.yearOfCentury().getRangeDurationField()); 
     assertEquals(2, test.yearOfCentury().getMaximumTextLength(null)); 
     assertEquals(2, test.yearOfCentury().getMaximumShortTextLength(null)); 
 }
public void testPropertyToIntervalYearOfEra590() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     Interval testInterval = test.yearOfEra().toInterval(); 
     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); 
     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); 
 }
public void testPropertyToIntervalMonthOfYear591() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     Interval testInterval = test.monthOfYear().toInterval(); 
     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); 
     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); 
 }
public void testPropertyGetEra593() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     assertSame(test.getChronology().era(), test.era().getField()); 
     assertEquals("era", test.era().getName()); 
     assertEquals("Property[era]", test.era().toString()); 
     assertSame(test, test.era().getDateMidnight()); 
     assertEquals(1, test.era().get()); 
     assertEquals("AD", test.era().getAsText()); 
     assertEquals("ap. J.-C.", test.era().getAsText(Locale.FRENCH)); 
     assertEquals("AD", test.era().getAsShortText()); 
     assertEquals("ap. J.-C.", test.era().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().eras(), test.era().getDurationField()); 
     assertEquals(null, test.era().getRangeDurationField()); 
     assertEquals(2, test.era().getMaximumTextLength(null)); 
     assertEquals(9, test.era().getMaximumTextLength(Locale.FRENCH)); 
     assertEquals(2, test.era().getMaximumShortTextLength(null)); 
     assertEquals(9, test.era().getMaximumShortTextLength(Locale.FRENCH)); 
 }
public void testPropertySetTextMonthOfYear594() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().setCopy("12"); 
     assertEquals("2004-06-09T00:00:00.000+01:00", test.toString()); 
     assertEquals("2004-06-12T00:00:00.000+01:00", copy.toString()); 
 }
public void testPropertyRoundHalfCeilingMonthOfYear595() { 
     DateMidnight test = new DateMidnight(2004, 6, 16); 
     DateMidnight copy = test.monthOfYear().roundHalfCeilingCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 9, 16); 
     copy = test.monthOfYear().roundHalfCeilingCopy(); 
     assertEquals("2004-10-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 17); 
     copy = test.monthOfYear().roundHalfCeilingCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
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
    

    

    

    

    

    

    

}
