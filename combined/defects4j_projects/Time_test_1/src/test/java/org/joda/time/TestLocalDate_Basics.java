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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.chrono.StrictChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for LocalDate.
 *
 * @author Stephen Colebourne
 */
public class TestLocalDate_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
//    private static final int OFFSET = 1;
    private static final GJChronology GJ_UTC = GJChronology.getInstanceUTC();
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
//    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final Chronology ISO_LONDON = ISOChronology.getInstance(LONDON);
//    private static final Chronology ISO_TOKYO = ISOChronology.getInstance(TOKYO);
//    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_PARIS = BuddhistChronology.getInstance(PARIS);
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
//    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();

    /** Mock zone simulating Asia/Gaza cutover at midnight 2007-04-01 */
    private static long CUTOVER_GAZA = 1175378400000L;
    private static int OFFSET_GAZA = 7200000;  // +02:00
    private static final DateTimeZone MOCK_GAZA = new MockZone(CUTOVER_GAZA, OFFSET_GAZA, 3600);

    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
//    private long TEST_TIME1 =
//        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 12L * DateTimeConstants.MILLIS_PER_HOUR
//        + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
//        
//    private long TEST_TIME2 =
//        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
//        + 14L * DateTimeConstants.MILLIS_PER_HOUR
//        + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private DateTimeZone zone = null;

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestLocalDate_Basics.class);
    }

    public TestLocalDate_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
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
public void test_LocalDate_toDateMidnight_Gaza291() { 
     LocalDate date = new LocalDate(2007, 4, 1); 
     try { 
         date.toDateMidnight(MOCK_GAZA); 
         fail(); 
     } catch (IllegalInstantException ex) { 
         assertEquals(true, ex.getMessage().startsWith("Illegal instant due to time zone offset transition")); 
     } 
 }
public void testPropertyGetDay292() { 
     LocalDate test = new LocalDate(1972, 6, 9); 
     assertSame(test.getChronology().dayOfMonth(), test.dayOfMonth().getField()); 
     assertEquals("dayOfMonth", test.dayOfMonth().getName()); 
     assertEquals("Property[dayOfMonth]", test.dayOfMonth().toString()); 
     assertSame(test, test.dayOfMonth().getLocalDate()); 
     assertEquals(9, test.dayOfMonth().get()); 
     assertEquals("9", test.dayOfMonth().getAsString()); 
     assertEquals("9", test.dayOfMonth().getAsText()); 
     assertEquals("9", test.dayOfMonth().getAsText(Locale.FRENCH)); 
     assertEquals("9", test.dayOfMonth().getAsShortText()); 
     assertEquals("9", test.dayOfMonth().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().days(), test.dayOfMonth().getDurationField()); 
     assertEquals(test.getChronology().months(), test.dayOfMonth().getRangeDurationField()); 
     assertEquals(2, test.dayOfMonth().getMaximumTextLength(null)); 
     assertEquals(2, test.dayOfMonth().getMaximumShortTextLength(null)); 
 }
public void testToDateTimeAtStartOfDay293() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTimeAtStartOfDay(); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.year().setCopy(2005); 
     expected = expected.monthOfYear().setCopy(6); 
     expected = expected.dayOfMonth().setCopy(9); 
     assertEquals(expected, test); 
 }
public void testToDateTimeAtStartOfDay294() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtStartOfDay(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 }
public void testToDateTimeAtStartOfDay_nullZone295() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtStartOfDay((DateTimeZone) null); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 }
public void testToDateTimeAtCurrentTime296() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTimeAtCurrentTime(); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.year().setCopy(2005); 
     expected = expected.monthOfYear().setCopy(6); 
     expected = expected.dayOfMonth().setCopy(9); 
     assertEquals(expected, test); 
 }
@SuppressWarnings("deprecation") 
 public void testToDateMidnight297() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateMidnight test = base.toDateMidnight(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateMidnight(2005, 6, 9, COPTIC_LONDON), test); 
 }
public void testToLocalDateTime_nullLocalTime298() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     try { 
         base.toLocalDateTime((LocalTime) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToDateTime_LocalTime299() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     LocalTime tod = new LocalTime(12, 13, 14, 15, BUDDHIST_PARIS); 
     DateTime test = base.toDateTime(tod); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(2005, 6, 9, 12, 13, 14, 15, BUDDHIST_LONDON); 
     assertEquals(expected, test); 
 }
public void testWithFieldAdded_DurationFieldType_int_1301() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     LocalDate result = test.withFieldAdded(DurationFieldType.years(), 6); 
     assertEquals(new LocalDate(2004, 6, 9), test); 
     assertEquals(new LocalDate(2010, 6, 9), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_2302() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusMonths_int303() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.plusMonths(1); 
     LocalDate expected = new LocalDate(2002, 6, 3, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusMonths(0); 
     assertSame(test, result); 
 }
public void testMinusYears_int304() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.minusYears(1); 
     LocalDate expected = new LocalDate(2001, 5, 3, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusYears(0); 
     assertSame(test, result); 
 }
public void testGetValues305() { 
     LocalDate test = new LocalDate(); 
     int[] values = test.getValues(); 
     assertEquals(1970, values[0]); 
     assertEquals(6, values[1]); 
     assertEquals(9, values[2]); 
     assertNotSame(test.getValues(), test.getValues()); 
 }
public void testWithers307() { 
     LocalDate test = new LocalDate(1970, 6, 9, GJ_UTC); 
     check(test.withYear(2000), 2000, 6, 9); 
     check(test.withMonthOfYear(2), 1970, 2, 9); 
     check(test.withDayOfMonth(2), 1970, 6, 2); 
     check(test.withDayOfYear(6), 1970, 1, 6); 
     check(test.withDayOfWeek(6), 1970, 6, 13); 
     check(test.withWeekOfWeekyear(6), 1970, 2, 3); 
     check(test.withWeekyear(1971), 1971, 6, 15); 
     check(test.withYearOfCentury(60), 1960, 6, 9); 
     check(test.withCenturyOfEra(21), 2070, 6, 9); 
     check(test.withYearOfEra(1066), 1066, 6, 9); 
     check(test.withEra(DateTimeConstants.BC), -1970, 6, 9); 
     try { 
         test.withMonthOfYear(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withMonthOfYear(13); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToString_String_Locale308() { 
     LocalDate test = new LocalDate(2002, 6, 9); 
     assertEquals("2002 \ufffd\ufffd", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("2002-06-09", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06-09", test.toString(null, Locale.ENGLISH)); 
     assertEquals("2002-06-09", test.toString("EEE d/M", null)); 
     assertEquals("2002-06-09", test.toString(null, null)); 
 }
public void testToString_String_Locale309() { 
     LocalDate test = new LocalDate(2002, 6, 9); 
     assertEquals("\ufffd \ufffd/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd \ufffd/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06-09", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd \ufffd/6", test.toString("EEE d/M", null)); 
     assertEquals("2002-06-09", test.toString(null, null)); 
 }
public void testToString_String_Locale548() { 
     YearMonthDay test = new YearMonthDay(2002, 6, 9); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06-09", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", null)); 
     assertEquals("2002-06-09", test.toString(null, null)); 
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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    private void check(LocalDate test, int hour, int min, int sec) {
        assertEquals(hour, test.getYear());
        assertEquals(min, test.getMonthOfYear());
        assertEquals(sec, test.getDayOfMonth());
    }
}
