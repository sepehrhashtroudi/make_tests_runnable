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
public void testPropertyGetEra726() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     assertSame(test.getChronology().era(), test.era().getField()); 
     assertEquals("era", test.era().getName()); 
     assertEquals("Property[era]", test.era().toString()); 
     assertSame(test, test.era().getDateMidnight()); 
     assertEquals(1, test.era().get()); 
     assertEquals("1", test.era().getAsText()); 
     assertEquals("AD", test.era().getAsText(Locale.FRENCH)); 
     assertEquals("AD", test.era().getAsShortText()); 
     assertEquals("ap. J.-C.", test.era().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().eras(), test.era().getDurationField()); 
     assertEquals(null, test.era().getRangeDurationField()); 
     assertEquals(2, test.era().getMaximumTextLength(null)); 
     assertEquals(9, test.era().getMaximumTextLength(Locale.FRENCH)); 
     assertEquals(2, test.era().getMaximumShortTextLength(null)); 
     assertEquals(9, test.era().getMaximumShortTextLength(Locale.FRENCH)); 
 }
public void testPropertySetTextMonthOfYear728() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().setCopy("8"); 
     assertEquals(2004, copy.getYear()); 
     assertEquals(8, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertySetTextDayOfMonth729() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.dayOfMonth().setCopy("12"); 
     assertEquals(2004, copy.getYear()); 
     assertEquals(2, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyGetEra731() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     assertSame(test.getChronology().era(), test.era().getField()); 
     assertEquals("era", test.era().getName()); 
     assertEquals("Property[era]", test.era().toString()); 
     assertSame(test, test.era().getDateMidnight()); 
     assertEquals(1, test.era().get()); 
     assertEquals("1", test.era().getAsString()); 
     assertEquals("AD", test.era().getAsText()); 
     assertEquals("AD", test.era().getField().getAsText(1, Locale.ENGLISH)); 
     assertEquals("ap. J.-C.", test.era().getAsText(Locale.FRENCH)); 
     assertEquals("ap. J.-C.", test.era().getField().getAsText(1, Locale.FRENCH)); 
     assertEquals("AD", test.era().getAsShortText()); 
     assertEquals("AD", test.era().getField().getAsShortText(1, Locale.ENGLISH)); 
     assertEquals("ap. J.-C.", test.era().getAsShortText(Locale.FRENCH)); 
     assertEquals("ap. J.-C.", test.era().getField().getAsShortText(1, Locale.FRENCH)); 
     assertEquals(test.getChronology().eras(), test.era().getDurationField()); 
     assertEquals(null, test.era().getRangeDurationField()); 
     assertEquals(2, test.era().getMaximumTextLength(null)); 
     assertEquals(9, test.era().getMaximumTextLength(Locale.FRENCH)); 
     assertEquals(2, test.era().getMaximumShortTextLength(null)); 
     assertEquals(9, test.era().getMaximumShortTextLength(Locale.FRENCH)); 
 }
public void testPropertyAddMonthOfYear732() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().addToCopy(8); 
     assertEquals(2005, copy.getYear()); 
     assertEquals(2, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyWithMaximumValueMonthOfYear733() { 
     DateMidnight test = new DateMidnight(2004, 6, 9); 
     DateMidnight copy = test.monthOfYear().withMaximumValue(); 
     assertEquals(2004, copy.getYear()); 
     assertEquals(2, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyWithMinimumValueDayOfMonth734() { 
     DateMidnight test = new DateMidnight(1972, 6, 9); 
     DateMidnight copy = test.dayOfMonth().withMinimumValue(); 
     assertEquals(1972, copy.getYear()); 
     assertEquals(2, copy.getMonthOfYear()); 
     assertEquals(9, copy.getDayOfMonth()); 
 }
public void testPropertyRoundFloorMonthOfYear735() { 
     DateMidnight test = new DateMidnight(2004, 6, 16); 
     DateMidnight copy = test.monthOfYear().roundFloorCopy(); 
     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 17); 
     copy = test.monthOfYear().roundFloorCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 15); 
     copy = test.monthOfYear().roundFloorCopy(); 
     assertEquals("2004-06-01T00:00:00.000+01:00", copy.toString()); 
 }
public void testPropertyRoundCeilingMonthOfYear736() { 
     DateMidnight test = new DateMidnight(2004, 6, 16); 
     DateMidnight copy = test.monthOfYear().roundCeilingCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 17); 
     copy = test.monthOfYear().roundCeilingCopy(); 
     assertEquals("2004-07-01T00:00:00.000+01:00", copy.toString()); 
     test = new DateMidnight(2004, 6, 15); 
     copy = test.monthOfYear().roundCeilingCopy(); 
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
