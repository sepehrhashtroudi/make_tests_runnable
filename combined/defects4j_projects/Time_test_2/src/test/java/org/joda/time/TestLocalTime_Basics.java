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
public void testProperty408() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals(test.hourOfDay(), test.property(DateTimeFieldType.hourOfDay())); 
     assertEquals(test.minuteOfHour(), test.property(DateTimeFieldType.minuteOfHour())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     assertEquals(test.millisOfDay(), test.property(DateTimeFieldType.millisOfDay())); 
     assertEquals(test, test.property(DateTimeFieldType.minuteOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.secondOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.millisOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.hourOfHalfday()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.halfdayOfDay()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfHalfday()).getLocalTime()); 
     assertEquals(test, test.property(DateTimeFieldType.clockhourOfDay()).getLocalTime()); 
     try { 
         test.property(DateTimeFieldType.dayOfWeek()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testWithFieldAdded_DurationFieldType_int_1409() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime result = test.withFieldAdded(DurationFieldType.hours(), 6); 
     assertEquals(new LocalTime(10, 20, 30, 40), test); 
     assertEquals(new LocalTime(12, 20, 30, 40), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_1410() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime result = test.withFieldAdded(DurationFieldType.hours(), 6); 
     assertEquals(new LocalTime(10, 20, 30, 40), test); 
     assertEquals(new LocalTime(15, 20, 30, 40), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_2411() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     try { 
         test.withFieldAdded(null, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPlusMinutes_int412() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusMinutes(1); 
     LocalTime expected = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusMinutes(0); 
     assertSame(test, result); 
 }
public void testPlusSeconds_int413() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusSeconds(1); LocalTime expected = new LocalTime(2, 2, 4, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusSeconds(0); 
     assertSame(test, result); 
 }
public void testPlusSeconds_int414() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.plusSeconds(1); 
     LocalTime expected = new LocalTime(2, 2, 4, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.plusSeconds(0); 
     assertSame(test, result); 
 }
public void testMinusMinutes_int415() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.minusMinutes(1); 
     LocalTime expected = new LocalTime(1, 1, 3, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusMinutes(0); 
     assertSame(test, result); 
 }
public void testMinusSeconds_int416() { 
     LocalTime test = new LocalTime(1, 2, 3, 4, BUDDHIST_LONDON); 
     LocalTime result = test.minusSeconds(1); 
     LocalTime expected = new LocalTime(1, 2, 2, 4, BUDDHIST_LONDON); 
     assertEquals(expected, result); 
     result = test.minusSeconds(0); 
     assertSame(test, result); 
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
