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
public void testPropertyToIntervalMillisOfSecond405() { 
     DateTime test = new DateTime(2004, 6, 9, 13, 23, 43, 53); 
     Interval testInterval = test.millisOfSecond().toInterval(); 
     assertEquals(new DateTime(2004, 6, 9, 13, 23, 43, 53), testInterval.getStart()); 
     assertEquals(new DateTime(2004, 6, 9, 13, 23, 43, 54), testInterval.getEnd()); 
 }
public void testPropertySetMonthOfYear461() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.monthOfYear().set(12); 
     assertEquals("2004-12-09T00:00:00.000Z", test.toString()); 
 }
public void testPropertyGetWeekOfWeekyear463() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().weekOfWeekyear(), test.weekOfWeekyear().getField()); 
     assertEquals("weekOfWeekyear", test.weekOfWeekyear().getName()); 
     assertEquals("Property[weekOfWeekyear]", test.weekOfWeekyear().toString()); 
     assertEquals(2004, test.weekOfWeekyear().get()); 
     assertEquals("2004", test.weekOfWeekyear().getAsText()); 
     assertEquals("2004", test.weekOfWeekyear().getAsText(Locale.FRENCH)); 
     assertEquals("2004", test.weekOfWeekyear().getAsShortText()); 
     assertEquals("2004", test.weekOfWeekyear().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().weekyears(), test.weekOfWeekyear().getDurationField()); 
     assertEquals(null, test.weekOfWeekyear().getRangeDurationField()); 
     assertEquals(9, test.weekOfWeekyear().getMaximumTextLength(null)); 
     assertEquals(9, test.weekOfWeekyear().getMaximumShortTextLength(null)); 
 }
public void testPropertyAddMonthOfYear464() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.monthOfYear().add(8); 
     assertEquals("2004-02-09T00:00:00.000Z", test.toString()); 
 }
public void testPropertyAddMonthOfYear465() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 0, 0, 0, 0); 
     test.monthOfYear().add(8); 
     assertEquals("2004-12-09T00:00:00.000Z", test.toString()); 
 }
public void testPropertyRoundHalfCeilingHourOfDay466() { 
     MutableDateTime test = new MutableDateTime(2004, 6, 9, 13, 30, 0, 0); 
     test.hourOfDay().roundHalfCeiling(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 14, 30, 0, 1); 
     test.hourOfDay().roundHalfCeiling(); 
     assertEquals("2004-06-09T14:00:00.000+01:00", test.toString()); 
     test = new MutableDateTime(2004, 6, 9, 13, 29, 59, 999); 
     test.hourOfDay().roundHalfCeiling(); 
     assertEquals("2004-06-09T13:00:00.000+01:00", test.toString()); 
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
