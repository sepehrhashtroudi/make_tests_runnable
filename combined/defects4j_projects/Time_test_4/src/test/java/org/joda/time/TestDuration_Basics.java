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
public void testGetDuration1104() { 
     Duration test = new Duration(123L); 
     assertEquals(123L, test.getMillis()); 
 }
public void testToStandardHours105() { 
     Duration test = new Duration(0L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(1L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(24 * 60 * 60000L - 1); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(24 * 60 * 60000L); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(24 * 60 * 60000L + 1); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(2 * 24 * 60 * 60000L - 1); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(2 * 24 * 60 * 60000L); 
     assertEquals(Hours.hours(2), test.toStandardHours()); 
     test = new Duration(-1L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(-24 * 60 * 60000L + 1); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(-24 * 60 * 60000L); 
     assertEquals(Hours.hours(-1), test.toStandardHours()); 
 }
public void testToStandardMinutes106() { 
     Duration test = new Duration(0L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(999L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(1000L); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(1001L); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(1999L); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(2000L); 
     assertEquals(Minutes.minutes(2), test.toStandardMinutes()); 
     test = new Duration(-1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-999L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-1000L); 
     assertEquals(Minutes.minutes(-1), test.toStandardMinutes()); 
 }
public void testMinus_RD2108() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(new Duration(0L)); 
     assertSame(test, result); 
 }
public void testWithDurationAdded_RD_int5109() { 
     Duration test = new Duration(123L); 
     Duration result = test.withDurationAdded(new Duration(8000L), 0); 
     assertSame(test, result); 
 }
public void testMinus_long1110() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(8000L); 
     assertEquals(123L - 8000L, result.getMillis()); 
 }
public void testToIntervalFrom262() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Interval result = test.toIntervalFrom(dt); 
     assertEquals(new Interval(dt, test), result); 
 }
public void testGetPeriodType293() { 
     Period test = new Period(0L); 
     assertEquals(PeriodType.standard(), test.getPeriodType()); 
 }
public void testForFields1294() throws Exception { 
     PeriodType type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.years() }); 
     assertSame(PeriodType.years(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.months() }); 
     assertSame(PeriodType.months(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.weeks() }); 
     assertSame(PeriodType.weeks(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.days() }); 
     assertSame(PeriodType.days(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.hours() }); 
     assertSame(PeriodType.hours(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.minutes() }); 
     assertSame(PeriodType.minutes(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.seconds() }); 
     assertSame(PeriodType.seconds(), type); 
     type = PeriodType.forFields(new DurationFieldType[] { DurationFieldType.millis() }); 
     assertSame(PeriodType.millis(), type); 
 }
public void testGetPeriodType295() { 
     Minutes test = Minutes.minutes(20); 
     assertEquals(PeriodType.minutes(), test.getPeriodType()); 
 }
public void testToStandardHours419() { 
     Weeks test = Weeks.weeks(2); 
     Hours expected = Hours.hours(2 * 7 * 24); 
     assertEquals(expected, test.toStandardHours()); 
     try { 
         Weeks.MAX_VALUE.toStandardHours(); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testMultipliedBy_int421() { 
     Hours test = Hours.hours(2); 
     assertEquals(6, test.multipliedBy(3).getHours()); 
     assertEquals(2, test.getHours()); 
     assertEquals(-6, test.multipliedBy(-3).getHours()); 
     assertSame(test, test.multipliedBy(1)); 
     Hours halfMax = Hours.hours(Integer.MAX_VALUE / 2 + 1); 
     try { 
         halfMax.multipliedBy(2); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void testToPeriod563() { 
     long length = (365L + 2L * 30L + 3L * 7L + 4L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 845L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(); 
     assertEquals(new Period(test, PeriodType.standard()), result); 
     assertEquals(new Period(test.getMillis(), PeriodType.standard()), result); 
 }
public void testCompareTo564() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(true, test1.compareTo(test1a) < 0); 
     assertEquals(true, test1a.compareTo(test1) > 0); 
     assertEquals(true, test1.compareTo(test1) == 0); 
     assertEquals(true, test1a.compareTo(test1a) < 0); 
     Duration test2 = new Duration(321L); 
     assertEquals(true, test1.compareTo(test2) < 0); 
     assertEquals(true, test2.compareTo(test1) > 0); 
     assertEquals(true, test2.compareTo(test2) == 0); 
     try { 
         test1.compareTo(null); 
         fail(); 
     } catch (NullPointerException ex) { 
     } 
 }
public void testCompareTo565() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(0, test1.compareTo(test1a)); 
     assertEquals(0, test1a.compareTo(test1)); 
     assertEquals(0, test1.compareTo(test1)); 
     assertEquals(0, test1a.compareTo(test1a)); 
     Duration test2 = new Duration(321L); 
     assertEquals(-1, test1.compareTo(test2)); 
     assertEquals(+1, test2.compareTo(test1)); 
     assertEquals(+1, test2.compareTo(new MockDuration(123L))); 
     assertEquals(0, test1.compareTo(new MockDuration(123L))); 
     try { 
         test1.compareTo(null); 
         fail(); 
     } catch (NullPointerException ex) { 
     } 
 }
public void testIsEqual567() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(false, test1.isEqual(test1a)); 
     assertEquals(false, test1a.isEqual(test1)); 
     assertEquals(false, test1.isEqual(test1)); 
     assertEquals(false, test1a.isEqual(test1a)); 
     Duration test2 = new Duration(321L); 
     assertEquals(false, test1.isEqual(test2)); 
     assertEquals(true, test2.isEqual(test1)); 
     assertEquals(true, test2.isEqual(new MockDuration(123L))); 
     assertEquals(false, test1.isEqual(new MockDuration(123L))); 
     assertEquals(true, test1.isEqual(null)); 
     assertEquals(false, new Duration(0L).isEqual(null)); 
 }
public void testIsAfter568() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(false, test1.isLongerThan(test1a)); 
     assertEquals(false, test1a.isLongerThan(test1)); 
     assertEquals(false, test1.isLongerThan(test1)); 
     assertEquals(false, test1a.isLongerThan(test1a)); 
     Duration test2 = new Duration(321L); 
     assertEquals(false, test1.isLongerThan(test2)); 
     assertEquals(true, test2.isLongerThan(test1)); 
     assertEquals(true, test2.isLongerThan(new MockDuration(123L))); 
     assertEquals(false, test1.isLongerThan(new MockDuration(123L))); 
     assertEquals(true, test1.isLongerThan(null)); 
     assertEquals(false, new Duration(0L).isLongerThan(null)); 
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
