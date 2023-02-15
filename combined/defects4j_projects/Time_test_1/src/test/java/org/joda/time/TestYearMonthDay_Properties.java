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
 * This class is a Junit unit test for YearMonthDay.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestYearMonthDay_Properties extends TestCase {

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

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestYearMonthDay_Properties.class);
    }

    public TestYearMonthDay_Properties(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(DateTimeZone.UTC);
        systemDefaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
        Locale.setDefault(systemDefaultLocale);
        systemDefaultLocale = null;
    }

    //-----------------------------------------------------------------------
public void testPropertySetCopyTextDay11() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.dayOfMonth().setCopy("12"); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 6, 12); 
 }
public void testPropertySetTextDay12() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.dayOfMonth().setCopy("12"); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 6, 12); 
 }
public void testPropertyGetYear13() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     assertSame(test.getChronology().year(), test.year().getField()); 
     assertEquals("year", test.year().getName()); 
     assertEquals("Property[year]", test.year().toString()); 
     assertSame(test, test.year().getReadablePartial()); 
     assertSame(test, test.year().getYearMonthDay()); 
     assertEquals(1972, test.year().get()); 
     assertEquals("1972", test.year().getAsString()); 
     assertEquals("1972", test.year().getAsText()); 
     assertEquals("1972", test.year().getAsText(Locale.FRENCH)); 
     assertEquals("1972", test.year().getAsShortText()); 
     assertEquals("1972", test.year().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().years(), test.year().getDurationField()); 
     assertEquals(null, test.year().getRangeDurationField()); 
     assertEquals(9, test.year().getMaximumTextLength(null)); 
     assertEquals(9, test.year().getMaximumShortTextLength(null)); 
 }
public void testPropertyAddWrapFieldDay14() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.dayOfMonth().addWrapFieldToCopy(9); 
     check(test, 1972, 6, 9); 
     check(copy, 1981, 6, 9); 
     copy = test.dayOfMonth().addWrapFieldToCopy(0); 
     check(copy, 1972, 6, 9); 
     copy = test.dayOfMonth().addWrapFieldToCopy(292277023 - 1972); 
     check(copy, 292277023, 6, 9); 
     try { 
         test.dayOfMonth().addWrapFieldToCopy(292278993 - 1972 + 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 1972, 6, 9); 
     copy = test.dayOfMonth().addWrapFieldToCopy(-1972); 
     check(copy, 0, 6, 9); 
     copy = test.dayOfMonth().addWrapFieldToCopy(-1973); 
     check(copy, -1, 6, 9); 
     try { 
         test.dayOfMonth().addWrapFieldToCopy(-292275054 - 1972 - 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 1972, 6, 9); 
 }
public void testPropertyAddWrapFieldMonth15() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.monthOfYear().addWrapFieldToCopy(4); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 10, 30); 
     copy = test.monthOfYear().addWrapFieldToCopy(8); 
     check(copy, 1972, 2, 29); 
     copy = test.monthOfYear().addWrapFieldToCopy(-8); 
     check(copy, 1972, 10, 30); 
     copy = test.monthOfYear().addWrapFieldToCopy(-9); 
     check(copy, 1972, 10, 31); 
 }
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    private void check(YearMonthDay test, int year, int month, int day) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
    }
}
