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
public void testPropertySetMonth13() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.monthOfYear().setCopy(12); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 12, 9); 
     test = new YearMonthDay(1972, 1, 31); 
     copy = test.monthOfYear().setCopy(2); 
     check(copy, 1972, 2, 29); 
     try { 
         test.monthOfYear().setCopy(13); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.monthOfYear().setCopy(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testGetFieldType17() { 
     YearMonthDay test = new YearMonthDay(COPTIC_PARIS); 
     assertEquals(DateTimeFieldType.year(), test.getFieldType(0)); 
     assertEquals(DateTimeFieldType.monthOfYear(), test.getFieldType(1)); 
     assertEquals(DateTimeFieldType.dayOfMonth(), test.getFieldType(2)); 
     try { 
         test.getFieldType(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getFieldType(3); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 }
public void testPropertyGetMonth32() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     assertSame(test.getChronology().monthOfYear(), test.monthOfYear().getField()); 
     assertEquals("monthOfYear", test.monthOfYear().getName()); 
     assertEquals("Property[monthOfYear]", test.monthOfYear().toString()); 
     assertSame(test, test.monthOfYear().getReadablePartial()); 
     assertSame(test, test.monthOfYear().getYearMonthDay()); 
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
     test = new YearMonthDay(1972, 7, 9); 
     assertEquals("juillet", test.monthOfYear().getAsText(Locale.FRENCH)); 
     assertEquals("juil.", test.monthOfYear().getAsShortText(Locale.FRENCH)); 
 }
public void testPropertyWithMaximumValueDayOfMonth33() { 
     YearMonthDay test = new YearMonthDay(1972, 6, 9); 
     YearMonthDay copy = test.dayOfMonth().withMaximumValue(); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 6, 30); 
 }
public void testProperty191() { 
     MonthDay test = new MonthDay(6, 6); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     try { 
         test.property(DateTimeFieldType.millisOfDay()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyCompareToDay192() { 
     LocalDateTime test1 = new LocalDateTime(TEST_TIME1); 
     LocalDateTime test2 = new LocalDateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfMonth().compareTo(test2) < 0); 
     assertEquals(true, test2.dayOfMonth().compareTo(test1) > 0); 
     assertEquals(true, test1.dayOfMonth().compareTo(test1) == 0); 
     try { 
         test1.dayOfMonth().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfMonth().compareTo(dt2) < 0); 
     assertEquals(true, test2.dayOfMonth().compareTo(dt1) > 0); 
     assertEquals(true, test1.dayOfMonth().compareTo(dt1) == 0); 
     try { 
         test1.dayOfMonth().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
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
