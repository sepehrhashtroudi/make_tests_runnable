/*
 *  Copyright 2001-2011 Stephen Colebourne
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
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.base.AbstractInterval;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.LenientChronology;

/**
 * This class is a Junit unit test for Instant.
 *
 * @author Stephen Colebourne
 */
public class TestInterval_Basics extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone MOSCOW = DateTimeZone.forID("Europe/Moscow");
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private Interval interval37;
    private Interval interval33;

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
        return new TestSuite(TestInterval_Basics.class);
    }

    public TestInterval_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(PARIS);
        TimeZone.setDefault(PARIS.toTimeZone());
        Locale.setDefault(Locale.FRANCE);
        interval37 = new Interval(3, 7);
        interval33 = new Interval(3, 3);
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
public void testOverlap_RInterval_null125() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(new Interval(2, 3), interval37.overlap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(null, interval37.overlap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(null, interval37.overlap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(null, interval37.overlap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(null, interval37.overlap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(new Interval(7, 8), interval37.overlap((ReadableInterval) null)); 
 }
public void testWithChronology2126() { 
     Interval base = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withChronology(null); 
     assertEquals(new Interval(TEST_TIME1, TEST_TIME2, ISOChronology.getInstance()), test); 
 }
public void testWithChronology2127() { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withChronology(null); 
     assertEquals(new Interval(TEST_TIME_NOW, TEST_TIME_NOW, ISOChronology.getInstance()), test); 
 }
public void testWithChronology2128() { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withChronology(null); 
     assertSame(base, test); 
 }
public void testWithEndMillis_long3129() { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withEndMillis(TEST_TIME2); 
     assertSame(base, test); 
 }
public void testWithEndMillis_long3130() { 
     Interval base = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withEndMillis(TEST_TIME2); 
     assertSame(base, test); 
 }
public void testWithEndInstant_RI3131() { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withEnd(null); 
     assertEquals(new Interval(TEST_TIME_NOW, TEST_TIME_NOW, COPTIC_PARIS), test); 
 }
public void testContains_RInterval_null493() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(false, interval37.contains((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(true, interval37.contains((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(true, interval37.contains((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(true, interval37.contains((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(false, interval37.contains((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(false, interval37.contains((ReadableInterval) null)); 
 }
public void testContains_RInterval495() { 
     MutableInterval test = new MutableInterval(TEST_TIME1, TEST_TIME2); 
     assertEquals(false, test.contains(new Interval(TEST_TIME1, TEST_TIME1))); 
     assertEquals(false, test.contains(new Interval(TEST_TIME1 - 1, TEST_TIME1))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1, TEST_TIME1 + 1))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1 - 1, TEST_TIME1 + 1))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1 + 1, TEST_TIME1 + 1))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1, TEST_TIME2))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1 - 1, TEST_TIME2))); 
     assertEquals(true, test.contains(new Interval(TEST_TIME1 + (TEST_TIME2 - TEST_TIME1) / 2, TEST_TIME2))); 
     assertEquals(false, test.contains((ReadableInterval) null)); 
 }
public void testConstructor_RD_RI_PeriodType1498() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime dt2 = new DateTime(2005, 7, 10, 1, 1, 1, 1); 
     Duration dur = new Interval(dt1, dt2).toDuration(); 
     Period test = new Period(dur, dt2, PeriodType.yearDayTime()); 
     assertEquals(PeriodType.yearDayTime(), test.getPeriodType()); 
     assertEquals(1, test.getYears()); 
     assertEquals(0, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(31, test.getDays()); 
     assertEquals(1, test.getHours()); 
     assertEquals(1, test.getMinutes()); 
     assertEquals(1, test.getSeconds()); 
     assertEquals(1, test.getMillis()); 
 }
    

    //-----------------------------------------------------------------------
    

    

    

    

    class MockInterval extends AbstractInterval {
        public MockInterval() {
            super();
        }
        public Chronology getChronology() {
            return ISOChronology.getInstance();
        }
        public long getStartMillis() {
            return TEST_TIME1;
        }
        public long getEndMillis() {
            return TEST_TIME2;
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
    

    

    

}
