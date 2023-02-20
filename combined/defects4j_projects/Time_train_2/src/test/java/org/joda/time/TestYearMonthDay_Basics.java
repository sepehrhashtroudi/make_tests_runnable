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

public void testGet3() { 
     YearMonthDay test = new YearMonthDay(); 
     assertEquals(1970, test.get(DateTimeFieldType.year())); 
     assertEquals(6, test.get(DateTimeFieldType.monthOfYear())); 
     assertEquals(9, test.get(DateTimeFieldType.dayOfMonth())); 
     try { 
         test.get(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.get(DateTimeFieldType.hourOfDay()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testEqualsHashCode7() { 
     YearMonthDay test1 = new YearMonthDay(1970, 6, 9, COPTIC_PARIS); 
     YearMonthDay test2 = new YearMonthDay(1970, 6, 9, COPTIC_PARIS); 
     assertEquals(true, test1.equals(test2)); 
     assertEquals(true, test2.equals(test1)); 
     assertEquals(true, test1.equals(test1)); 
     assertEquals(true, test2.equals(test2)); 
     assertEquals(true, test1.hashCode() == test2.hashCode()); 
     assertEquals(true, test1.hashCode() == test1.hashCode()); 
     assertEquals(true, test2.hashCode() == test2.hashCode()); 
     YearMonthDay test3 = new YearMonthDay(1971, 6, 9); 
     assertEquals(false, test1.equals(test3)); 
     assertEquals(false, test2.equals(test3)); 
     assertEquals(false, test3.equals(test1)); 
     assertEquals(false, test3.equals(test2)); 
     assertEquals(false, test1.hashCode() == test3.hashCode()); 
     assertEquals(false, test2.hashCode() == test3.hashCode()); 
     assertEquals(false, test1.equals("Hello")); 
     assertEquals(true, test1.equals(new MockInstant())); 
     assertEquals(false, test1.equals(MockPartial.EMPTY_INSTANCE)); 
 } 


public void testIsBefore_YMD9() { 
     YearMonthDay test1 = new YearMonthDay(2005, 6, 2); 
     YearMonthDay test1a = new YearMonthDay(2005, 6, 2); 
     assertEquals(false, test1.isBefore(test1a)); 
     assertEquals(false, test1a.isBefore(test1)); 
     assertEquals(false, test1.isBefore(test1)); 
     assertEquals(false, test1a.isBefore(test1a)); 
     YearMonthDay test2 = new YearMonthDay(2005, 7, 2); 
     assertEquals(true, test1.isBefore(test2)); 
     assertEquals(false, test2.isBefore(test1)); 
     YearMonthDay test3 = new YearMonthDay(2005, 7, 2, GregorianChronology.getInstanceUTC()); 
     assertEquals(true, test1.isBefore(test3)); 
     assertEquals(false, test3.isBefore(test1)); 
     assertEquals(false, test3.isBefore(test2)); 
     try { 
         new YearMonthDay(2005, 7, 2).isBefore(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testGetField18() { 
     YearMonthDay test = new YearMonthDay(COPTIC_PARIS); 
     assertSame(COPTIC_UTC.year(), test.getField(0)); 
     assertSame(COPTIC_UTC.monthOfYear(), test.getField(1)); 
     assertSame(COPTIC_UTC.dayOfMonth(), test.getField(2)); 
     try { 
         test.getField(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getField(3); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 } 


public void testWithField322() { 
     YearMonthDay test = new YearMonthDay(2004, 6, 9); 
     try { 
         test.withField(DateTimeFieldType.hourOfDay(), 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testGetFieldTypes24() { 
     YearMonthDay test = new YearMonthDay(COPTIC_PARIS); 
     DateTimeFieldType[] fields = test.getFieldTypes(); 
     assertSame(DateTimeFieldType.year(), fields[0]); 
     assertSame(DateTimeFieldType.monthOfYear(), fields[1]); 
     assertSame(DateTimeFieldType.dayOfMonth(), fields[2]); 
     assertNotSame(test.getFieldTypes(), test.getFieldTypes()); 
 } 


public void testWithChronologyRetainFields_sameChrono25() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     YearMonthDay test = base.withChronologyRetainFields(COPTIC_TOKYO); 
     assertSame(base, test); 
 } 


public void testWithField426() { 
     YearMonthDay test = new YearMonthDay(2004, 6, 9); 
     YearMonthDay result = test.withField(DateTimeFieldType.year(), 2004); 
     assertEquals(new YearMonthDay(2004, 6, 9), test); 
     assertSame(test, result); 
 } 


public void testWithField127() { 
     YearMonthDay test = new YearMonthDay(2004, 6, 9); 
     YearMonthDay result = test.withField(DateTimeFieldType.year(), 2006); 
     assertEquals(new YearMonthDay(2004, 6, 9), test); 
     assertEquals(new YearMonthDay(2006, 6, 9), result); 
 } 


public void testMinusMonths_int28() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.minusMonths(1); 
     YearMonthDay expected = new YearMonthDay(2002, 4, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
 } 


public void testPlus_RP29() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.plus(new Period(1, 2, 3, 4, 5, 6, 7, 8)); 
     YearMonthDay expected = new YearMonthDay(2003, 7, 7, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.plus((ReadablePeriod) null); 
     assertSame(test, result); 
 } 


public void testPlusDays_int30() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.plusDays(1); 
     YearMonthDay expected = new YearMonthDay(2002, 5, 4, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.plusDays(0); 
     assertSame(test, result); 
 } 


public void testMinusYears_int31() { 
     YearMonthDay test = new YearMonthDay(2002, 5, 3, BuddhistChronology.getInstance()); 
     YearMonthDay result = test.minusYears(1); 
     YearMonthDay expected = new YearMonthDay(2001, 5, 3, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusYears(0); 
     assertSame(test, result); 
 } 


public void testProperty32() { 
     YearMonthDay test = new YearMonthDay(2005, 6, 9); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
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


public void testToDateTimeAtMidnight33() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtMidnight(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 } 


public void testToDateTimeAtMidnight_nullZone34() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     DateTime test = base.toDateTimeAtMidnight((DateTimeZone) null); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateTime(2005, 6, 9, 0, 0, 0, 0, COPTIC_LONDON), test); 
 } 


public void testToDateTimeAtCurrentTime35() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
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


public void testToDateMidnight36() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     DateMidnight test = base.toDateMidnight(); 
     check(base, 2005, 6, 9); 
     assertEquals(new DateMidnight(2005, 6, 9, COPTIC_LONDON), test); 
 } 


public void testWithers37() { 
     YearMonthDay test = new YearMonthDay(1970, 6, 9); 
     check(test.withYear(2000), 2000, 6, 9); 
     check(test.withMonthOfYear(2), 1970, 2, 9); 
     check(test.withDayOfMonth(2), 1970, 6, 2); 
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


public void testToDateTime_TOD_nullZone812() { 
     YearMonthDay base = new YearMonthDay(2005, 6, 9, COPTIC_PARIS); 
     TimeOfDay tod = new TimeOfDay(12, 13, 14, 15, BUDDHIST_TOKYO); 
     DateTime test = base.toDateTime(tod, null); 
     check(base, 2005, 6, 9); 
     DateTime expected = new DateTime(2005, 6, 9, 12, 13, 14, 15, COPTIC_LONDON); 
     assertEquals(expected, test); 
 } 


public void testCompareTo1406() { 
     YearMonthDay test1 = new YearMonthDay(2005, 6, 2); 
     YearMonthDay test1a = new YearMonthDay(2005, 6, 2); 
     assertEquals(0, test1.compareTo(test1a)); 
     assertEquals(0, test1a.compareTo(test1)); 
     assertEquals(0, test1.compareTo(test1)); 
     assertEquals(0, test1a.compareTo(test1a)); 
     YearMonthDay test2 = new YearMonthDay(2005, 7, 2); 
     assertEquals(-1, test1.compareTo(test2)); 
     assertEquals(+1, test2.compareTo(test1)); 
     YearMonthDay test3 = new YearMonthDay(2005, 7, 2, GregorianChronology.getInstanceUTC()); 
     assertEquals(-1, test1.compareTo(test3)); 
     assertEquals(+1, test3.compareTo(test1)); 
     assertEquals(0, test3.compareTo(test2)); 
     DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() }; 
     int[] values = new int[] { 2005, 6, 2 }; 
     Partial p = new Partial(types, values); 
     assertEquals(0, test1.compareTo(p)); 
     try { 
         test1.compareTo(null); 
         fail(); 
     } catch (NullPointerException ex) { 
     } 
     try { 
         test1.compareTo(new TimeOfDay()); 
         fail(); 
     } catch (ClassCastException ex) { 
     } 
     Partial partial = new Partial().with(DateTimeFieldType.centuryOfEra(), 1).with(DateTimeFieldType.halfdayOfDay(), 0).with(DateTimeFieldType.dayOfMonth(), 9); 
     try { 
         new YearMonthDay(1970, 6, 9).compareTo(partial); 
         fail(); 
     } catch (ClassCastException ex) { 
     } 
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