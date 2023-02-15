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
import java.util.Arrays;
import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for YearMonth.
 *
 * @author Stephen Colebourne
 */
public class TestYearMonth_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
//    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
//    private static final Chronology ISO_LONDON = ISOChronology.getInstance(LONDON);
//    private static final Chronology ISO_TOKYO = ISOChronology.getInstance(TOKYO);
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
//    private static final Chronology BUDDHIST_PARIS = BuddhistChronology.getInstance(PARIS);
//    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();
    
    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;

    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestYearMonth_Basics.class);
    }

    public TestYearMonth_Basics(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
    }

    //-----------------------------------------------------------------------
public void testWithField1133() { 
     YearMonth test = new YearMonth(2004, 6); 
     YearMonth result = test.withField(DateTimeFieldType.year(), 2006); 
     assertEquals(new YearMonth(2004, 6), test); 
     assertEquals(new YearMonth(2006, 6), result); 
 }
public void testWithField1134() { 
     YearMonth test = new YearMonth(2004, 6); 
     try { 
         test.withField(DateTimeFieldType.hourOfDay(), 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testMinusYears_int135() { 
     YearMonth test = new YearMonth(2002, 5, BuddhistChronology.getInstance()); 
     YearMonth result = test.minusYears(1); 
     YearMonth expected = new YearMonth(2001, 5, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusYears(0); 
     assertSame(test, result); 
 }
public void testToString_DTFormatter136() { 
     YearMonth test = new YearMonth(2002, 6); 
     assertEquals("2002 \ufffd\ufffd", test.toString(DateTimeFormat.forPattern("yyyy HH"))); 
     assertEquals("2002-06", test.toString((DateTimeFormatter) null)); 
 }
public void testToString_String_Locale137() { 
     YearMonth test = new YearMonth(1970, 6); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("mar. 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("1970-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("Tue 9/6", test.toString("EEE d/M", null)); 
     assertEquals("1970-06", test.toString(null, null)); 
 }
public void testToString_String_Locale138() { 
     YearMonth test = new YearMonth(2002, 6); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", null)); 
     assertEquals("2002-06", test.toString(null, null)); 
 }
    

    

    

    

    

    

    

    

    

    
    
    class MockYM extends MockPartial {
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.year(),
                COPTIC_UTC.monthOfYear(),
            };
        }
        public int[] getValues() {
            return new int[] {1970, 6};
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
    private void check(YearMonth test, int year, int month) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
    }
}
