/*
 *  Copyright 2001-2010 Stephen Colebourne
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
public class TestLocalDate_Properties extends TestCase {

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
        return new TestSuite(TestLocalDate_Properties.class);
    }

    public TestLocalDate_Properties(String name) {
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
public void testPropertyCompareToDay289() { 
     LocalDate test1 = new LocalDate(TEST_TIME1); 
     LocalDate test2 = new LocalDate(TEST_TIME2); 
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
public void testProperty295() { 
     LocalDate test = new LocalDate(); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); 
     assertEquals(test.dayOfYear(), test.property(DateTimeFieldType.dayOfYear())); 
     assertEquals(test.weekOfWeekyear(), test.property(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(test.weekyear(), test.property(DateTimeFieldType.weekyear())); 
     assertEquals(test.yearOfCentury(), test.property(DateTimeFieldType.yearOfCentury())); 
     assertEquals(test.yearOfEra(), test.property(DateTimeFieldType.yearOfEra())); 
     assertEquals(test.centuryOfEra(), test.property(DateTimeFieldType.centuryOfEra())); 
     assertEquals(test.era(), test.property(DateTimeFieldType.era())); 
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
public void testIsSupported_DateTimeFieldType297() { 
     LocalDate test = new LocalDate(COPTIC_PARIS); 
     assertEquals(true, test.isSupported(DateTimeFieldType.year())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.monthOfYear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfMonth())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfWeek())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfYear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.weekyear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.yearOfCentury())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.yearOfEra())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.centuryOfEra())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.weekyearOfCentury())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.era())); 
     assertEquals(false, test.isSupported(DateTimeFieldType.hourOfDay())); 
     assertEquals(false, test.isSupported((DateTimeFieldType) null)); 
 }
public void testPropertyAddWrapFieldToCopyYear313() { 
     LocalDate test = new LocalDate(1972, 6, 9); 
     LocalDate copy = test.year().addWrapFieldToCopy(9); 
     check(test, 1972, 6, 9); 
     check(copy, 1981, 6, 9); 
     copy = test.year().addWrapFieldToCopy(0); 
     check(copy, 1972, 6, 9); 
     check(copy, 1972, 6, 9); 
     copy = test.year().addWrapFieldToCopy(292278993 - 1972); 
     check(copy, 292278993, 6, 9); 
     try { 
         test.year().addWrapFieldToCopy(292278993 - 1972 + 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 1972, 6, 9); 
     copy = test.year().addWrapFieldToCopy(-1972); 
     check(copy, 0, 6, 9); 
     copy = test.year().addWrapFieldToCopy(-1973); 
     check(copy, -1, 6, 9); 
     try { 
         test.year().addWrapFieldToCopy(-292275054 - 1972 - 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     check(test, 1972, 6, 9); 
 }
public void testPropertyWithMaximumValueDayOfMonth315() { 
     LocalDate test = new LocalDate(1972, 6, 9); 
     LocalDate copy = test.dayOfMonth().withMaximumValue(); 
     check(test, 1972, 6, 9); 
     check(copy, 1972, 6, 30); 
 }
public void testPropertyWithMinimumValueDayOfMonth316() { 
     LocalDate test = new LocalDate(1972, 6, 9); 
     check(test.dayOfMonth().withMinimumValue(), 1972, 6, 9); 
     check(test.dayOfMonth().withMaximumValue(), 1972, 6, 9); 
 }
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    private void check(LocalDate test, int year, int month, int day) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
    }
}
