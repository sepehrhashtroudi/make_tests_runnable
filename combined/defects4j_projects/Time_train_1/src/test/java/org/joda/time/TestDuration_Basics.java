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

public void testToPeriodFrom_PeriodType80() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Period result = test.toPeriodFrom(dt, PeriodType.standard().withMillisRemoved()); 
     assertEquals(new Period(dt, test, PeriodType.standard().withMillisRemoved()), result); 
 } 


public void testToPeriod_Chronology84() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(ISOChronology.getInstanceUTC()); 
     assertEquals(new Period(test, ISOChronology.getInstanceUTC()), result); 
     assertEquals(new Period(test.getMillis(), ISOChronology.getInstanceUTC()), result); 
 } 


public void testToPeriod_PeriodType_Chronology85() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(PeriodType.standard().withMillisRemoved(), ISOChronology.getInstanceUTC()); 
     assertEquals(new Period(test, PeriodType.standard().withMillisRemoved(), ISOChronology.getInstanceUTC()), result); 
     assertEquals(new Period(test.getMillis(), PeriodType.standard().withMillisRemoved(), ISOChronology.getInstanceUTC()), result); 
 } 


public void testToStandardHours233() { 
     Duration test = new Duration(0L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(1L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(3600000L - 1); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(3600000L); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(3600000L + 1); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(2 * 3600000L - 1); 
     assertEquals(Hours.hours(1), test.toStandardHours()); 
     test = new Duration(2 * 3600000L); 
     assertEquals(Hours.hours(2), test.toStandardHours()); 
     test = new Duration(-1L); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(-3600000L + 1); 
     assertEquals(Hours.hours(0), test.toStandardHours()); 
     test = new Duration(-3600000L); 
     assertEquals(Hours.hours(-1), test.toStandardHours()); 
 } 


public void testToStandardMinutes235() { 
     Duration test = new Duration(0L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(60000L - 1); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(60000L); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(60000L + 1); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(2 * 60000L - 1); 
     assertEquals(Minutes.minutes(1), test.toStandardMinutes()); 
     test = new Duration(2 * 60000L); 
     assertEquals(Minutes.minutes(2), test.toStandardMinutes()); 
     test = new Duration(-1L); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-60000L + 1); 
     assertEquals(Minutes.minutes(0), test.toStandardMinutes()); 
     test = new Duration(-60000L); 
     assertEquals(Minutes.minutes(-1), test.toStandardMinutes()); 
 } 


public void testToStandardSeconds236() { 
     Duration test = new Duration(0L); 
     assertEquals(Seconds.seconds(0), test.toStandardSeconds()); 
     test = new Duration(1L); 
     assertEquals(Seconds.seconds(0), test.toStandardSeconds()); 
     test = new Duration(999L); 
     assertEquals(Seconds.seconds(0), test.toStandardSeconds()); 
     test = new Duration(1000L); 
     assertEquals(Seconds.seconds(1), test.toStandardSeconds()); 
     test = new Duration(1001L); 
     assertEquals(Seconds.seconds(1), test.toStandardSeconds()); 
     test = new Duration(1999L); 
     assertEquals(Seconds.seconds(1), test.toStandardSeconds()); 
     test = new Duration(2000L); 
     assertEquals(Seconds.seconds(2), test.toStandardSeconds()); 
     test = new Duration(-1L); 
     assertEquals(Seconds.seconds(0), test.toStandardSeconds()); 
     test = new Duration(-999L); 
     assertEquals(Seconds.seconds(0), test.toStandardSeconds()); 
     test = new Duration(-1000L); 
     assertEquals(Seconds.seconds(-1), test.toStandardSeconds()); 
 } 


public void testToDuration1237() { 
     Duration test = new Duration(123L); 
     Duration result = test.toDuration(); 
     assertSame(test, result); 
 } 


public void testMinus_long1238() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(8000L); 
     assertEquals(123L - 8000L, result.getMillis()); 
 } 


public void testMinus_RD2239() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(new Duration(0L)); 
     assertSame(test, result); 
 } 


public void testWithDurationAdded_RD_int3240() { 
     Duration test = new Duration(123L); 
     Duration result = test.withDurationAdded(new Duration(8000L), -1); 
     assertEquals((123L - 8000L), result.getMillis()); 
 } 


public void testPlus_long1241() { 
     Duration test = new Duration(123L); 
     Duration result = test.plus(8000L); 
     assertEquals(8123L, result.getMillis()); 
 } 


public void testPlus_RD3242() { 
     Duration test = new Duration(123L); 
     Duration result = test.plus(null); 
     assertSame(test, result); 
 } 


public void testPlus_RD1243() { 
     Duration test = new Duration(123L); 
     Duration result = test.plus(new Duration(8000L)); 
     assertEquals(8123L, result.getMillis()); 
 } 


public void testMinus_RD1244() { 
     Duration test = new Duration(123L); 
     Duration result = test.minus(new Duration(8000L)); 
     assertEquals(123L - 8000L, result.getMillis()); 
 } 


public void testMultipliedBy_long1245() { 
     Duration test = new Duration(123L); 
     Duration result = test.multipliedBy(2L); 
     assertEquals(246L, result.getMillis()); 
 } 


public void testMultipliedBy_long2246() { 
     Duration test = new Duration(123L); 
     Duration result = test.multipliedBy(1L); 
     assertSame(test, result); 
 } 


public void testDividedBy_long2247() { 
     Duration test = new Duration(123L); 
     Duration result = test.dividedBy(1L); 
     assertSame(test, result); 
 } 


public void testDividedBy_long1248() { 
     Duration test = new Duration(246L); 
     Duration result = test.dividedBy(2L); 
     assertEquals(123L, result.getMillis()); 
 } 


public void testNegated_long2249() { 
     Duration test = new Duration(-246L); 
     Duration result = test.negated(); 
     assertEquals(246L, result.getMillis()); 
 } 


public void testNegated_long3250() { 
     Duration test = new Duration(Long.MIN_VALUE); 
     try { 
         test.negated(); 
         fail(); 
     } catch (ArithmeticException e) { 
     } 
 } 


public void testToString405() { 
     long length = (365L + 2L * 30L + 3L * 7L + 4L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 845L; 
     Duration test = new Duration(length); 
     assertEquals("PT" + (length / 1000) + "." + (length % 1000) + "S", test.toString()); 
     assertEquals("PT0S", new Duration(0L).toString()); 
     assertEquals("PT10S", new Duration(10000L).toString()); 
     assertEquals("PT1S", new Duration(1000L).toString()); 
     assertEquals("PT12.345S", new Duration(12345L).toString()); 
     assertEquals("PT-12.345S", new Duration(-12345L).toString()); 
     assertEquals("PT-1.123S", new Duration(-1123L).toString()); 
     assertEquals("PT-0.123S", new Duration(-123L).toString()); 
     assertEquals("PT-0.012S", new Duration(-12L).toString()); 
     assertEquals("PT-0.001S", new Duration(-1L).toString()); 
 } 


public void testMutableDuration667() { 
     MockMutableDuration test = new MockMutableDuration(123L); 
     assertEquals(123L, test.getMillis()); 
     test.setMillis(2345L); 
     assertEquals(2345L, test.getMillis()); 
 } 


public void testToPeriod_PeriodType668() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     Period result = test.toPeriod(PeriodType.standard().withMillisRemoved()); 
     assertEquals(new Period(test, PeriodType.standard().withMillisRemoved()), result); 
     assertEquals(new Period(test.getMillis(), PeriodType.standard().withMillisRemoved()), result); 
 } 


public void testToPeriodFrom669() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Period result = test.toPeriodFrom(dt); 
     assertEquals(new Period(dt, test), result); 
 } 


public void testToPeriodTo_PeriodType670() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Period result = test.toPeriodTo(dt, PeriodType.standard().withMillisRemoved()); 
     assertEquals(new Period(test, dt, PeriodType.standard().withMillisRemoved()), result); 
 } 


public void testToIntervalFrom671() { 
     long length = (4L + (3L * 7L) + (2L * 30L) + 365L) * DateTimeConstants.MILLIS_PER_DAY + 5L * DateTimeConstants.MILLIS_PER_HOUR + 6L * DateTimeConstants.MILLIS_PER_MINUTE + 7L * DateTimeConstants.MILLIS_PER_SECOND + 8L; 
     Duration test = new Duration(length); 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Interval result = test.toIntervalFrom(dt); 
     assertEquals(new Interval(dt, test), result); 
 } 


public void testToPeriod767() { 
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


public void testToDuration21389() { 
     MockDuration test = new MockDuration(123L); 
     Duration result = test.toDuration(); 
     assertNotSame(test, result); 
     assertEquals(test, result); 
 } 


public void testCompareTo1390() { 
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


public void testIsEqual1391() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(true, test1.isEqual(test1a)); 
     assertEquals(true, test1a.isEqual(test1)); 
     assertEquals(true, test1.isEqual(test1)); 
     assertEquals(true, test1a.isEqual(test1a)); 
     Duration test2 = new Duration(321L); 
     assertEquals(false, test1.isEqual(test2)); 
     assertEquals(false, test2.isEqual(test1)); 
     assertEquals(false, test2.isEqual(new MockDuration(123L))); 
     assertEquals(true, test1.isEqual(new MockDuration(123L))); 
     assertEquals(false, test1.isEqual(null)); 
     assertEquals(true, new Duration(0L).isEqual(null)); 
 } 


public void testIsAfter1392() { 
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


public void testIsBefore1393() { 
     Duration test1 = new Duration(123L); 
     Duration test1a = new Duration(123L); 
     assertEquals(false, test1.isShorterThan(test1a)); 
     assertEquals(false, test1a.isShorterThan(test1)); 
     assertEquals(false, test1.isShorterThan(test1)); 
     assertEquals(false, test1a.isShorterThan(test1a)); 
     Duration test2 = new Duration(321L); 
     assertEquals(true, test1.isShorterThan(test2)); 
     assertEquals(false, test2.isShorterThan(test1)); 
     assertEquals(false, test2.isShorterThan(new MockDuration(123L))); 
     assertEquals(false, test1.isShorterThan(new MockDuration(123L))); 
     assertEquals(false, test1.isShorterThan(null)); 
     assertEquals(false, new Duration(0L).isShorterThan(null)); 
 } 


public void testSerialization1394() throws Exception { 
     Duration test = new Duration(123L); 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     Duration result = (Duration) ois.readObject(); 
     ois.close(); 
     assertEquals(test, result); 
 } 


public void testEqualsHashCode1395() { 
     Duration test1 = new Duration(123L); 
     Duration test2 = new Duration(123L); 
     assertEquals(true, test1.equals(test2)); 
     assertEquals(true, test2.equals(test1)); 
     assertEquals(true, test1.equals(test1)); 
     assertEquals(true, test2.equals(test2)); 
     assertEquals(true, test1.hashCode() == test2.hashCode()); 
     assertEquals(true, test1.hashCode() == test1.hashCode()); 
     assertEquals(true, test2.hashCode() == test2.hashCode()); 
     Duration test3 = new Duration(321L); 
     assertEquals(false, test1.equals(test3)); 
     assertEquals(false, test2.equals(test3)); 
     assertEquals(false, test3.equals(test1)); 
     assertEquals(false, test3.equals(test2)); 
     assertEquals(false, test1.hashCode() == test3.hashCode()); 
     assertEquals(false, test2.hashCode() == test3.hashCode()); 
     assertEquals(false, test1.equals("Hello")); 
     assertEquals(true, test1.equals(new MockDuration(123L))); 
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
