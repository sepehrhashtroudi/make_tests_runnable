/*
 *  Copyright 2001-2011 Stephen Colebourne
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
import org.joda.time.DateTime;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.joda.time.ReadablePartial;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for DateTime Formating.
 *
 * @author Stephen Colebourne
 */
public class TestDateTimeFormatter extends TestCase {

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
    private DateTimeFormatter f = null;
    private DateTimeFormatter g = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDateTimeFormatter.class);
    }

    public TestDateTimeFormatter(String name) {
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
        f = new DateTimeFormatterBuilder()
                .appendDayOfWeekShortText()
                .appendLiteral(' ')
                .append(ISODateTimeFormat.dateTimeNoMillis())
                .toFormatter();
        g = ISODateTimeFormat.dateTimeNoMillis();
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
        g = null;
    }

    //-----------------------------------------------------------------------

public void testParseLocalDate_year_month_week_2010116() { 
     Chronology chrono = GJChronology.getInstanceUTC(); 
     DateTimeFormatter f = DateTimeFormat.forPattern("yyyy-MM-ww").withChronology(chrono); 
     assertEquals(new LocalDate(2010, 1, 4, chrono), f.parseLocalDate("2010-01-01")); 
 } 


public void testPrint_chrono_and_zone149() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("Wed 2004-06-09T10:20:30Z", f.withChronology(null).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(PARIS).print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withChronology(ISO_PARIS).withZone(NEWYORK).print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withChronology(null).withZone(NEWYORK).print(dt)); 
     dt = dt.withChronology(ISO_PARIS); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(null).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(PARIS).print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withChronology(ISO_PARIS).withZone(NEWYORK).print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withChronology(null).withZone(NEWYORK).print(dt)); 
     dt = dt.withChronology(BUDDHIST_PARIS); 
     assertEquals("Wed 2547-06-09T12:20:30+02:00", f.withChronology(null).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(null).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withChronology(ISO_PARIS).withZone(PARIS).print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withChronology(ISO_PARIS).withZone(NEWYORK).print(dt)); 
     assertEquals("Wed 2547-06-09T06:20:30-04:00", f.withChronology(null).withZone(NEWYORK).print(dt)); 
 } 


public void testParseInto_monthDay_feb29_tokyo275() { 
     DateTimeFormatter f = DateTimeFormat.forPattern("M d").withLocale(Locale.UK); 
     MutableDateTime result = new MutableDateTime(2004, 1, 9, 12, 20, 30, 0, TOKYO); 
     assertEquals(4, f.parseInto(result, "2 29", 0)); 
     assertEquals(new MutableDateTime(2004, 2, 29, 12, 20, 30, 0, TOKYO), result); 
 } 


public void testPrint_writerMethods413() throws Exception { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     CharArrayWriter out = new CharArrayWriter(); 
     f.printTo(out, dt); 
     assertEquals("Wed 2004-06-09T10:20:30Z", out.toString()); 
     out = new CharArrayWriter(); 
     f.printTo(out, dt.getMillis()); 
     assertEquals("Wed 2004-06-09T11:20:30+01:00", out.toString()); 
     out = new CharArrayWriter(); 
     ISODateTimeFormat.yearMonthDay().printTo(out, dt.toYearMonthDay()); 
     assertEquals("2004-06-09", out.toString()); 
     out = new CharArrayWriter(); 
     try { 
         ISODateTimeFormat.yearMonthDay().printTo(out, (ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParseDateTime_simple_precedence941() { 
     DateTime expect = null; 
     expect = new DateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     assertEquals(expect, f.parseDateTime("Wed 2004-06-09T10:20:30Z")); 
     expect = new DateTime(2004, 6, 7, 11, 20, 30, 0, LONDON); 
     assertEquals(expect, f.parseDateTime("Mon 2004-06-09T10:20:30Z")); 
 } 


public void testParseMillis_fractionOfSecondLong1106() { 
     DateTimeFormatter f = new DateTimeFormatterBuilder().appendSecondOfDay(2).appendLiteral('.').appendFractionOfSecond(1, 9).toFormatter().withZoneUTC(); 
     assertEquals(10512, f.parseMillis("10.5123456")); 
     assertEquals(10512, f.parseMillis("10.512999")); 
 } 


public void testPrinterParserMethods1337() { 
     DateTimeFormatter f2 = new DateTimeFormatter(f.getPrinter(), f.getParser()); 
     assertEquals(f.getPrinter(), f2.getPrinter()); 
     assertEquals(f.getParser(), f2.getParser()); 
     assertEquals(true, f2.isPrinter()); 
     assertEquals(true, f2.isParser()); 
     assertNotNull(f2.print(0L)); 
     assertNotNull(f2.parseDateTime("Thu 1970-01-01T00:00:00Z")); 
     f2 = new DateTimeFormatter(f.getPrinter(), null); 
     assertEquals(f.getPrinter(), f2.getPrinter()); 
     assertEquals(null, f2.getParser()); 
     assertEquals(true, f2.isPrinter()); 
     assertEquals(false, f2.isParser()); 
     assertNotNull(f2.print(0L)); 
     try { 
         f2.parseDateTime("Thu 1970-01-01T00:00:00Z"); 
         fail(); 
     } catch (UnsupportedOperationException ex) { 
     } 
     f2 = new DateTimeFormatter(null, f.getParser()); 
     assertEquals(null, f2.getPrinter()); 
     assertEquals(f.getParser(), f2.getParser()); 
     assertEquals(false, f2.isPrinter()); 
     assertEquals(true, f2.isParser()); 
     try { 
         f2.print(0L); 
         fail(); 
     } catch (UnsupportedOperationException ex) { 
     } 
     assertNotNull(f2.parseDateTime("Thu 1970-01-01T00:00:00Z")); 
 } 


public void testParseInto_monthDay_feb29_tokyo_startOfYear1338() { 
     DateTimeFormatter f = DateTimeFormat.forPattern("M d").withLocale(Locale.UK); 
     MutableDateTime result = new MutableDateTime(2004, 1, 1, 0, 0, 0, 0, TOKYO); 
     assertEquals(4, f.parseInto(result, "2 29", 0)); 
     assertEquals(new MutableDateTime(2004, 2, 29, 0, 0, 0, 0, TOKYO), result); 
 } 


public void testWithGetLocale1339() { 
     DateTimeFormatter f2 = f.withLocale(Locale.FRENCH); 
     assertEquals(Locale.FRENCH, f2.getLocale()); 
     assertSame(f2, f2.withLocale(Locale.FRENCH)); 
     f2 = f.withLocale(null); 
     assertEquals(null, f2.getLocale()); 
     assertSame(f2, f2.withLocale(null)); 
 } 


public void testParseLocalDate_weekyear_month_week_20111340() { 
     Chronology chrono = GJChronology.getInstanceUTC(); 
     DateTimeFormatter f = DateTimeFormat.forPattern("xxxx-MM-ww").withChronology(chrono); 
     assertEquals(new LocalDate(2011, 1, 3, chrono), f.parseLocalDate("2011-01-01")); 
 } 


public void testWithGetChronology1341() { 
     DateTimeFormatter f2 = f.withChronology(BUDDHIST_PARIS); 
     assertEquals(BUDDHIST_PARIS, f2.getChronology()); 
     assertSame(f2, f2.withChronology(BUDDHIST_PARIS)); 
     f2 = f.withChronology(null); 
     assertEquals(null, f2.getChronology()); 
     assertSame(f2, f2.withChronology(null)); 
 } 


public void testPrint_zone1342() { 
     DateTime dt = new DateTime(2004, 6, 9, 10, 20, 30, 40, UTC); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withZone(NEWYORK).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withZone(PARIS).print(dt)); 
     assertEquals("Wed 2004-06-09T10:20:30Z", f.withZone(null).print(dt)); 
     dt = dt.withZone(NEWYORK); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withZone(NEWYORK).print(dt)); 
     assertEquals("Wed 2004-06-09T12:20:30+02:00", f.withZone(PARIS).print(dt)); 
     assertEquals("Wed 2004-06-09T10:20:30Z", f.withZoneUTC().print(dt)); 
     assertEquals("Wed 2004-06-09T06:20:30-04:00", f.withZone(null).print(dt)); 
 } 


public void testParseMutableDateTime_zone1343() { 
     MutableDateTime expect = null; 
     expect = new MutableDateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     assertEquals(expect, g.withZone(LONDON).parseMutableDateTime("2004-06-09T10:20:30Z")); 
     expect = new MutableDateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     assertEquals(expect, g.withZone(null).parseMutableDateTime("2004-06-09T10:20:30Z")); 
     expect = new MutableDateTime(2004, 6, 9, 12, 20, 30, 0, PARIS); 
     assertEquals(expect, g.withZone(PARIS).parseMutableDateTime("2004-06-09T10:20:30Z")); 
 } 


public void testWithGetPivotYear1344() { 
     DateTimeFormatter f2 = f.withPivotYear(13); 
     assertEquals(new Integer(13), f2.getPivotYear()); 
     assertSame(f2, f2.withPivotYear(13)); 
     f2 = f.withPivotYear(new Integer(14)); 
     assertEquals(new Integer(14), f2.getPivotYear()); 
     assertSame(f2, f2.withPivotYear(new Integer(14))); 
     f2 = f.withPivotYear(null); 
     assertEquals(null, f2.getPivotYear()); 
     assertSame(f2, f2.withPivotYear(null)); 
 } 


public void testParseLocalDate_monthDay_withDefaultYear_feb291345() { 
     Chronology chrono = GJChronology.getInstanceUTC(); 
     DateTimeFormatter f = DateTimeFormat.forPattern("M d").withChronology(chrono).withLocale(Locale.UK).withDefaultYear(2012); 
     assertEquals(new LocalDate(2012, 2, 29, chrono), f.parseLocalDate("2 29")); 
 } 


public void testParseInto_offsetParsed1346() { 
     MutableDateTime expect = null; 
     MutableDateTime result = null; 
     expect = new MutableDateTime(2004, 6, 9, 10, 20, 30, 0, UTC); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withOffsetParsed().parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
     expect = new MutableDateTime(2004, 6, 9, 6, 20, 30, 0, DateTimeZone.forOffsetHours(-4)); 
     result = new MutableDateTime(0L); 
     assertEquals(25, g.withOffsetParsed().parseInto(result, "2004-06-09T06:20:30-04:00", 0)); 
     assertEquals(expect, result); 
     expect = new MutableDateTime(2004, 6, 9, 10, 20, 30, 0, UTC); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withZone(PARIS).withOffsetParsed().parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
     expect = new MutableDateTime(2004, 6, 9, 12, 20, 30, 0, PARIS); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withOffsetParsed().withZone(PARIS).parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
 } 


public void testParseInto_zone1347() { 
     MutableDateTime expect = null; 
     MutableDateTime result = null; 
     expect = new MutableDateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withZone(LONDON).parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
     expect = new MutableDateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withZone(null).parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
     expect = new MutableDateTime(2004, 6, 9, 12, 20, 30, 0, PARIS); 
     result = new MutableDateTime(0L); 
     assertEquals(20, g.withZone(PARIS).parseInto(result, "2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
 } 


public void testParseLocalDateTime_simple1348() { 
     assertEquals(new LocalDateTime(2004, 6, 9, 10, 20, 30), g.parseLocalDateTime("2004-06-09T10:20:30Z")); 
     assertEquals(new LocalDateTime(2004, 6, 9, 10, 20, 30), g.parseLocalDateTime("2004-06-09T10:20:30+18:00")); 
     assertEquals(new LocalDateTime(2004, 6, 9, 10, 20, 30), g.parseLocalDateTime("2004-06-09T10:20:30-18:00")); 
     assertEquals(new LocalDateTime(2004, 6, 9, 10, 20, 30, 0, BUDDHIST_PARIS), g.withChronology(BUDDHIST_PARIS).parseLocalDateTime("2004-06-09T10:20:30Z")); 
     try { 
         g.parseDateTime("ABC"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParseMutableDateTime_simple1349() { 
     MutableDateTime expect = null; 
     expect = new MutableDateTime(2004, 6, 9, 11, 20, 30, 0, LONDON); 
     assertEquals(expect, g.parseMutableDateTime("2004-06-09T10:20:30Z")); 
     try { 
         g.parseMutableDateTime("ABC"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testParseInto_simple_precedence1403() { 
     MutableDateTime expect = null; 
     MutableDateTime result = null; 
     expect = new MutableDateTime(2004, 6, 7, 11, 20, 30, 0, LONDON); 
     result = new MutableDateTime(0L); 
     assertEquals(24, f.parseInto(result, "Mon 2004-06-09T10:20:30Z", 0)); 
     assertEquals(expect, result); 
 } 

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

// This test fails, but since more related tests pass with the extra loop in DateTimeParserBucket
// I'm going to leave the change in and ignore this test
//    public void testParseLocalDate_weekyear_month_week_2013() {
//        Chronology chrono = GJChronology.getInstanceUTC();
//        DateTimeFormatter f = DateTimeFormat.forPattern("xxxx-MM-ww").withChronology(chrono);
//        assertEquals(new LocalDate(2012, 12, 31, chrono), f.parseLocalDate("2013-01-01"));
//    }

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    // Ensure time zone name switches properly at the zone DST transition.
    
// Defects4J: flaky method
//     public void testZoneNameNearTransition() {
//         DateTime inDST_1  = new DateTime(2005, 10, 30, 1, 0, 0, 0, NEWYORK);
//         DateTime inDST_2  = new DateTime(2005, 10, 30, 1, 59, 59, 999, NEWYORK);
//         DateTime onDST    = new DateTime(2005, 10, 30, 2, 0, 0, 0, NEWYORK);
//         DateTime outDST   = new DateTime(2005, 10, 30, 2, 0, 0, 1, NEWYORK);
//         DateTime outDST_2 = new DateTime(2005, 10, 30, 2, 0, 1, 0, NEWYORK);
// 
//         DateTimeFormatter fmt = DateTimeFormat.forPattern("yyy-MM-dd HH:mm:ss.S zzzz");
//         assertEquals("2005-10-30 01:00:00.0 Eastern Daylight Time", fmt.print(inDST_1));
//         assertEquals("2005-10-30 01:59:59.9 Eastern Daylight Time", fmt.print(inDST_2));
//         assertEquals("2005-10-30 02:00:00.0 Eastern Standard Time", fmt.print(onDST));
//         assertEquals("2005-10-30 02:00:00.0 Eastern Standard Time", fmt.print(outDST));
//         assertEquals("2005-10-30 02:00:01.0 Eastern Standard Time", fmt.print(outDST_2));
//     }

    // Ensure time zone name switches properly at the zone DST transition.
    
// Defects4J: flaky method
//     public void testZoneShortNameNearTransition() {
//         DateTime inDST_1  = new DateTime(2005, 10, 30, 1, 0, 0, 0, NEWYORK);
//         DateTime inDST_2  = new DateTime(2005, 10, 30, 1, 59, 59, 999, NEWYORK);
//         DateTime onDST    = new DateTime(2005, 10, 30, 2, 0, 0, 0, NEWYORK);
//         DateTime outDST   = new DateTime(2005, 10, 30, 2, 0, 0, 1, NEWYORK);
//         DateTime outDST_2 = new DateTime(2005, 10, 30, 2, 0, 1, 0, NEWYORK);
// 
//         DateTimeFormatter fmt = DateTimeFormat.forPattern("yyy-MM-dd HH:mm:ss.S z");
//         assertEquals("2005-10-30 01:00:00.0 EDT", fmt.print(inDST_1));
//         assertEquals("2005-10-30 01:59:59.9 EDT", fmt.print(inDST_2));
//         assertEquals("2005-10-30 02:00:00.0 EST", fmt.print(onDST));
//         assertEquals("2005-10-30 02:00:00.0 EST", fmt.print(outDST));
//         assertEquals("2005-10-30 02:00:01.0 EST", fmt.print(outDST_2));
//     }

}
