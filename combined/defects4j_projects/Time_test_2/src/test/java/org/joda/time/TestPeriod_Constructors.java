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
package org.joda.time;

import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a JUnit test for Duration.
 *
 * @author Stephen Colebourne
 */
public class TestPeriod_Constructors extends TestCase {
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
            
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPeriod_Constructors.class);
    }

    public TestPeriod_Constructors(String name) {
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
@SuppressWarnings("deprecation") 
 public void testFactoryFieldDifference136() throws Throwable { 
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
public void testFactoryFieldDifference537() throws Throwable { 
     DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.dayOfYear() }; 
     Partial start = new Partial(types, new int[] { 1, 2, 3 }); 
     Partial end1 = new Partial(types, new int[] { 1, 2, 3 }); 
     Partial end2 = new Partial(types, new int[] { 1, 2, 3 }); 
     try { 
         Period.fieldDifference(start, end1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(start, start); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(end1, end1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(end1, start); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(start, end2); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFactoryFieldDifference139() throws Throwable { 
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
public void testFactoryFieldDifference540() throws Throwable { 
     DateTimeFieldType[] types = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.dayOfYear() }; 
     Partial start = new Partial(types, new int[] { 1, 2, 3 }); 
     Partial end = new Partial(types, new int[] { 1, 2, 3 }); 
     try { 
         Period.fieldDifference(start, end); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(start, null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference((ReadablePartial) null, end); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(start, new LocalTime()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         Period.fieldDifference(new Partial(types, new int[] { 1, 2, 3 }), new Partial(types, new int[] { 1, 2, 3 })); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testConstructor_RD_RI246() throws Throwable { 
     DateTime dt1 = new DateTime(2004, 6, 9, 0, 0, 0, 0); 
     Duration dur = null; 
     Period test = new Period(dur, dt1); 
     assertEquals(PeriodType.standard(), test.getPeriodType()); 
     assertEquals(0, test.getYears()); 
     assertEquals(0, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(0, test.getDays()); 
     assertEquals(0, test.getHours()); 
     assertEquals(0, test.getMinutes()); 
     assertEquals(0, test.getSeconds()); 
     assertEquals(0, test.getMillis()); 
 }
public void testNormalizedStandard_yearMonth147() { 
     Period test = new Period(1, 15, 0, 0, 0, 0, 0, 0); 
     Period result = test.normalizedStandard(); 
     assertEquals(new Period(1, 15, 0, 0, 0, 0, 0, 0), test); 
     assertEquals(new Period(2, 3, 0, 0, 0, 0, 0, 0), result); 
 }
public void testConstructor_Object_PeriodType1322() throws Throwable { 
     Period test = new Period("P1Y2M3D", PeriodType.yearMonthDayTime()); 
     assertEquals(PeriodType.yearMonthDayTime(), test.getPeriodType()); 
     assertEquals(1, test.getYears()); 
     assertEquals(2, test.getMonths()); 
     assertEquals(0, test.getWeeks()); 
     assertEquals(3, test.getDays()); 
     assertEquals(0, test.getHours()); 
     assertEquals(0, test.getMinutes()); 
     assertEquals(0, test.getSeconds()); 
     assertEquals(0, test.getMillis()); 
 }
public void testConstructor_RP_RP_PeriodType8362() throws Throwable { 
     Partial dt1 = new Partial().with(DateTimeFieldType.year(), 2005).with(DateTimeFieldType.hourOfDay(), 12); 
     Partial dt2 = new Partial().with(DateTimeFieldType.year(), 2005).with(DateTimeFieldType.hourOfDay(), 14); 
     try { 
         new Period(dt1, dt2, PeriodType.standard()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    /**
     * Test constructor (4ints)
     */
    

    //-----------------------------------------------------------------------
    /**
     * Test constructor (8ints)
     */
    

    //-----------------------------------------------------------------------
    /**
     * Test constructor (8ints)
     */
    

    

    

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
    /**
     * Test constructor (Object)
     */
    

    

    

    

    //-----------------------------------------------------------------------
    /**
     * Test constructor (Object)
     */
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-------------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-------------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

}
