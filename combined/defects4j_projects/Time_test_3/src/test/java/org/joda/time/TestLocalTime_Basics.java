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
public void testGetValue_int427() { 
     LocalTime test = new LocalTime(10, 20, 30, 40, COPTIC_UTC); 
     assertEquals(COPTIC_UTC.hourOfDay(), test.getValue(0)); 
     assertEquals(COPTIC_UTC.minuteOfHour(), test.getValue(1)); 
     assertEquals(COPTIC_UTC.secondOfMinute(), test.getValue(2)); 
     assertEquals(COPTIC_UTC.millisOfSecond(), test.getValue(3)); 
     try { 
         test.getValue(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getValue(5); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 }
public void testWithField_DateTimeFieldType_int_1430() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime result = test.withField(DateTimeFieldType.hourOfDay(), 15); 
     assertEquals(new LocalTime(10, 20, 30, 40), test); 
     assertEquals(new LocalTime(15, 20, 30, 40), result); 
 }
public void testWithFieldAdded_DurationFieldType_int_1431() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     LocalTime result = test.withFieldAdded(DurationFieldType.hours(), 6); 
     assertEquals(new LocalTime(10, 20, 30, 40), test); 
     assertEquals(new LocalTime(16, 20, 30, 40), result); 
 }
public void testToString_String_Locale433() { 
     LocalTime test = new LocalTime(10, 20, 30, 40); 
     assertEquals("\ufffd\ufffd\ufffd\ufffd 10", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 10", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("10", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 10", test.toString("EEE d/M", null)); 
     assertEquals("10", test.toString(null, null)); 
 }
public void testToString_String_Locale480() { 
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
