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
package org.joda.time.chrono;

import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.Instant;
import org.joda.time.Period;
import org.joda.time.TimeOfDay;
import org.joda.time.YearMonthDay;

/**
 * This class is a Junit unit test for GJChronology.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestGJChronology extends TestCase {

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
        return new TestSuite(TestGJChronology.class);
    }

    public TestGJChronology(String name) {
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

public void testCutoverAddWeeks116() { 
     testAdd("1582-01-01", DurationFieldType.weeks(), 1, "1582-01-08"); 
     testAdd("1583-01-01", DurationFieldType.weeks(), 1, "1583-01-08"); 
     testAdd("1582-10-01", DurationFieldType.weeks(), 2, "1582-10-25"); 
     testAdd("1582-W01-1", DurationFieldType.weeks(), 51, "1583-W01-1"); 
 } 


public void testEquality117() { 
     assertSame(GJChronology.getInstance(TOKYO), GJChronology.getInstance(TOKYO)); 
     assertSame(GJChronology.getInstance(LONDON), GJChronology.getInstance(LONDON)); 
     assertSame(GJChronology.getInstance(PARIS), GJChronology.getInstance(PARIS)); 
     assertSame(GJChronology.getInstanceUTC(), GJChronology.getInstanceUTC()); 
     assertSame(GJChronology.getInstance(), GJChronology.getInstance(LONDON)); 
 } 


public void testSubtractDays118() { 
     DateTime dt = new DateTime(1112306400000L, GJChronology.getInstance(DateTimeZone.forID("Europe/Berlin"))); 
     YearMonthDay ymd = dt.toYearMonthDay(); 
     while (ymd.toDateTimeAtMidnight().getDayOfWeek() != DateTimeConstants.MONDAY) { 
         ymd = ymd.minus(Period.days(1)); 
     } 
 } 


public void testLeapYearRulesConstructionInvalid123() { 
     try { 
         new DateMidnight(1500, 2, 30, GJChronology.getInstanceUTC()); 
         fail(); 
     } catch (IllegalFieldValueException ex) { 
     } 
 } 


public void testLeapYearRulesConstruction124() { 
     DateMidnight dt = new DateMidnight(1500, 2, 29, GJChronology.getInstanceUTC()); 
     assertEquals(dt.getYear(), 1500); 
     assertEquals(dt.getMonthOfYear(), 2); 
     assertEquals(dt.getDayOfMonth(), 29); 
 } 


public void testToString125() { 
     assertEquals("GJChronology[Europe/London]", GJChronology.getInstance(LONDON).toString()); 
     assertEquals("GJChronology[Asia/Tokyo]", GJChronology.getInstance(TOKYO).toString()); 
     assertEquals("GJChronology[Europe/London]", GJChronology.getInstance().toString()); 
     assertEquals("GJChronology[UTC]", GJChronology.getInstanceUTC().toString()); 
     assertEquals("GJChronology[UTC,cutover=1970-01-01]", GJChronology.getInstance(DateTimeZone.UTC, 0L, 4).toString()); 
     assertEquals("GJChronology[UTC,cutover=1970-01-01T00:00:00.001Z,mdfw=2]", GJChronology.getInstance(DateTimeZone.UTC, 1L, 2).toString()); 
 } 


public void testCutoverAddWeekyears127() { 
     testAdd("1582-W01-1", DurationFieldType.weekyears(), 1, "1583-W01-1"); 
     testAdd("1582-W39-1", DurationFieldType.weekyears(), 1, "1583-W39-1"); 
     testAdd("1583-W45-1", DurationFieldType.weekyears(), 1, "1584-W45-1"); 
     testAdd("1580-W01-1", DurationFieldType.weekyears(), 4, "1584-W01-1"); 
     testAdd("1580-W30-7", DurationFieldType.weekyears(), 4, "1584-W30-7"); 
     testAdd("1580-W50-7", DurationFieldType.weekyears(), 4, "1584-W50-7"); 
 } 


public void testPartialGetAsText128() { 
     GJChronology chrono = GJChronology.getInstance(TOKYO); 
     assertEquals("January", new YearMonthDay("2005-01-01", chrono).monthOfYear().getAsText()); 
     assertEquals("Jan", new YearMonthDay("2005-01-01", chrono).monthOfYear().getAsShortText()); 
 } 


public void testMaximumValue131() { 
     DateMidnight dt = new DateMidnight(1570, 1, 1, GJChronology.getInstance()); 
     while (dt.getYear() < 1590) { 
         dt = dt.plusDays(1); 
         YearMonthDay ymd = dt.toYearMonthDay(); 
         assertEquals(dt.year().getMaximumValue(), ymd.year().getMaximumValue()); 
         assertEquals(dt.monthOfYear().getMaximumValue(), ymd.monthOfYear().getMaximumValue()); 
         assertEquals(dt.dayOfMonth().getMaximumValue(), ymd.dayOfMonth().getMaximumValue()); 
     } 
 } 


public void testCutoverAddYears132() { 
     testAdd("1582-01-01", DurationFieldType.years(), 1, "1583-01-01"); 
     testAdd("1582-02-15", DurationFieldType.years(), 1, "1583-02-15"); 
     testAdd("1582-02-28", DurationFieldType.years(), 1, "1583-02-28"); 
     testAdd("1582-03-01", DurationFieldType.years(), 1, "1583-03-01"); 
     testAdd("1582-09-30", DurationFieldType.years(), 1, "1583-09-30"); 
     testAdd("1582-10-01", DurationFieldType.years(), 1, "1583-10-01"); 
     testAdd("1582-10-04", DurationFieldType.years(), 1, "1583-10-04"); 
     testAdd("1582-10-15", DurationFieldType.years(), 1, "1583-10-15"); 
     testAdd("1582-10-16", DurationFieldType.years(), 1, "1583-10-16"); 
     testAdd("1580-01-01", DurationFieldType.years(), 4, "1584-01-01"); 
     testAdd("1580-02-29", DurationFieldType.years(), 4, "1584-02-29"); 
     testAdd("1580-10-01", DurationFieldType.years(), 4, "1584-10-01"); 
     testAdd("1580-10-10", DurationFieldType.years(), 4, "1584-10-10"); 
     testAdd("1580-10-15", DurationFieldType.years(), 4, "1584-10-15"); 
     testAdd("1580-12-31", DurationFieldType.years(), 4, "1584-12-31"); 
 } 


public void testCutoverAddMonths136() { 
     testAdd("1582-01-01", DurationFieldType.months(), 1, "1582-02-01"); 
     testAdd("1582-01-01", DurationFieldType.months(), 6, "1582-07-01"); 
     testAdd("1582-01-01", DurationFieldType.months(), 12, "1583-01-01"); 
     testAdd("1582-11-15", DurationFieldType.months(), 1, "1582-12-15"); 
     testAdd("1582-09-04", DurationFieldType.months(), 2, "1582-11-04"); 
     testAdd("1582-09-05", DurationFieldType.months(), 2, "1582-11-05"); 
     testAdd("1582-09-10", DurationFieldType.months(), 2, "1582-11-10"); 
     testAdd("1582-09-15", DurationFieldType.months(), 2, "1582-11-15"); 
     testAdd("1580-01-01", DurationFieldType.months(), 48, "1584-01-01"); 
     testAdd("1580-02-29", DurationFieldType.months(), 48, "1584-02-29"); 
     testAdd("1580-10-01", DurationFieldType.months(), 48, "1584-10-01"); 
     testAdd("1580-10-10", DurationFieldType.months(), 48, "1584-10-10"); 
     testAdd("1580-10-15", DurationFieldType.months(), 48, "1584-10-15"); 
     testAdd("1580-12-31", DurationFieldType.months(), 48, "1584-12-31"); 
 } 

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    private void testParse(String str,
                           int year, int month, int day,
                           int hour, int minute, int second, int millis) {
        assertEquals(new DateTime(str, GJChronology.getInstance(DateTimeZone.UTC)),
                     new DateTime(year, month, day, hour, minute, second, millis,
                                  GJChronology.getInstance(DateTimeZone.UTC)));
    }

    

    

    

    

    

    

    

    private void testAdd(String start, DurationFieldType type, int amt, String end) {
        DateTime dtStart = new DateTime(start, GJChronology.getInstance(DateTimeZone.UTC));
        DateTime dtEnd = new DateTime(end, GJChronology.getInstance(DateTimeZone.UTC));
        assertEquals(dtEnd, dtStart.withFieldAdded(type, amt));
        assertEquals(dtStart, dtEnd.withFieldAdded(type, -amt));

        DurationField field = type.getField(GJChronology.getInstance(DateTimeZone.UTC));
        int diff = field.getDifference(dtEnd.getMillis(), dtStart.getMillis());
        assertEquals(amt, diff);
        
        if (type == DurationFieldType.years() ||
            type == DurationFieldType.months() ||
            type == DurationFieldType.days()) {
            YearMonthDay ymdStart = new YearMonthDay(start, GJChronology.getInstance(DateTimeZone.UTC));
            YearMonthDay ymdEnd = new YearMonthDay(end, GJChronology.getInstance(DateTimeZone.UTC));
            assertEquals(ymdEnd, ymdStart.withFieldAdded(type, amt));
            assertEquals(ymdStart, ymdEnd.withFieldAdded(type, -amt));
        }
    }

    

    

    

    

    

}
