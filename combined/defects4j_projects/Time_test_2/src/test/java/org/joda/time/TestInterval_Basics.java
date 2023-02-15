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
public void testConstructor_long_long_Chronology143() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     DateTime dt2 = new DateTime(2005, 7, 10, 1, 1, 1, 1); 
     Period test = new Period(dt1.getMillis(), dt2.getMillis(), ISOChronology.getInstanceUTC()); 
     assertEquals(PeriodType.standard(), test.getPeriodType()); 
     assertEquals(1, test.getYears()); 
     assertEquals(1, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(1, test.getDays()); 
     assertEquals(1, test.getHours()); 
     assertEquals(1, test.getMinutes()); 
     assertEquals(1, test.getSeconds()); 
     assertEquals(1, test.getMillis()); 
 }
public void testConstructor_trickyDifferences_RI_RI_toFeb_exactMonths44() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 12, 28, 0, 0); 
     DateTime dt2 = new DateTime(2005, 2, 28, 0, 0); 
     Period test = new Period(dt1, dt2); 
     assertEquals(PeriodType.standard(), test.getPeriodType()); 
     assertEquals(new Period(0, 2, 0, 0, 0, 0, 0, 0), test); 
 }
public void testGap_RInterval_zone147() { 
     Interval testA = new Interval(new DateTime(3, LONDON), new DateTime(7, LONDON)); 
     assertEquals(ISOChronology.getInstance(LONDON), testA.getChronology()); 
     Interval testB = new Interval(new DateTime(1, MOSCOW), new DateTime(2, MOSCOW)); 
     assertEquals(ISOChronology.getInstance(MOSCOW), testB.getChronology()); 
     Interval resultAB = testA.gap(testB); 
     assertEquals(ISOChronology.getInstance(LONDON), resultAB.getChronology()); 
     Interval resultBA = testB.gap(testA); 
     assertEquals(ISOChronology.getInstance(MOSCOW), resultBA.getChronology()); 
 }
public void testAbuts_RInterval_null148() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(false, interval37.abuts((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(true, interval37.abuts((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(false, interval37.abuts((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(false, interval37.abuts((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(true, interval37.abuts((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(false, interval37.abuts((ReadableInterval) null)); 
 }
public void testWithDurationAfterStart4149() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withDurationAfterStart(base.toDuration()); 
     assertSame(base, test); 
 }
public void testWithDurationBeforeEnd4150() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withDurationBeforeEnd(base.toDuration()); 
     assertSame(base, test); 
 }
public void testWithPeriodAfterStart1151() throws Throwable { 
     DateTime dt = new DateTime(TEST_TIME_NOW, COPTIC_PARIS); 
     Period dur = new Period(0, 6, 0, 0, 1, 0, 0, 0); 
     Interval base = new Interval(dt, dt); 
     Interval test = base.withPeriodAfterStart(dur); 
     assertEquals(new Interval(dt, dur), test); 
 }
public void testIsBefore_RInterval_null484() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(false, interval37.isBefore((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(false, interval37.isBefore((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(false, interval37.isBefore((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(false, interval37.isBefore((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(true, interval37.isBefore((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(true, interval37.isBefore((ReadableInterval) null)); 
 }
public void testAdd_RInterval1489() { 
     MutablePeriod test = new MutablePeriod(100L); 
     test.add(new Interval(100L, 200L)); 
     assertEquals(0, test.getYears()); 
     assertEquals(0, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(0, test.getDays()); 
     assertEquals(0, test.getHours()); 
     assertEquals(0, test.getMinutes()); 
     assertEquals(0, test.getSeconds()); 
     assertEquals(200, test.getMillis()); 
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
