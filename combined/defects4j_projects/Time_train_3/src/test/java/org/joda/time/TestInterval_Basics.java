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

public void testToPeriod68() { 
     DateTime dt1 = new DateTime(2004, 6, 9, 7, 8, 9, 10, COPTIC_PARIS); 
     DateTime dt2 = new DateTime(2005, 8, 13, 12, 14, 16, 18, COPTIC_PARIS); 
     Interval base = new Interval(dt1, dt2); 
     Period test = base.toPeriod(); 
     Period expected = new Period(dt1, dt2, PeriodType.standard()); 
     assertEquals(expected, test); 
 } 


public void testToPeriod_PeriodType171() { 
     DateTime dt1 = new DateTime(2004, 6, 9, 7, 8, 9, 10, COPTIC_PARIS); 
     DateTime dt2 = new DateTime(2005, 8, 13, 12, 14, 16, 18, COPTIC_PARIS); 
     Interval base = new Interval(dt1, dt2); 
     Period test = base.toPeriod(null); 
     Period expected = new Period(dt1, dt2, PeriodType.standard()); 
     assertEquals(expected, test); 
 } 


public void testWithPeriodBeforeEnd1332() throws Throwable { 
     DateTime dt = new DateTime(TEST_TIME_NOW, COPTIC_PARIS); 
     Period dur = new Period(0, 6, 0, 0, 1, 0, 0, 0); 
     Interval base = new Interval(dt, dt); 
     Interval test = base.withPeriodBeforeEnd(dur); 
     assertEquals(new Interval(dur, dt), test); 
 } 


public void testToInterval1338() { 
     Interval test = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval result = test.toInterval(); 
     assertSame(test, result); 
 } 


public void testGap_RInterval_zone339() { 
     Interval testA = new Interval(new DateTime(3, LONDON), new DateTime(7, LONDON)); 
     assertEquals(ISOChronology.getInstance(LONDON), testA.getChronology()); 
     Interval testB = new Interval(new DateTime(1, MOSCOW), new DateTime(2, MOSCOW)); 
     assertEquals(ISOChronology.getInstance(MOSCOW), testB.getChronology()); 
     Interval resultAB = testA.gap(testB); 
     assertEquals(ISOChronology.getInstance(LONDON), resultAB.getChronology()); 
     Interval resultBA = testB.gap(testA); 
     assertEquals(ISOChronology.getInstance(MOSCOW), resultBA.getChronology()); 
 } 


public void testGap_RInterval_null340() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(new Interval(2, 3), interval37.gap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(null, interval37.gap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(null, interval37.gap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(null, interval37.gap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(null, interval37.gap((ReadableInterval) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(new Interval(7, 8), interval37.gap((ReadableInterval) null)); 
 } 


public void testAbuts_RInterval341() { 
     assertEquals(false, interval37.abuts(new Interval(1, 2))); 
     assertEquals(false, interval37.abuts(new Interval(2, 2))); 
     assertEquals(true, interval37.abuts(new Interval(2, 3))); 
     assertEquals(true, interval37.abuts(new Interval(3, 3))); 
     assertEquals(false, interval37.abuts(new Interval(2, 4))); 
     assertEquals(false, interval37.abuts(new Interval(3, 4))); 
     assertEquals(false, interval37.abuts(new Interval(4, 4))); 
     assertEquals(false, interval37.abuts(new Interval(2, 6))); 
     assertEquals(false, interval37.abuts(new Interval(3, 6))); 
     assertEquals(false, interval37.abuts(new Interval(4, 6))); 
     assertEquals(false, interval37.abuts(new Interval(5, 6))); 
     assertEquals(false, interval37.abuts(new Interval(6, 6))); 
     assertEquals(false, interval37.abuts(new Interval(2, 7))); 
     assertEquals(false, interval37.abuts(new Interval(3, 7))); 
     assertEquals(false, interval37.abuts(new Interval(4, 7))); 
     assertEquals(false, interval37.abuts(new Interval(5, 7))); 
     assertEquals(false, interval37.abuts(new Interval(6, 7))); 
     assertEquals(true, interval37.abuts(new Interval(7, 7))); 
     assertEquals(false, interval37.abuts(new Interval(2, 8))); 
     assertEquals(false, interval37.abuts(new Interval(3, 8))); 
     assertEquals(false, interval37.abuts(new Interval(4, 8))); 
     assertEquals(false, interval37.abuts(new Interval(5, 8))); 
     assertEquals(false, interval37.abuts(new Interval(6, 8))); 
     assertEquals(true, interval37.abuts(new Interval(7, 8))); 
     assertEquals(false, interval37.abuts(new Interval(8, 8))); 
     assertEquals(false, interval37.abuts(new Interval(8, 9))); 
     assertEquals(false, interval37.abuts(new Interval(9, 9))); 
 } 


public void testAbuts_RInterval_null342() { 
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


public void testWithChronology2343() { 
     Interval base = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withChronology(null); 
     assertEquals(new Interval(TEST_TIME1, TEST_TIME2, ISOChronology.getInstance()), test); 
 } 


public void testWithStartMillis_long2344() { 
     Interval test = new Interval(TEST_TIME1, TEST_TIME2); 
     try { 
         test.withStartMillis(TEST_TIME2 + 1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithStartMillis_long3345() { 
     Interval base = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withStartMillis(TEST_TIME1); 
     assertSame(base, test); 
 } 


public void testWithStartInstant_RI2346() { 
     Interval test = new Interval(TEST_TIME1, TEST_TIME2); 
     try { 
         test.withStart(new Instant(TEST_TIME2 + 1)); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithEndMillis_long3347() { 
     Interval base = new Interval(TEST_TIME1, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withEndMillis(TEST_TIME2); 
     assertSame(base, test); 
 } 


public void testWithDurationAfterStart2348() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withDurationAfterStart(null); 
     assertEquals(new Interval(TEST_TIME_NOW, TEST_TIME_NOW, COPTIC_PARIS), test); 
 } 


public void testWithDurationAfterStart4349() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withDurationAfterStart(base.toDuration()); 
     assertSame(base, test); 
 } 


public void testWithDurationBeforeEnd1350() throws Throwable { 
     Duration dur = new Duration(TEST_TIME_NOW - TEST_TIME1); 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME_NOW, COPTIC_PARIS); 
     Interval test = base.withDurationBeforeEnd(dur); 
     assertEquals(new Interval(TEST_TIME1, TEST_TIME_NOW, COPTIC_PARIS), test); 
 } 


public void testWithDurationBeforeEnd4351() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withDurationBeforeEnd(base.toDuration()); 
     assertSame(base, test); 
 } 


public void testWithPeriodAfterStart1352() throws Throwable { 
     DateTime dt = new DateTime(TEST_TIME_NOW, COPTIC_PARIS); 
     Period dur = new Period(0, 6, 0, 0, 1, 0, 0, 0); 
     Interval base = new Interval(dt, dt); 
     Interval test = base.withPeriodAfterStart(dur); 
     assertEquals(new Interval(dt, dur), test); 
 } 


public void testWithPeriodAfterStart2353() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withPeriodAfterStart(null); 
     assertEquals(new Interval(TEST_TIME_NOW, TEST_TIME_NOW, COPTIC_PARIS), test); 
 } 


public void testWithPeriodBeforeEnd2354() throws Throwable { 
     Interval base = new Interval(TEST_TIME_NOW, TEST_TIME2, COPTIC_PARIS); 
     Interval test = base.withPeriodBeforeEnd(null); 
     assertEquals(new Interval(TEST_TIME2, TEST_TIME2, COPTIC_PARIS), test); 
 } 


public void testContains_RI_null1153() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(false, interval37.contains((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(true, interval37.contains((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(true, interval37.contains((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(true, interval37.contains((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(false, interval37.contains((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(false, interval37.contains((ReadableInstant) null)); 
 } 


public void testContains_RI_zeroDuration1154() { 
     assertEquals(false, interval33.contains(new Instant(2))); 
     assertEquals(false, interval33.contains(new Instant(3))); 
     assertEquals(false, interval33.contains(new Instant(4))); 
 } 


public void testIsEqual_RI1156() { 
     assertEquals(false, interval37.isEqual(interval33)); 
     assertEquals(true, interval37.isEqual(interval37)); 
 } 


public void testIsBefore_RI_null1157() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(false, interval37.isBefore((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(false, interval37.isBefore((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(false, interval37.isBefore((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(false, interval37.isBefore((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(true, interval37.isBefore((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(true, interval37.isBefore((ReadableInstant) null)); 
 } 


public void testIsBefore_RInterval_null1159() { 
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


public void testIsAfterNow1161() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(true, interval37.isAfterNow()); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(false, interval37.isAfterNow()); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(false, interval37.isAfterNow()); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(false, interval37.isAfterNow()); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(false, interval37.isAfterNow()); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(false, interval37.isAfterNow()); 
 } 


public void testIsAfter_RI1162() { 
     assertEquals(true, interval37.isAfter(new Instant(2))); 
     assertEquals(false, interval37.isAfter(new Instant(3))); 
     assertEquals(false, interval37.isAfter(new Instant(4))); 
     assertEquals(false, interval37.isAfter(new Instant(5))); 
     assertEquals(false, interval37.isAfter(new Instant(6))); 
     assertEquals(false, interval37.isAfter(new Instant(7))); 
     assertEquals(false, interval37.isAfter(new Instant(8))); 
 } 


public void testIsAfter_RI_null1163() { 
     DateTimeUtils.setCurrentMillisFixed(2); 
     assertEquals(true, interval37.isAfter((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(3); 
     assertEquals(false, interval37.isAfter((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(4); 
     assertEquals(false, interval37.isAfter((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(6); 
     assertEquals(false, interval37.isAfter((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(7); 
     assertEquals(false, interval37.isAfter((ReadableInstant) null)); 
     DateTimeUtils.setCurrentMillisFixed(8); 
     assertEquals(false, interval37.isAfter((ReadableInstant) null)); 
 } 


public void testEqualsHashCodeStrict1167() { 
     Interval test1 = new Interval(new DateTime(TEST_TIME1, LenientChronology.getInstance(COPTIC_PARIS)), new DateTime(TEST_TIME2, LenientChronology.getInstance(COPTIC_PARIS))); 
     Interval test2 = new Interval(new DateTime(TEST_TIME1, LenientChronology.getInstance(COPTIC_PARIS)), new DateTime(TEST_TIME2, LenientChronology.getInstance(COPTIC_PARIS))); 
     assertEquals(true, test1.equals(test2)); 
     assertEquals(true, test2.equals(test1)); 
     assertEquals(true, test1.equals(test1)); 
     assertEquals(true, test2.equals(test2)); 
     assertEquals(true, test1.hashCode() == test2.hashCode()); 
     assertEquals(true, test1.hashCode() == test1.hashCode()); 
     assertEquals(true, test2.hashCode() == test2.hashCode()); 
 } 


public void testToString1168() { 
     DateTime dt1 = new DateTime(2004, 6, 9, 7, 8, 9, 10, DateTimeZone.UTC); 
     DateTime dt2 = new DateTime(2005, 8, 13, 12, 14, 16, 18, DateTimeZone.UTC); 
     Interval test = new Interval(dt1, dt2); 
     assertEquals("2004-06-09T07:08:09.010Z/2005-08-13T12:14:16.018Z", test.toString()); 
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
