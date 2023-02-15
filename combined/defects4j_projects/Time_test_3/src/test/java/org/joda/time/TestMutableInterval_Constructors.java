/*
 *  Copyright 2001-2005 Stephen Colebourne
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
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.convert.ConverterManager;
import org.joda.time.convert.IntervalConverter;

/**
 * This class is a JUnit test for Interval.
 *
 * @author Stephen Colebourne
 */
public class TestMutableInterval_Constructors extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    
    long y2002days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365;
    long y2003days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365 + 365;
    
    // 2002-06-09
    private long TEST_TIME_NOW =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    // 2002-04-05
    private long TEST_TIME1 =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    // 2003-05-06
    private long TEST_TIME2 =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMutableInterval_Constructors.class);
    }

    public TestMutableInterval_Constructors(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(PARIS);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
    }

    //-----------------------------------------------------------------------
public void testConstructor_RI_RP6334() throws Throwable { 
     long result = TEST_TIME_NOW; 
     result = ISOChronology.getInstance().monthOfYear().add(result, 6); 
     result = ISOChronology.getInstance().hourOfDay().add(result, 1); 
     Duration dur = new Duration(result - TEST_TIME_NOW); 
     MutableInterval test = new MutableInterval((ReadableInstant) null, dur); 
     assertEquals(TEST_TIME_NOW, test.getStartMillis()); 
     assertEquals(result, test.getEndMillis()); 
 }
public void testConstructor_RI_RP6335() throws Throwable { 
     DateTime dt = new DateTime(TEST_TIME_NOW); 
     Interval test = new Interval(dt, (ReadablePeriod) null); 
     assertEquals(dt.getMillis(), test.getStartMillis()); 
     assertEquals(dt.getMillis(), test.getEndMillis()); 
 }
public void testConstructor_Object_Chronology1336() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime dt2 = new DateTime(2005, 7, 10, 1, 1, 1, 1); 
     Interval base = new Interval(dt1, dt2); 
     MutableInterval test = new MutableInterval(base, BuddhistChronology.getInstance()); 
     assertEquals(dt1.getMillis(), test.getStartMillis()); 
     assertEquals(dt2.getMillis(), test.getEndMillis()); 
     assertEquals(BuddhistChronology.getInstance(), test.getChronology()); 
 }
public void testConstructor_RI_RP7610() throws Throwable { 
     long result = TEST_TIME_NOW; 
     result = ISOChronology.getInstance().months().add(result, 6); 
     result = ISOChronology.getInstance().hours().add(result, 1); 
     DateTime dt = new DateTime(TEST_TIME_NOW); 
     Period dur = new Period(0, 6, 0, 0, 1, 0, 0, 0); 
     MutableInterval test = new MutableInterval(dt, dur); 
     assertEquals(dt.getMillis(), test.getStartMillis()); 
     assertEquals(result, test.getEndMillis()); 
 }
public void testSetInterval_RI_RI3611() { 
     MutableInterval test = new MutableInterval(TEST_TIME1, TEST_TIME2); 
     test.setInterval(null, new Instant(TEST_TIME2 + 1)); 
     assertEquals(TEST_TIME_NOW, test.getStartMillis()); 
     assertEquals(TEST_TIME2 + 1, test.getEndMillis()); 
 }
public void testSetChronology_Chronology1612() { 
     MutableInterval test = new MutableInterval(TEST_TIME1, TEST_TIME2); 
     test.setChronology(ISOChronology.getInstance()); 
     assertEquals(TEST_TIME1, test.getStartMillis()); 
     assertEquals(TEST_TIME2, test.getEndMillis()); 
     assertEquals(ISOChronology.getInstance(), test.getChronology()); 
 }
public void testSetChronology_RI3613() { 
     MutableInterval test = new MutableInterval(TEST_TIME1, TEST_TIME2); 
     test.setChronology(null); 
     assertEquals(TEST_TIME1, test.getStartMillis()); 
     assertEquals(TEST_TIME1, test.getEndMillis()); 
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
    

    

    

    

    

    

    class MockInterval implements ReadableInterval {
        public Chronology getChronology() {
            return ISOChronology.getInstance();
        }
        public long getStartMillis() {
            return 1234L;
        }
        public DateTime getStart() {
            return new DateTime(1234L);
        }
        public long getEndMillis() {
            return 5678L;
        }
        public DateTime getEnd() {
            return new DateTime(5678L);
        }
        public long toDurationMillis() {
            return (5678L - 1234L);
        }
        public Duration toDuration() {
            return new Duration(5678L - 1234L);
        }
        public boolean contains(long millisInstant) {
            return false;
        }
        public boolean containsNow() {
            return false;
        }
        public boolean contains(ReadableInstant instant) {
            return false;
        }
        public boolean contains(ReadableInterval interval) {
            return false;
        }
        public boolean overlaps(ReadableInterval interval) {
            return false;
        }
        public boolean isBefore(ReadableInstant instant) {
            return false;
        }
        public boolean isBefore(ReadableInterval interval) {
            return false;
        }
        public boolean isAfter(ReadableInstant instant) {
            return false;
        }
        public boolean isAfter(ReadableInterval interval) {
            return false;
        }
        public Interval toInterval() {
            return null;
        }
        public MutableInterval toMutableInterval() {
            return null;
        }
        public Period toPeriod() {
            return null;
        }
        public Period toPeriod(PeriodType type) {
            return null;
        }
    }

    //-----------------------------------------------------------------------
    

    

}
