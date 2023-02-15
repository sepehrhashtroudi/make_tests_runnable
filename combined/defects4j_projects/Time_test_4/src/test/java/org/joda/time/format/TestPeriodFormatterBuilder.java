/*
 *  Copyright 2001-2006 Stephen Colebourne
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

import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;

/**
 * This class is a Junit unit test for PeriodFormatterBuilder.
 *
 * @author Stephen Colebourne
 */
public class TestPeriodFormatterBuilder extends TestCase {
    
    private static final Period PERIOD = new Period(1, 2, 3, 4, 5, 6, 7, 8);
    private static final Period EMPTY_PERIOD = new Period(0, 0, 0, 0, 0, 0, 0, 0);
    private static final Period YEAR_DAY_PERIOD = new Period(1, 0, 0, 4, 5, 6, 7, 8, PeriodType.yearDayTime());
    private static final Period EMPTY_YEAR_DAY_PERIOD = new Period(0, 0, 0, 0, 0, 0, 0, 0, PeriodType.yearDayTime());
    private static final Period TIME_PERIOD = new Period(0, 0, 0, 0, 5, 6, 7, 8);
    private static final Period DATE_PERIOD = new Period(1, 2, 3, 4, 0, 0, 0, 0);

    //private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    //private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");

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
    
    private PeriodFormatterBuilder builder;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPeriodFormatterBuilder.class);
    }

    public TestPeriodFormatterBuilder(String name) {
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
        
        builder = new PeriodFormatterBuilder();
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
public void testFormatSuffixSimple258() { 
     PeriodFormatter f = builder.appendHours().appendSuffix(" hours").toFormatter(); 
     assertEquals("5 hours", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     Period p = new Period(0, 0, 0, 0, 0, 0, 0, 0); 
     assertEquals("0 hours", f.print(p)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(p, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(p, Integer.MAX_VALUE, null)); 
 }
public void testFormatAppend_PrinterParser_null_Parser59() { 
     PeriodParser parser = new PeriodFormatterBuilder().appendWeeks().appendLiteral("-").toParser(); 
     PeriodFormatterBuilder bld = new PeriodFormatterBuilder().append(null, parser).appendMonths(); 
     assertNull(bld.toPrinter()); 
     assertNotNull(bld.toParser()); 
     PeriodFormatter f = bld.toFormatter(); 
     try { 
         f.print(PERIOD); 
         fail(); 
     } catch (UnsupportedOperationException ex) { 
     } 
     assertEquals(new Period(0, 2, 1, 0, 0, 0, 0, 0), f.parsePeriod("1-2")); 
 }
public void testFormatPrefixSimple260() { 
     PeriodFormatter f = builder.appendPrefix("Hours:").appendHours().toFormatter(); 
     assertEquals("Hours:5", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     Period p = new Period(0, 0, 0, 0, 0, 0, 0, 0); 
     assertEquals("Hours:0", f.print(p)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(p, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(p, Integer.MAX_VALUE, null)); 
 }
public void testFormatSeparatorIfFieldsAfter61() { 
     PeriodFormatter f = builder.appendYears().appendSeparatorIfFieldsAfter("T").appendHours().toFormatter(); 
     assertEquals("1T5", f.print(PERIOD)); 
     assertEquals(3, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(2, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("T5", f.print(TIME_PERIOD)); 
     assertEquals(2, f.getPrinter().calculatePrintedLength(TIME_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(TIME_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("1", f.print(DATE_PERIOD)); 
     assertEquals(1, f.getPrinter().calculatePrintedLength(DATE_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(DATE_PERIOD, Integer.MAX_VALUE, null)); 
 }
public void testFormatAppend_PrinterParser_PrinterParser62() { 
     PeriodPrinter printer = new PeriodFormatterBuilder().appendYears().appendLiteral("-").toPrinter(); 
     PeriodParser parser = new PeriodFormatterBuilder().appendWeeks().appendLiteral("-").toParser(); 
     PeriodFormatterBuilder bld = new PeriodFormatterBuilder().append(printer, parser).appendMonths(); 
     assertNotNull(bld.toPrinter()); 
     assertNotNull(bld.toParser()); 
     PeriodFormatter f = bld.toFormatter(); 
     assertEquals("1-2", f.print(PERIOD)); 
     assertEquals(new Period(0, 2, 1, 0, 0, 0, 0, 0), f.parsePeriod("1-2")); 
 }
public void testFormatAppend_PrinterParserThenClear63() { 
     PeriodPrinter printer = new PeriodFormatterBuilder().appendYears().appendLiteral("-").toPrinter(); 
     PeriodParser parser = new PeriodFormatterBuilder().appendWeeks().appendLiteral("-").toParser(); 
     PeriodFormatterBuilder bld = new PeriodFormatterBuilder().append(printer, null).append(null, parser); 
     assertNull(bld.toPrinter()); 
     assertNull(bld.toParser()); 
     bld.clear(); 
     bld.appendMonths(); 
     assertNotNull(bld.toPrinter()); 
     assertNotNull(bld.toParser()); 
 }
public void testBug249545564() { 
     PeriodFormatter pfmt1 = new PeriodFormatterBuilder().appendLiteral("P").appendYears().appendSuffix("Y").appendMonths().appendSuffix("M").appendWeeks().appendSuffix("W").appendDays().appendSuffix("D").appendSeparatorIfFieldsAfter("T").appendHours().appendSuffix("H").appendMinutes().appendSuffix("M").appendSecondsWithOptionalMillis().appendSuffix("S").toFormatter(); 
     PeriodFormatter pfmt2 = new PeriodFormatterBuilder().append(ISOPeriodFormat.standard()).toFormatter(); 
     pfmt1.parsePeriod("PT1003199059S"); 
     pfmt2.parsePeriod("PT1003199059S"); 
 }
public void testFormatLiteral67() { 
     PeriodFormatter f = builder.appendLiteral("P").appendYears().toFormatter(); 
     assertEquals("P1Y2M", f.print(PERIOD)); 
     assertEquals(3, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(2, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("PT1003199059S", f.print(TIME_PERIOD)); 
     assertEquals(2001, f.getPrinter().calculatePrintedLength(TIME_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(TIME_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("1", f.print(DATE_PERIOD)); 
     assertEquals(1, f.getPrinter().calculatePrintedLength(DATE_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(DATE_PERIOD, Integer.MAX_VALUE, null)); 
 }
public void testFormatPrintZeroIfSupported68() { 
     PeriodFormatter f = new PeriodFormatterBuilder().printZeroIfSupported().appendYears().appendLiteral("-").appendMonths().appendLiteral("-").appendWeeks().appendLiteral("-").appendDays().toFormatter(); 
     assertEquals("1-2-3-4", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(4, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("0---", f.print(EMPTY_YEAR_DAY_PERIOD)); 
     assertEquals(4, f.getPrinter().calculatePrintedLength(EMPTY_YEAR_DAY_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(EMPTY_YEAR_DAY_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("1---4", f.print(YEAR_DAY_PERIOD)); 
     assertEquals(5, f.getPrinter().calculatePrintedLength(YEAR_DAY_PERIOD, null)); 
     assertEquals(2, f.getPrinter().countFieldsToPrint(YEAR_DAY_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("0---", f.print(EMPTY_PERIOD)); 
     assertEquals(4, f.getPrinter().calculatePrintedLength(EMPTY_PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(EMPTY_PERIOD, Integer.MAX_VALUE, null)); 
 }
public void testFormatSuffixPlural269() { 
     PeriodFormatter f = builder.appendHours().appendSuffix(" hour", " hours").toFormatter(); 
     assertEquals("5 hours", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     Period p = new Period(0, 0, 0, 0, 0, 0, 0, 0); 
     assertEquals("0 hours", f.print(p)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(p, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(p, Integer.MAX_VALUE, null)); 
 }
public void testFormatSuffixPlural370() { 
     try { 
         builder.appendSuffix(" hour", " hours"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         builder.appendSuffix(" hours", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         builder.appendSuffix(" hours", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testFormatPrintZeroAlways71() { 
     PeriodFormatter f = new PeriodFormatterBuilder().printZeroAlways().appendYears().appendLiteral("-").appendMonths().appendLiteral("-").appendWeeks().appendLiteral("-").appendDays().toFormatter(); 
     assertEquals("1-2-3-4", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(4, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("0-0-0-0", f.print(EMPTY_YEAR_DAY_PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(EMPTY_YEAR_DAY_PERIOD, null)); 
     assertEquals(4, f.getPrinter().countFieldsToPrint(EMPTY_YEAR_DAY_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("1-0-0-4", f.print(YEAR_DAY_PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(YEAR_DAY_PERIOD, null)); 
     assertEquals(4, f.getPrinter().countFieldsToPrint(YEAR_DAY_PERIOD, Integer.MAX_VALUE, null)); 
     assertEquals("0-0-0-0", f.print(EMPTY_PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(EMPTY_PERIOD, null)); 
     assertEquals(4, f.getPrinter().countFieldsToPrint(EMPTY_PERIOD, Integer.MAX_VALUE, null)); 
 }
public void testFormatMillis3Digit72() { 
     PeriodFormatter f = builder.appendMillis3Digit().toFormatter(); 
     assertEquals("123", f.print(PERIOD)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(PERIOD, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(PERIOD, Integer.MAX_VALUE, null)); 
     Period p = new Period(0, 0, 0, 0, 0, 0, 0, 0); 
     assertEquals("0", f.print(p)); 
     assertEquals(7, f.getPrinter().calculatePrintedLength(p, null)); 
     assertEquals(1, f.getPrinter().countFieldsToPrint(p, Integer.MAX_VALUE, null)); 
 }
public void testFormatPrintZeroRarelyFirstSeconds75() { 
     PeriodFormatter f = new PeriodFormatterBuilder().printZeroRarelyFirst().appendSeconds().toFormatter(); 
     assertEquals("0", f.print(EMPTY_PERIOD)); 
 }
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

}
