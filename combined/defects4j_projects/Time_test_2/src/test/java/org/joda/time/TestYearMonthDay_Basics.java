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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for YearMonthDay.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestYearMonthDay_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();
    
    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;

    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestYearMonthDay_Basics.class);
    }

    public TestYearMonthDay_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
    }

    //-----------------------------------------------------------------------
public void testWithChronologyRetainFields_sameChrono19() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     YearMonthDay test = base.withChronologyRetainFields(COPTIC_TOKYO); 
     assertSame(base, test); 
 }
public void testMinus_RP20() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.minus(new Period(1, 1, 1, 1, 1, 1, 1, 1)); 
     YearMonthDay expected = new YearMonthDay(2001, 3, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minus((ReadablePeriod) null); 
     assertSame(test, result); 
 }
public void testPlusYears_int21() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.plusYears(1); 
     YearMonthDay expected = new YearMonthDay(2003, 5, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.plusYears(0); 
     assertSame(test, result); 
 }
public void testPlusMonths_int22() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.plusMonths(1); 
     YearMonthDay expected = new YearMonthDay(2002, 6, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.plusMonths(0); 
     assertSame(test, result); 
 }
public void testMinusDays_int23() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.minusDays(1); 
     YearMonthDay expected = new YearMonthDay(2002, 5, 2, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 }
public void testToLocalDate24() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     LocalDate test = base.toLocalDate(); 
     assertEquals(new LocalDate(2005, 6, 9, COPTIC_LONDON), test); 
 }
public void testToDateTime_nullTime27() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTime((TimeOfDay) null); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.year().setCopy(2005); 
     expected = expected.monthOfYear().setCopy(6); 
     expected = expected.dayOfMonth().setCopy(9); 
     assertEquals(expected, test); 
 }
public void testToDateTime_DateTimeZone28() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     TimeOfDay tod = new TimeOfDay(12, 13, 14, 15, COPTIC_TOKYO); 
     DateTime test = base.toDateTime(tod, null); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(2005, 6, 9, 12, 13, 14, 15, COPTIC_LONDON); 
     assertEquals(expected, test); 
 }
public void testToString31() { 
     YearMonthDay test = new YearMonthDay(2002, 6, 9); 
     assertEquals("2002-06-09", test.toString()); 
 }
public void testToString_String_Locale471() { 
     LocalDate test = new LocalDate(1970, 6, 9); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("mar. 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("1970-06-09", test.toString(null, Locale.ENGLISH)); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", null)); 
     assertEquals("1970-06-09", test.toString(null, null)); 
 }
public void testToString_String_Locale624() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     assertEquals("10 20", test.toString("H m", Locale.ENGLISH)); 
     assertEquals("10:20:30.040", test.toString(null, Locale.ENGLISH)); 
     assertEquals("10 20", test.toString("H m", null)); 
     assertEquals("10:20:30.040", test.toString(null, null)); 
 }
    

    

    

    

    

    

    

    

    

    
    
    class MockInstant extends MockPartial {
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.year(),
                COPTIC_UTC.monthOfYear(),
                COPTIC_UTC.dayOfMonth(),
            };
        }
        public int[] getValues() {
            return new int[] {1970, 6, 9};
        }
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
    private void check(YearMonthDay test, int hour, int min, int sec) {
        assertEquals(hour, test.getYear());
        assertEquals(min, test.getMonthOfYear());
        assertEquals(sec, test.getDayOfMonth());
    }
}
