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
package org.joda.time.format;

import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Partial;

/**
 * This class is a Junit unit test for ISODateTimeFormat.
 *
 * @author Stephen Colebourne
 */
public class TestISODateTimeFormat extends TestCase {

    private static final DateTimeZone UTC = DateTimeZone.UTC;
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");

    long y2002days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365;
    // 2002-06-09
    private long TEST_TIME_NOW =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;

    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestISODateTimeFormat.class);
    }

    public TestISODateTimeFormat(String name) {
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

public void testSubclassableConstructor852() { 
     ISODateTimeFormat f = new ISODateTimeFormat() { 
     }; 
     assertNotNull(f); 
 } 


public void testFormat_date874() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09", ISODateTimeFormat.date().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09", ISODateTimeFormat.date().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09", ISODateTimeFormat.date().print(dt)); 
 } 


public void testFormat_time_partial875() { 
     Partial dt = new Partial(new DateTimeFieldType[] { DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond() }, new int[] { 10, 20, 30, 40 }); 
     assertEquals("10:20:30.040", ISODateTimeFormat.time().print(dt)); 
 } 


public void testFormat_tTimeNoMillis877() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("T10:20:30Z", ISODateTimeFormat.tTimeNoMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("T11:20:30+01:00", ISODateTimeFormat.tTimeNoMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("T12:20:30+02:00", ISODateTimeFormat.tTimeNoMillis().print(dt)); 
 } 


public void testFormat_weekDate882() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekDate().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekDate().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekDate().print(dt)); 
 } 


public void testFormat_basicTTime886() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("T102030.040Z", ISODateTimeFormat.basicTTime().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("T112030.040+0100", ISODateTimeFormat.basicTTime().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("T122030.040+0200", ISODateTimeFormat.basicTTime().print(dt)); 
 } 


public void testFormat_basicDateTimeNoMillis889() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("20040609T102030Z", ISODateTimeFormat.basicDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("20040609T112030+0100", ISODateTimeFormat.basicDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("20040609T122030+0200", ISODateTimeFormat.basicDateTimeNoMillis().print(dt)); 
 } 


public void testFormat_basicOrdinalDateTimeNoMillis891() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004161T102030Z", ISODateTimeFormat.basicOrdinalDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004161T112030+0100", ISODateTimeFormat.basicOrdinalDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004161T122030+0200", ISODateTimeFormat.basicOrdinalDateTimeNoMillis().print(dt)); 
 } 


public void testFormat_basicWeekDateTimeNoMillis893() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004W243T102030Z", ISODateTimeFormat.basicWeekDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004W243T112030+0100", ISODateTimeFormat.basicWeekDateTimeNoMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004W243T122030+0200", ISODateTimeFormat.basicWeekDateTimeNoMillis().print(dt)); 
 } 


public void testFormat_year894() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004", ISODateTimeFormat.year().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004", ISODateTimeFormat.year().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004", ISODateTimeFormat.year().print(dt)); 
 } 


public void testFormat_yearMonth895() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06", ISODateTimeFormat.yearMonth().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06", ISODateTimeFormat.yearMonth().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06", ISODateTimeFormat.yearMonth().print(dt)); 
 } 


public void testFormat_yearMonthDay896() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09", ISODateTimeFormat.yearMonthDay().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09", ISODateTimeFormat.yearMonthDay().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09", ISODateTimeFormat.yearMonthDay().print(dt)); 
 } 


public void testFormat_weekyear897() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004", ISODateTimeFormat.weekyear().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004", ISODateTimeFormat.weekyear().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004", ISODateTimeFormat.weekyear().print(dt)); 
 } 


public void testFormat_weekyearWeek898() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-W24", ISODateTimeFormat.weekyearWeek().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-W24", ISODateTimeFormat.weekyearWeek().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-W24", ISODateTimeFormat.weekyearWeek().print(dt)); 
 } 


public void testFormat_weekyearWeekDay899() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekyearWeekDay().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekyearWeekDay().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-W24-3", ISODateTimeFormat.weekyearWeekDay().print(dt)); 
 } 


public void testFormat_hourMinute900() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("10:20", ISODateTimeFormat.hourMinute().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("11:20", ISODateTimeFormat.hourMinute().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("12:20", ISODateTimeFormat.hourMinute().print(dt)); 
 } 


public void testFormat_hourMinuteSecond901() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("10:20:30", ISODateTimeFormat.hourMinuteSecond().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("11:20:30", ISODateTimeFormat.hourMinuteSecond().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("12:20:30", ISODateTimeFormat.hourMinuteSecond().print(dt)); 
 } 


public void testFormat_hourMinuteSecondMillis902() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("10:20:30.040", ISODateTimeFormat.hourMinuteSecondMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("11:20:30.040", ISODateTimeFormat.hourMinuteSecondMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("12:20:30.040", ISODateTimeFormat.hourMinuteSecondMillis().print(dt)); 
 } 


public void testFormat_hourMinuteSecondFraction903() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("10:20:30.040", ISODateTimeFormat.hourMinuteSecondFraction().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("11:20:30.040", ISODateTimeFormat.hourMinuteSecondFraction().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("12:20:30.040", ISODateTimeFormat.hourMinuteSecondFraction().print(dt)); 
 } 


public void testFormat_dateHourMinute904() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09T10:20", ISODateTimeFormat.dateHourMinute().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09T11:20", ISODateTimeFormat.dateHourMinute().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09T12:20", ISODateTimeFormat.dateHourMinute().print(dt)); 
 } 


public void testFormat_dateHourMinuteSecond905() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09T10:20:30", ISODateTimeFormat.dateHourMinuteSecond().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09T11:20:30", ISODateTimeFormat.dateHourMinuteSecond().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09T12:20:30", ISODateTimeFormat.dateHourMinuteSecond().print(dt)); 
 } 


public void testFormat_dateHourMinuteSecondMillis906() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09T10:20:30.040", ISODateTimeFormat.dateHourMinuteSecondMillis().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09T11:20:30.040", ISODateTimeFormat.dateHourMinuteSecondMillis().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09T12:20:30.040", ISODateTimeFormat.dateHourMinuteSecondMillis().print(dt)); 
 } 


public void testFormat_dateHourMinuteSecondFraction907() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("2004-06-09T10:20:30.040", ISODateTimeFormat.dateHourMinuteSecondFraction().print(dt)); 
     dt = dt.withZone(LONDON); 
     assertEquals("2004-06-09T11:20:30.040", ISODateTimeFormat.dateHourMinuteSecondFraction().print(dt)); 
     dt = dt.withZone(PARIS); 
     assertEquals("2004-06-09T12:20:30.040", ISODateTimeFormat.dateHourMinuteSecondFraction().print(dt)); 
 } 

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

}
