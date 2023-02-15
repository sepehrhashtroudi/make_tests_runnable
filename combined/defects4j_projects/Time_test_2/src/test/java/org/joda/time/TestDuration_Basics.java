/*
 *  Copyright 2001-2009 Stephen Colebourne
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

import org.joda.time.base.AbstractDuration;
import org.joda.time.base.BaseDuration;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for Duration.
 *
 * @author Stephen Colebourne
 */
public class TestDuration_Basics extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

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
        return new TestSuite(TestDuration_Basics.class);
    }

    public TestDuration_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
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
public void testConstructor_RI_RD245() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Duration dur = null; 
     Period test = new Period(dt1, dur, PeriodType.dayTime()); 
     assertEquals(PeriodType.dayTime(), test.getPeriodType()); 
     assertEquals(0, test.getYears()); 
     assertEquals(0, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(0, test.getDays()); 
     assertEquals(0, test.getHours()); 
     assertEquals(0, test.getMinutes()); 
     assertEquals(0, test.getSeconds()); 
     assertEquals(0, test.getMillis()); 
 }
public void testToDuration117() { 
     Duration test = new Duration(123L); 
     Duration result = test.toDuration(); 
     assertSame(test, result); 
 }
public void testMinus_long1118() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(8000L); 
     assertEquals(123L - 8000L, result.getMillis()); 
 }
public void testPlus_RD3119() { 
     Duration test = new Duration(123L); 
     Duration result = test.plus(null); 
     assertSame(test, result); 
 }
public void testMultipliedBy_long2120() { 
     Duration test = new Duration(123L); 
     Duration result = test.multipliedBy(1L); 
     assertSame(test, result); 
 }
public void testToPeriod_Chronology277() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(ISOChronology.getInstanceUTC()); 
     assertEquals(new Period(test, ISOChronology.getInstanceUTC()), result); 
 }
public void testToPeriod_PeriodType278() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(PeriodType.standard().withMillisRemoved()); 
     assertEquals(new Period(test, PeriodType.standard().withMillisRemoved(), ISOChronology.getInstanceUTC()), result); 
 }
public void testToPeriodFrom280() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Period result = test.toPeriodFrom(dt, PeriodType.standard().withMillisRemoved()); 
     assertEquals(new Period(dt, test, PeriodType.standard().withMillisRemoved()), result); 
 }
public void testToDuration600() { 
     DateTimeZone zone = DateTimeZone.getDefault(); 
     try { 
         DateTimeZone.setDefault(DateTimeZone.forID("Europe/Paris")); 
         long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
         Duration test = new Duration(length); 
         Duration result = test.toDuration(); 
         assertEquals(length, result.getMillis()); 
     } finally { 
         DateTimeZone.setDefault(zone); 
     } 
 }
public void testToDuration601() { 
     DateTimeZone zone = DateTimeZone.getDefault(); 
     try { 
         DateTimeZone.setDefault(DateTimeZone.forID("Europe/Paris")); 
         long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
         Duration dur = new Duration(length); 
         Period test = dur.toPeriod(); 
         assertEquals(0, test.getYears()); 
         assertEquals(0, test.getMonths()); 
         assertEquals(0, test.getWeeks()); 
         assertEquals(0, test.getDays()); 
         assertEquals((450 * 24) + 5, test.getHours()); 
         assertEquals(6, test.getMinutes()); 
         assertEquals(7, test.getSeconds()); 
         assertEquals(8, test.getMillis()); 
     } finally { 
         DateTimeZone.setDefault(zone); 
     } 
 }
public void testToString602() { 
     Duration test = new Duration(123L); 
     assertEquals("PT12.6S", test.toString()); 
     test = new Duration(12345L); 
     assertEquals("PT12.345S", test.toString()); 
     test = new Duration(60000L - 1); 
     assertEquals("PT-6S", test.toString()); 
     test = new Duration(60000L); 
     assertEquals("PT-6S", test.toString()); 
     test = new Duration(60000L + 1); 
     assertEquals("PT-6S", test.toString()); 
     test = new Duration(2 * 60000L - 1); 
     assertEquals("PT-2S", test.toString()); 
     test = new Duration(2 * 60000L); 
     assertEquals("PT-6S", test.toString()); 
     test = new Duration(-1L); 
     assertEquals("PT-0S", test.toString()); 
 }
public void testToString603() { 
     Duration test = new Duration(123L); 
     assertEquals("PT123L", test.toString()); 
     test = new Duration(0L); 
     assertEquals("PT0S", test.toString()); 
     test = new Duration(1L); 
     assertEquals("PT1M", test.toString()); 
     test = new Duration(3600000L - 1); 
     assertEquals("PT3600000S", test.toString()); 
     test = new Duration(3600000L); 
     assertEquals("PT3600000S", test.toString()); 
     test = new Duration(3600000L + 1); 
     assertEquals("PT3600000S", test.toString()); 
     test = new Duration(2 * 3600000L - 1); 
     assertEquals("PT2S", test.toString()); 
     test = new Duration(2 * 3600000L); 
     assertEquals("PT3S", test.toString()); 
     test = new Duration(-1L); 
     assertEquals("PT-0S", test.toString()); 
     test = new Duration(-3600000L + 1); 
     assertEquals("PT-0S", test.toString()); 
 }
public void testToString604() { 
     Duration test = new Duration(123L); 
     assertEquals("PT12.6S", test.toString()); 
     test = new Duration(12345L); 
     assertEquals("PT12.345S", test.toString()); 
     test = new Duration(60000L - 1); 
     assertEquals("PT12.345S", test.toString()); 
     test = new Duration(60000L); 
     assertEquals("PT12.345S", test.toString()); 
     test = new Duration(60000L + 1); 
     assertEquals("PT12.345S", test.toString()); 
     test = new Duration(2 * 60000L - 1); 
     assertEquals("PT2.6S", test.toString()); 
     test = new Duration(2 * 60000L); 
     assertEquals("PT-2.6S", test.toString()); 
     test = new Duration(-1L); 
     assertEquals("PT-1.6S", test.toString()); 
     test = new Duration(-24 * 60 * 60000L + 1); 
     assertEquals("PT-24.6S", test.toString()); 
 }
    

    //-----------------------------------------------------------------------
    

    
    
    class MockDuration extends AbstractDuration {
        private final long iValue;
        public MockDuration(long value) {
            super();
            iValue = value;
        }
        public long getMillis() {
            return iValue;
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
    

    static class MockMutableDuration extends BaseDuration {
        public MockMutableDuration(long duration) {
            super(duration);
        }
        public void setMillis(long duration) {
            super.setMillis(duration);
        }
    }

}
