/*
 *  Copyright 2001-2011 Stephen Colebourne
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
 * This class is a Junit unit test for MonthDay. Based on {@link TestYearMonth_Propeties} 
 */
public class TestMonthDay_Properties extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);

    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    private long TEST_TIME1 =
        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 12L * DateTimeConstants.MILLIS_PER_HOUR
        + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private long TEST_TIME2 =
        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 14L * DateTimeConstants.MILLIS_PER_HOUR
        + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private DateTimeZone zone = null;
    private Locale locale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMonthDay_Properties.class);
    }

    public TestMonthDay_Properties(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        locale = Locale.getDefault();
        Locale.setDefault(Locale.UK);
        DateTimeZone.setDefault(DateTimeZone.UTC);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
        Locale.setDefault(locale);
        locale = null;
    }

    //-----------------------------------------------------------------------

public void testPropertyAddWrapFieldDayOfMonth380() { 
     MonthDay test = new MonthDay(4, 6); 
     MonthDay copy = test.dayOfMonth().addWrapFieldToCopy(4); 
     check(test, 4, 6); 
     check(copy, 4, 10); 
     copy = test.dayOfMonth().addWrapFieldToCopy(8); 
     check(copy, 4, 14); 
     copy = test.dayOfMonth().addWrapFieldToCopy(-8); 
     check(copy, 4, 28); 
 } 


public void testPropertyAddMonthOfYear413() { 
     MonthDay test = new MonthDay(3, 6); 
     MonthDay copy = test.monthOfYear().addToCopy(9); 
     check(test, 3, 6); 
     check(copy, 12, 6); 
     copy = test.monthOfYear().addToCopy(0); 
     check(copy, 3, 6); 
     check(test, 3, 6); 
     copy = test.monthOfYear().addToCopy(-3); 
     check(copy, 12, 6); 
     check(test, 3, 6); 
 } 


public void testPropertyGetDayOfMonth1269() { 
     MonthDay test = new MonthDay(4, 6); 
     assertSame(test.getChronology().dayOfMonth(), test.dayOfMonth().getField()); 
     assertEquals("dayOfMonth", test.dayOfMonth().getName()); 
     assertEquals("Property[dayOfMonth]", test.dayOfMonth().toString()); 
     assertSame(test, test.dayOfMonth().getReadablePartial()); 
     assertSame(test, test.dayOfMonth().getMonthDay()); 
     assertEquals(6, test.dayOfMonth().get()); 
     assertEquals("6", test.dayOfMonth().getAsString()); 
     assertEquals("6", test.dayOfMonth().getAsText()); 
     assertEquals("6", test.dayOfMonth().getAsText(Locale.FRENCH)); 
     assertEquals("6", test.dayOfMonth().getAsShortText()); 
     assertEquals("6", test.dayOfMonth().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().days(), test.dayOfMonth().getDurationField()); 
     assertEquals(test.getChronology().months(), test.dayOfMonth().getRangeDurationField()); 
     assertEquals(2, test.dayOfMonth().getMaximumTextLength(null)); 
     assertEquals(2, test.dayOfMonth().getMaximumShortTextLength(null)); 
     test = new MonthDay(4, 7); 
     assertEquals("7", test.dayOfMonth().getAsText(Locale.FRENCH)); 
     assertEquals("7", test.dayOfMonth().getAsShortText(Locale.FRENCH)); 
 } 


public void testPropertyAddWrapFieldMonthOfYear1270() { 
     MonthDay test = new MonthDay(5, 6); 
     MonthDay copy = test.monthOfYear().addWrapFieldToCopy(2); 
     check(test, 5, 6); 
     check(copy, 7, 6); 
     copy = test.monthOfYear().addWrapFieldToCopy(2); 
     check(copy, 7, 6); 
     copy = test.monthOfYear().addWrapFieldToCopy(292278993 - 4 + 1); 
     check(copy, 11, 6); 
     copy = test.monthOfYear().addWrapFieldToCopy(-292275054 - 4 - 1); 
     check(copy, 6, 6); 
 } 


public void testPropertySetMonthOfYear1271() { 
     MonthDay test = new MonthDay(10, 6); 
     MonthDay copy = test.monthOfYear().setCopy(12); 
     check(test, 10, 6); 
     check(copy, 12, 6); 
 } 

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    private void check(MonthDay test, int monthOfYear, int dayOfMonth) {
        assertEquals(monthOfYear, test.getMonthOfYear());
        assertEquals(dayOfMonth, test.getDayOfMonth());
    }
}
