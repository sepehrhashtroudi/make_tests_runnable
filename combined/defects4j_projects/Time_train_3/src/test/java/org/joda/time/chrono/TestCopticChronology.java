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

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.DateTime.Property;

/**
 * This class is a Junit unit test for CopticChronology.
 *
 * @author Stephen Colebourne
 */
public class TestCopticChronology extends TestCase {

    private static final int MILLIS_PER_DAY = DateTimeConstants.MILLIS_PER_DAY;

    private static long SKIP = 1 * MILLIS_PER_DAY;

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology JULIAN_UTC = JulianChronology.getInstanceUTC();
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();

    long y2002days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365;
    // 2002-06-09
    private long TEST_TIME_NOW =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * MILLIS_PER_DAY;

    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        SKIP = 1 * MILLIS_PER_DAY;
        return new TestSuite(TestCopticChronology.class);
    }

    public TestCopticChronology(String name) {
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

public void testFactoryUTC309() { 
     assertEquals(DateTimeZone.UTC, CopticChronology.getInstanceUTC().getZone()); 
     assertSame(CopticChronology.class, CopticChronology.getInstanceUTC().getClass()); 
 } 


public void testEquality310() { 
     assertSame(CopticChronology.getInstance(TOKYO), CopticChronology.getInstance(TOKYO)); 
     assertSame(CopticChronology.getInstance(LONDON), CopticChronology.getInstance(LONDON)); 
     assertSame(CopticChronology.getInstance(PARIS), CopticChronology.getInstance(PARIS)); 
     assertSame(CopticChronology.getInstanceUTC(), CopticChronology.getInstanceUTC()); 
     assertSame(CopticChronology.getInstance(), CopticChronology.getInstance(LONDON)); 
 } 


public void testWithZone312() { 
     assertSame(CopticChronology.getInstance(TOKYO), CopticChronology.getInstance(TOKYO).withZone(TOKYO)); 
     assertSame(CopticChronology.getInstance(LONDON), CopticChronology.getInstance(TOKYO).withZone(LONDON)); 
     assertSame(CopticChronology.getInstance(PARIS), CopticChronology.getInstance(TOKYO).withZone(PARIS)); 
     assertSame(CopticChronology.getInstance(LONDON), CopticChronology.getInstance(TOKYO).withZone(null)); 
     assertSame(CopticChronology.getInstance(PARIS), CopticChronology.getInstance().withZone(PARIS)); 
     assertSame(CopticChronology.getInstance(PARIS), CopticChronology.getInstanceUTC().withZone(PARIS)); 
 } 


public void testEra313() { 
     assertEquals(1, CopticChronology.AM); 
     try { 
         new DateTime(-1, 13, 5, 0, 0, 0, 0, COPTIC_UTC); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testSampleDate314() { 
     DateTime dt = new DateTime(2004, 6, 9, 0, 0, 0, 0, ISO_UTC).withChronology(COPTIC_UTC); 
     assertEquals(CopticChronology.AM, dt.getEra()); 
     assertEquals(18, dt.getCenturyOfEra()); 
     assertEquals(20, dt.getYearOfCentury()); 
     assertEquals(1720, dt.getYearOfEra()); 
     assertEquals(1720, dt.getYear()); 
     Property fld = dt.year(); 
     assertEquals(false, fld.isLeap()); 
     assertEquals(0, fld.getLeapAmount()); 
     assertEquals(DurationFieldType.days(), fld.getLeapDurationField().getType()); 
     assertEquals(new DateTime(1721, 10, 2, 0, 0, 0, 0, COPTIC_UTC), fld.addToCopy(1)); 
     assertEquals(10, dt.getMonthOfYear()); 
     fld = dt.monthOfYear(); 
     assertEquals(false, fld.isLeap()); 
     assertEquals(0, fld.getLeapAmount()); 
     assertEquals(DurationFieldType.days(), fld.getLeapDurationField().getType()); 
     assertEquals(1, fld.getMinimumValue()); 
     assertEquals(1, fld.getMinimumValueOverall()); 
     assertEquals(13, fld.getMaximumValue()); 
     assertEquals(13, fld.getMaximumValueOverall()); 
     assertEquals(new DateTime(1721, 1, 2, 0, 0, 0, 0, COPTIC_UTC), fld.addToCopy(4)); 
     assertEquals(new DateTime(1720, 1, 2, 0, 0, 0, 0, COPTIC_UTC), fld.addWrapFieldToCopy(4)); 
     assertEquals(2, dt.getDayOfMonth()); 
     fld = dt.dayOfMonth(); 
     assertEquals(false, fld.isLeap()); 
     assertEquals(0, fld.getLeapAmount()); 
     assertEquals(null, fld.getLeapDurationField()); 
     assertEquals(1, fld.getMinimumValue()); 
     assertEquals(1, fld.getMinimumValueOverall()); 
     assertEquals(30, fld.getMaximumValue()); 
     assertEquals(30, fld.getMaximumValueOverall()); 
     assertEquals(new DateTime(1720, 10, 3, 0, 0, 0, 0, COPTIC_UTC), fld.addToCopy(1)); 
     assertEquals(DateTimeConstants.WEDNESDAY, dt.getDayOfWeek()); 
     fld = dt.dayOfWeek(); 
     assertEquals(false, fld.isLeap()); 
     assertEquals(0, fld.getLeapAmount()); 
     assertEquals(null, fld.getLeapDurationField()); 
     assertEquals(1, fld.getMinimumValue()); 
     assertEquals(1, fld.getMinimumValueOverall()); 
     assertEquals(7, fld.getMaximumValue()); 
     assertEquals(7, fld.getMaximumValueOverall()); 
     assertEquals(new DateTime(1720, 10, 3, 0, 0, 0, 0, COPTIC_UTC), fld.addToCopy(1)); 
     assertEquals(9 * 30 + 2, dt.getDayOfYear()); 
     fld = dt.dayOfYear(); 
     assertEquals(false, fld.isLeap()); 
     assertEquals(0, fld.getLeapAmount()); 
     assertEquals(null, fld.getLeapDurationField()); 
     assertEquals(1, fld.getMinimumValue()); 
     assertEquals(1, fld.getMinimumValueOverall()); 
     assertEquals(365, fld.getMaximumValue()); 
     assertEquals(366, fld.getMaximumValueOverall()); 
     assertEquals(new DateTime(1720, 10, 3, 0, 0, 0, 0, COPTIC_UTC), fld.addToCopy(1)); 
     assertEquals(0, dt.getHourOfDay()); 
     assertEquals(0, dt.getMinuteOfHour()); 
     assertEquals(0, dt.getSecondOfMinute()); 
     assertEquals(0, dt.getMillisOfSecond()); 
 } 


public void testDurationYear546() { 
     DateTime dt20 = new DateTime(1720, 10, 2, 0, 0, 0, 0, COPTIC_UTC); 
     DateTime dt21 = new DateTime(1721, 10, 2, 0, 0, 0, 0, COPTIC_UTC); 
     DateTime dt22 = new DateTime(1722, 10, 2, 0, 0, 0, 0, COPTIC_UTC); 
     DateTime dt23 = new DateTime(1723, 10, 2, 0, 0, 0, 0, COPTIC_UTC); 
     DateTime dt24 = new DateTime(1724, 10, 2, 0, 0, 0, 0, COPTIC_UTC); 
     DurationField fld = dt20.year().getDurationField(); 
     assertEquals(COPTIC_UTC.years(), fld); 
     assertEquals(1L * 365L * MILLIS_PER_DAY, fld.getMillis(1, dt20.getMillis())); 
     assertEquals(2L * 365L * MILLIS_PER_DAY, fld.getMillis(2, dt20.getMillis())); 
     assertEquals(3L * 365L * MILLIS_PER_DAY, fld.getMillis(3, dt20.getMillis())); 
     assertEquals((4L * 365L + 1L) * MILLIS_PER_DAY, fld.getMillis(4, dt20.getMillis())); 
     assertEquals(((4L * 365L + 1L) * MILLIS_PER_DAY) / 4, fld.getMillis(1)); 
     assertEquals(((4L * 365L + 1L) * MILLIS_PER_DAY) / 2, fld.getMillis(2)); 
     assertEquals(1L * 365L * MILLIS_PER_DAY, fld.getMillis(1L, dt20.getMillis())); 
     assertEquals(2L * 365L * MILLIS_PER_DAY, fld.getMillis(2L, dt20.getMillis())); 
     assertEquals(3L * 365L * MILLIS_PER_DAY, fld.getMillis(3L, dt20.getMillis())); 
     assertEquals((4L * 365L + 1L) * MILLIS_PER_DAY, fld.getMillis(4L, dt20.getMillis())); 
     assertEquals(((4L * 365L + 1L) * MILLIS_PER_DAY) / 4, fld.getMillis(1L)); 
     assertEquals(((4L * 365L + 1L) * MILLIS_PER_DAY) / 2, fld.getMillis(2L)); 
     assertEquals(((4L * 365L + 1L) * MILLIS_PER_DAY) / 4, fld.getUnitMillis()); 
     assertEquals(0, fld.getValue(1L * 365L * MILLIS_PER_DAY - 1L, dt20.getMillis())); 
     assertEquals(1, fld.getValue(1L * 365L * MILLIS_PER_DAY, dt20.getMillis())); 
     assertEquals(1, fld.getValue(1L * 365L * MILLIS_PER_DAY + 1L, dt20.getMillis())); 
     assertEquals(1, fld.getValue(2L * 365L * MILLIS_PER_DAY - 1L, dt20.getMillis())); 
     assertEquals(2, fld.getValue(2L * 365L * MILLIS_PER_DAY, dt20.getMillis())); 
     assertEquals(2, fld.getValue(2L * 365L * MILLIS_PER_DAY + 1L, dt20.getMillis())); 
     assertEquals(2, fld.getValue(3L * 365L * MILLIS_PER_DAY - 1L, dt20.getMillis())); 
     assertEquals(3, fld.getValue(3L * 365L * MILLIS_PER_DAY, dt20.getMillis())); 
     assertEquals(3, fld.getValue(3L * 365L * MILLIS_PER_DAY + 1L, dt20.getMillis())); 
     assertEquals(3, fld.getValue((4L * 365L + 1L) * MILLIS_PER_DAY - 1L, dt20.getMillis())); 
     assertEquals(4, fld.getValue((4L * 365L + 1L) * MILLIS_PER_DAY, dt20.getMillis())); 
     assertEquals(4, fld.getValue((4L * 365L + 1L) * MILLIS_PER_DAY + 1L, dt20.getMillis())); 
     assertEquals(dt21.getMillis(), fld.add(dt20.getMillis(), 1)); 
     assertEquals(dt22.getMillis(), fld.add(dt20.getMillis(), 2)); 
     assertEquals(dt23.getMillis(), fld.add(dt20.getMillis(), 3)); 
     assertEquals(dt24.getMillis(), fld.add(dt20.getMillis(), 4)); 
     assertEquals(dt21.getMillis(), fld.add(dt20.getMillis(), 1L)); 
     assertEquals(dt22.getMillis(), fld.add(dt20.getMillis(), 2L)); 
     assertEquals(dt23.getMillis(), fld.add(dt20.getMillis(), 3L)); 
     assertEquals(dt24.getMillis(), fld.add(dt20.getMillis(), 4L)); 
 } 

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    /**
     * Tests era, year, monthOfYear, dayOfMonth and dayOfWeek.
     */
    

    

    

    

    

}
