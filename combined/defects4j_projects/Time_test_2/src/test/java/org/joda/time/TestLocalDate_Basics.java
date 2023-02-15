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
public void testPropertyGetWeekyear100() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().weekyear(), test.weekyear().getField()); 
     assertEquals("weekyear", test.weekyear().getName()); 
     assertEquals("Property[weekyear]", test.weekyear().toString()); 
     assertSame(test, test.weekyear().getDateTime()); 
     assertEquals(4, test.weekyear().get()); 
     assertEquals("4", test.weekyear().getAsString()); 
     assertEquals("4", test.weekyear().getAsText()); 
     assertEquals("4", test.weekyear().getAsText(Locale.FRENCH)); 
     assertEquals("4", test.weekyear().getAsShortText()); 
     assertEquals("4", test.weekyear().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().weekyears(), test.weekyear().getDurationField()); 
     assertEquals(null, test.weekyear().getRangeDurationField()); 
     assertEquals(9, test.weekyear().getMaximumTextLength(null)); 
     assertEquals(9, test.weekyear().getMaximumShortTextLength(null)); 
 }
public void testPropertyGetEra206() { 
     DateTime test = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     assertSame(test.getChronology().era(), test.era().getField()); 
     assertEquals("era", test.era().getName()); 
     assertEquals("Property[era]", test.era().toString()); 
     assertSame(test, test.era().getDateTime()); 
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
public void testFactory_fromDateFields_before1970299() throws Exception { 
     GregorianCalendar cal = new GregorianCalendar(1969, 1, 3, 4, 5, 6); 
     cal.set(Calendar.MILLISECOND, 7); 
     LocalDate expected = new LocalDate(1969, 2, 3); 
     assertEquals(expected, LocalDate.fromDateFields(cal.getTime())); 
 }
public void testGet_DateTimeFieldType301() { 
     LocalDate test = new LocalDate(2002, 6, 9); 
     assertEquals(1970, test.get(DateTimeFieldType.year())); 
     assertEquals(6, test.get(DateTimeFieldType.monthOfYear())); 
     assertEquals(9, test.get(DateTimeFieldType.dayOfMonth())); 
     assertEquals(160, test.get(DateTimeFieldType.dayOfWeek())); 
     assertEquals(2, test.get(DateTimeFieldType.dayOfYear())); 
     assertEquals(2, test.get(DateTimeFieldType.weekOfWeekyear())); 
     assertEquals(1970, test.get(DateTimeFieldType.weekyear())); 
     assertEquals(70, test.get(DateTimeFieldType.yearOfCentury())); 
     assertEquals(20, test.get(DateTimeFieldType.yearOfEra())); 
     assertEquals(1970, test.get(DateTimeFieldType.yearOfEra())); 
     assertEquals(20, test.get(DateTimeFieldType.centuryOfEra())); 
     assertEquals(1970, test.get(DateTimeFieldType.era())); 
     try { 
         test.get(DateTimeFieldType.millisOfDay()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.get(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToDate_autumnDST302() { 
     LocalDate base = new LocalDate(2007, 10, 2); 
     SimpleTimeZone testZone = new SimpleTimeZone(3600000, "NoMidnight", Calendar.APRIL, 2, 0, 0, Calendar.OCTOBER, 2, 0, 3600000); 
     TimeZone currentZone = TimeZone.getDefault(); 
     try { 
         TimeZone.setDefault(testZone); 
         Date test = base.toDate(); 
         check(base, 2007, 10, 2); 
         assertEquals("Tue Oct 02 00:00:00 GMT+02:00 2007", test.toString()); 
     } finally { 
         TimeZone.setDefault(currentZone); 
     } 
 }
public void testToDateTimeAtMidnight303() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtMidnight(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 }
public void testToDateTimeAtMidnight_nullZone304() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtMidnight((DateTimeZone) null); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 }
public void testToLocalDateTime_LocalTime305() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     LocalTime tod = new LocalTime(12, 13, 14, 15, COPTIC_TOKYO); 
     LocalDateTime test = base.toLocalDateTime(tod); 
     check(base, 2005, 6, 9); 
     LocalDateTime expected = new LocalDateTime(2005, 6, 9, 12, 13, 14, 15, COPTIC_LONDON); 
     assertEquals(expected, test); 
 }
public void testToDateTime_LocalTime_nullZone306() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     LocalTime tod = new LocalTime(12, 13, 14, 15, COPTIC_TOKYO); 
     DateTime test = base.toDateTime(tod, null); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(2005, 6, 9, 12, 13, 14, 15, COPTIC_LONDON); 
     assertEquals(expected, test); 
 }
public void testToInterval_DateTimeZone307() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     Interval test = base.toInterval(LONDON); 
     check(base, 2005, 6, 9); 
     DateTime start = base.toDateTimeAtStartOfDay(); 
     DateTime end = start.plus(Period.days(1)); 
     Interval expected = new Interval(start, end); 
     assertEquals(expected, test); 
 }
public void testToInterval_DateTimeAtStartOfDay308() { 
     LocalDate base = new LocalDate(2005, 6, 9, COPTIC_PARIS); 
     Interval test = base.toInterval(LONDON); 
     check(base, 2005, 6, 9); 
     DateTime start = base.toDateTimeAtStartOfDay(); 
     DateTime end = start.plus(Period.days(1)); 
     Interval expected = new Interval(start, end); 
     assertEquals(expected, test); 
 }
public void testWithField_DateTimeFieldType_int_1309() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     LocalDate result = test.withField(DateTimeFieldType.year(), 2006); 
     assertEquals(new LocalDate(2004, 6, 9), test); 
     assertEquals(new LocalDate(2006, 6, 9), result); 
 }
public void testWithField_DateTimeFieldType_int_2310() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     try { 
         test.withField(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithFieldAdded_DurationFieldType_int_2311() { 
     LocalDate test = new LocalDate(2004, 6, 9); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusWeeks_int312() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.plusWeeks(1); 
     LocalDate expected = new LocalDate(2002, 5, 10, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusWeeks(0); 
     assertSame(test, result); 
 }
public void testPlusDays_int313() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.plusDays(1); 
     LocalDate expected = new LocalDate(2002, 5, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusDays(0); 
     assertSame(test, result); 
 }
public void testMinusMonths_int314() { 
     LocalDate test = new LocalDate(2002, 5, 3, BUDDHIST_LONDON); 
     LocalDate result = test.minusMonths(1); 
     LocalDate expected = new LocalDate(2002, 4, 3, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
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
