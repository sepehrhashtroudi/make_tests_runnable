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
public void testToStandardDays80() { 
     Duration test = new Duration(0L); 
     assertEquals(Days.days(0), test.toStandardDays()); 
     test = new Duration(1L); 
     assertEquals(Days.days(0), test.toStandardDays()); 
     test = new Duration(3600000L - 1); 
     assertEquals(Days.days(0), test.toStandardDays()); 
     test = new Duration(3600000L); 
     assertEquals(Days.days(1), test.toStandardDays()); 
     test = new Duration(3600000L + 1); 
     assertEquals(Days.days(1), test.toStandardDays()); 
     test = new Duration(2 * 3600000L - 1); 
     assertEquals(Days.days(1), test.toStandardDays()); 
     test = new Duration(2 * 3600000L); 
     assertEquals(Days.days(2), test.toStandardDays()); 
     test = new Duration(-1L); 
     assertEquals(Days.days(0), test.toStandardDays()); 
     test = new Duration(-3600000L + 1); 
     assertEquals(Days.days(0), test.toStandardDays()); 
     test = new Duration(-3600000L); 
     assertEquals(Days.days(-1), test.toStandardDays()); 
 }
public void testWithMillis_long181() { 
     Duration test = new Duration(123L); 
     Duration result = test.withMillis(8000L); 
     assertEquals(123L, result.getMillis()); 
 }
public void testWithMillis_long182() { 
     Duration test = new Duration(123L); 
     Duration result = test.withMillis(8000L); 
     assertEquals(8123L, result.getMillis()); 
 }
public void testWithMillis_long283() { 
     Duration test = new Duration(123L); 
     Duration result = test.withMillis(123L); 
     assertSame(test, result); 
 }
public void testWithMillis_long284() { 
     Duration test = new Duration(123L); 
     Duration result = test.withMillis(0L); 
     assertSame(test, result); 
 }
public void testWithDurationAdded_RD_int385() { 
     Duration test = new Duration(123L); 
     Duration result = test.withDurationAdded(new Duration(8000L), -1); 
     assertEquals((123L - 8000L), result.getMillis()); 
 }
public void testMinus_RD186() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(new Duration(8000L)); 
     assertEquals(123L - 8000L, result.getMillis()); 
 }
public void testMinus_RD387() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(null); 
     assertSame(test, result); 
 }
public void testToPeriodTo279() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Period result = test.toPeriodTo(dt); 
     assertEquals(new Period(test, dt), result); 
 }
public void testToIntervalTo280() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Interval result = test.toIntervalTo(dt); 
     assertEquals(new Interval(test, dt), result); 
 }
@SuppressWarnings("deprecation") 
 public void testFactoryFieldDifference1318() throws Throwable { 
     YearMonthDay start = new YearMonthDay(2005, 4, 9); 
     DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() }; 
     Partial end = new Partial(types, new int[] { 2004, 6, 7 }); 
     Period test = Period.fieldDifference(start, end); 
     assertEquals(PeriodType.yearMonthDay(), test.getPeriodType()); 
     assertEquals(-1, test.getYears()); 
     assertEquals(2, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(-2, test.getDays()); 
     assertEquals(0, test.getHours()); 
     assertEquals(0, test.getMinutes()); 
     assertEquals(0, test.getSeconds()); 
     assertEquals(0, test.getMillis()); 
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
