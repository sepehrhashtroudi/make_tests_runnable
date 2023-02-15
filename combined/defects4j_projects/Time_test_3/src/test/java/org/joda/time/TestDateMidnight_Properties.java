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
public void testPropertyGetDifferenceHourOfDay397() { 
     DateTime test1 = new DateTime(2004, 6, 9, 13, 30, 0, 0); 
     DateTime test2 = new DateTime(2004, 6, 9, 15, 30, 0, 0); 
     assertEquals(-2, test1.hourOfDay().getDifference(test2)); 
     assertEquals(2, test2.hourOfDay().getDifference(test1)); 
     assertEquals(-2L, test1.hourOfDay().getDifferenceAsLong(test2)); 
     assertEquals(2L, test2.hourOfDay().getDifferenceAsLong(test1)); 
     DateTime test = new DateTime(TEST_TIME_NOW + (13L * DateTimeConstants.MILLIS_PER_HOUR)); 
     assertEquals(13, test.hourOfDay().getDifference(null)); 
     assertEquals(13L, test.hourOfDay().getDifferenceAsLong(null)); 
 }
public void testPropertyToIntervalYear638() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     Interval testInterval = test.year().toInterval(); 
     assertEquals(new DateMidnight(2004, 1, 1), testInterval.getStart()); 
     assertEquals(new DateMidnight(2005, 1, 1), testInterval.getEnd()); 
 }
public void testPropertyAddWrapFieldMonthOfYear640() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().addWrapFieldToCopy(8); 
     assertEquals(2005, copy.getYear()); 
     assertEquals(2, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyRoundHalfEvenMonthOfYear641() { 
     DateMidnight test = new DateMidnight(2004, 6, 16); 
     DateMidnight copy = test.monthOfYear().roundHalfEvenCopy(); 
     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 17); 
     copy = test.monthOfYear().roundHalfEvenCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 15); 
     copy = test.monthOfYear().roundHalfEvenCopy(); 
     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); 
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
