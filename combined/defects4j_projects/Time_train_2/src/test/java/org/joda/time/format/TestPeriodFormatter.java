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

import java.io.CharArrayWriter;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.Chronology;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for Period Formating.
 *
 * @author Stephen Colebourne
 */
public class TestPeriodFormatter extends TestCase {

    private static final DateTimeZone UTC = DateTimeZone.UTC;
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final DateTimeZone NEWYORK = DateTimeZone.forID("America/New_York");
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final Chronology BUDDHIST_PARIS = BuddhistChronology.getInstance(PARIS);

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
    private PeriodFormatter f = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPeriodFormatter.class);
    }

    public TestPeriodFormatter(String name) {
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
        f = ISOPeriodFormat.standard();
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
        f = null;
    }

    //-----------------------------------------------------------------------

public void testPrint_writerMethods161() throws Exception { 
     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); 
     CharArrayWriter out = new CharArrayWriter(); 
     f.printTo(out, p); 
     assertEquals("P1Y2M3W4DT5H6M7.008S", out.toString()); 
     out = new CharArrayWriter(); 
     try { 
         f.printTo(out, null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParsePeriod_simple168() { 
     Period expect = new Period(1, 2, 3, 4, 5, 6, 7, 8); 
     assertEquals(expect, f.parsePeriod("P1Y2M3W4DT5H6M7.008S")); 
     try { 
         f.parsePeriod("ABC"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testWithGetLocaleMethods616() { 
     PeriodFormatter f2 = f.withLocale(Locale.FRENCH); 
     assertEquals(Locale.FRENCH, f2.getLocale()); 
     assertSame(f2, f2.withLocale(Locale.FRENCH)); 
     f2 = f.withLocale(null); 
     assertEquals(null, f2.getLocale()); 
     assertSame(f2, f2.withLocale(null)); 
 } 


public void testWithGetParseTypeMethods617() { 
     PeriodFormatter f2 = f.withParseType(PeriodType.dayTime()); 
     assertEquals(PeriodType.dayTime(), f2.getParseType()); 
     assertSame(f2, f2.withParseType(PeriodType.dayTime())); 
     f2 = f.withParseType(null); 
     assertEquals(null, f2.getParseType()); 
     assertSame(f2, f2.withParseType(null)); 
 } 


public void testPrint_bufferMethods618() throws Exception { 
     Period p = new Period(1, 2, 3, 4, 5, 6, 7, 8); 
     StringBuffer buf = new StringBuffer(); 
     f.printTo(buf, p); 
     assertEquals("P1Y2M3W4DT5H6M7.008S", buf.toString()); 
     buf = new StringBuffer(); 
     try { 
         f.printTo(buf, null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParseInto_simple619() { 
     MutablePeriod expect = new MutablePeriod(1, 2, 3, 4, 5, 6, 7, 8); 
     MutablePeriod result = new MutablePeriod(); 
     assertEquals(20, f.parseInto(result, "P1Y2M3W4DT5H6M7.008S", 0)); 
     assertEquals(expect, result); 
     try { 
         f.parseInto(null, "P1Y2M3W4DT5H6M7.008S", 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     assertEquals(~0, f.parseInto(result, "ABC", 0)); 
 } 


public void testParsePeriod_parseType819() { 
     Period expect = new Period(0, 0, 0, 4, 5, 6, 7, 8, PeriodType.dayTime()); 
     assertEquals(expect, f.withParseType(PeriodType.dayTime()).parsePeriod("P4DT5H6M7.008S")); 
     try { 
         f.withParseType(PeriodType.dayTime()).parsePeriod("P3W4DT5H6M7.008S"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParseMutablePeriod_simple1199() { 
     MutablePeriod expect = new MutablePeriod(1, 2, 3, 4, 5, 6, 7, 8); 
     assertEquals(expect, f.parseMutablePeriod("P1Y2M3W4DT5H6M7.008S")); 
     try { 
         f.parseMutablePeriod("ABC"); 
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
    

}
