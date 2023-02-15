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
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for LocalTime.
 *
 * @author Stephen Colebourne
 */
public class TestLocalTime_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);

    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;

//    private long TEST_TIME1 =
//        1L * DateTimeConstants.MILLIS_PER_HOUR
//        + 2L * DateTimeConstants.MILLIS_PER_MINUTE
//        + 3L * DateTimeConstants.MILLIS_PER_SECOND
//        + 4L;

    private long TEST_TIME2 =
        1L * DateTimeConstants.MILLIS_PER_DAY
        + 5L * DateTimeConstants.MILLIS_PER_HOUR
        + 6L * DateTimeConstants.MILLIS_PER_MINUTE
        + 7L * DateTimeConstants.MILLIS_PER_SECOND
        + 8L;

    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestLocalTime_Basics.class);
    }

    public TestLocalTime_Basics(String name) {
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
public void testGetField_int464() { 
     LocalTime test = new LocalTime(COPTIC_PARIS); 
     assertSame(COPTIC_UTC.hourOfDay(), test.getField(0)); 
     assertSame(COPTIC_UTC.minuteOfHour(), test.getField(1)); 
     assertSame(COPTIC_UTC.secondOfMinute(), test.getField(2)); 
     assertSame(COPTIC_UTC.millisOfSecond(), test.getField(3)); 
     try { 
         test.getField(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getField(5); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 }
public void testWithField_DateTimeFieldType_int_3469() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     try { 
         test.withField(DateTimeFieldType.dayOfMonth(), 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithField_DateTimeFieldType_int_1470() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime result = test.withField(DateTimeFieldType.hourOfDay(), 15); 
     assertEquals(new LocalTime(10, 20, 30, 40), test); 
     assertEquals(new LocalTime(15, 20, 30, 40), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_3471() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     try { 
         test.withFieldAdded(null, 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusMillis_int472() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusMillis(1); 
     LocalTime expected = new LocalTime(1, 2, 3, 5, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusMillis(0); 
     assertSame(test, result); 
 }
public void testMinusHours_int473() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.minusHours(1); 
     LocalTime expected = new LocalTime(2, 2, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusHours(0); 
     assertSame(test, result); 
 }
public void testWithers474() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     check(test.withHourOfDay(6), 6, 20, 30, 40); 
     check(test.withMinuteOfHour(6), 10, 6, 30, 40); 
     check(test.withSecondOfMinute(6), 10, 20, 6, 40); 
     check(test.withMillisOfSecond(6), 10, 20, 30, 6); 
     check(test.withMillisOfDay(61234), 0, 1, 1, 234); 
     try { 
         test.withHourOfDay(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withHourOfDay(24); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testToDateTimeToday477() { 
     LocalTime base = new LocalTime(10, 20, 30, 40, COPTIC_PARIS); 
     DateTime dt = new DateTime(2004, 6, 9, 6, 7, 8, 9); 
     DateTimeUtils.setCurrentMillisFixed(dt.getMillis()); 
     DateTime test = base.toDateTimeToday(); 
     check(base, 10, 20, 30, 40); 
     DateTime expected = new DateTime(dt.getMillis(), COPTIC_LONDON); 
     expected = expected.hourOfDay().setCopy(10); 
     expected = expected.minuteOfHour().setCopy(20); 
     expected = expected.secondOfMinute().setCopy(30); 
     expected = expected.millisOfSecond().setCopy(40); 
     assertEquals(expected, test); 
 }
    

    

    

    

    

    

    

    

    

    

    

    class MockInstant extends MockPartial {
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.hourOfDay(),
                COPTIC_UTC.minuteOfHour(),
                COPTIC_UTC.secondOfMinute(),
                COPTIC_UTC.millisOfSecond(),
            };
        }
        public int[] getValues() {
            return new int[] {10, 20, 30, 40};
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
    private void check(LocalTime test, int hour, int min, int sec, int milli) {
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(milli, test.getMillisOfSecond());
    }
}
