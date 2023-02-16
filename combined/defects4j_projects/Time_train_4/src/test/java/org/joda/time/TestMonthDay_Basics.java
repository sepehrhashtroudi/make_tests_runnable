/*
 *  Copyright 2001-2010 Stephen Colebourne
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
 * This class is a Junit unit test for MonthDay. Based on {@link TestYearMonth_Basics} 
 */
public class TestMonthDay_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
//    private static final Chronology COPTIC_LONDON = CopticChronology.getInstance(LONDON);
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
        return new TestSuite(TestMonthDay_Basics.class);
    }

    public TestMonthDay_Basics(String name) {
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

public void testPlusDays_int8() { 
     MonthDay test = new MonthDay(5, 10, BuddhistChronology.getInstance()); 
     MonthDay result = test.plusDays(1); 
     MonthDay expected = new MonthDay(5, 11, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
 } 


public void testWithers408() { 
     MonthDay test = new MonthDay(10, 6); 
     check(test.withMonthOfYear(5), 5, 6); 
     check(test.withDayOfMonth(2), 10, 2); 
     try { 
         test.withMonthOfYear(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withMonthOfYear(13); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testProperty432() { 
     MonthDay test = new MonthDay(6, 6); 
     assertEquals(test.monthOfYear(), test.property(DateTimeFieldType.monthOfYear())); 
     assertEquals(test.dayOfMonth(), test.property(DateTimeFieldType.dayOfMonth())); 
     try { 
         test.property(DateTimeFieldType.millisOfDay()); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testEqualsHashCode467() { 
     MonthDay test1 = new MonthDay(10, 6, COPTIC_PARIS); 
     MonthDay test2 = new MonthDay(10, 6, COPTIC_PARIS); 
     assertEquals(true, test1.equals(test2)); 
     assertEquals(true, test2.equals(test1)); 
     assertEquals(true, test1.equals(test1)); 
     assertEquals(true, test2.equals(test2)); 
     assertEquals(true, test1.hashCode() == test2.hashCode()); 
     assertEquals(true, test1.hashCode() == test1.hashCode()); 
     assertEquals(true, test2.hashCode() == test2.hashCode()); 
     MonthDay test3 = new MonthDay(10, 6); 
     assertEquals(false, test1.equals(test3)); 
     assertEquals(false, test2.equals(test3)); 
     assertEquals(false, test3.equals(test1)); 
     assertEquals(false, test3.equals(test2)); 
     assertEquals(false, test1.hashCode() == test3.hashCode()); 
     assertEquals(false, test2.hashCode() == test3.hashCode()); 
     assertEquals(false, test1.equals("Hello")); 
     assertEquals(true, test1.equals(new MockMD())); 
     assertEquals(false, test1.equals(MockPartial.EMPTY_INSTANCE)); 
 } 


public void testToString_String517() { 
     MonthDay test = new MonthDay(5, 6); 
     assertEquals("05 \ufffd\ufffd", test.toString("MM HH")); 
     assertEquals("--05-06", test.toString((String) null)); 
 } 


public void testIsSupported1268() { 
     MonthDay test = new MonthDay(COPTIC_PARIS); 
     assertEquals(false, test.isSupported(DateTimeFieldType.year())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.monthOfYear())); 
     assertEquals(true, test.isSupported(DateTimeFieldType.dayOfMonth())); 
     assertEquals(false, test.isSupported(DateTimeFieldType.hourOfDay())); 
 } 


public void testWithChronologyRetainFields_Chrono1271() { 
     MonthDay base = new MonthDay(6, 6, COPTIC_PARIS); 
     MonthDay test = base.withChronologyRetainFields(BUDDHIST_TOKYO); 
     check(base, 6, 6); 
     assertEquals(COPTIC_UTC, base.getChronology()); 
     check(test, 6, 6); 
     assertEquals(BUDDHIST_UTC, test.getChronology()); 
 } 


public void testGetField1272() { 
     MonthDay test = new MonthDay(COPTIC_PARIS); 
     assertSame(COPTIC_UTC.monthOfYear(), test.getField(0)); 
     assertSame(COPTIC_UTC.dayOfMonth(), test.getField(1)); 
     try { 
         test.getField(-1); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
     try { 
         test.getField(2); 
     } catch (IndexOutOfBoundsException ex) { 
     } 
 } 


public void testGetFieldTypes1273() { 
     MonthDay test = new MonthDay(COPTIC_PARIS); 
     DateTimeFieldType[] fields = test.getFieldTypes(); 
     assertEquals(2, fields.length); 
     assertSame(DateTimeFieldType.monthOfYear(), fields[0]); 
     assertSame(DateTimeFieldType.dayOfMonth(), fields[1]); 
     assertNotSame(test.getFieldTypes(), test.getFieldTypes()); 
 } 


public void testWithField1274() { 
     MonthDay test = new MonthDay(9, 6); 
     MonthDay result = test.withField(DateTimeFieldType.monthOfYear(), 10); 
     assertEquals(new MonthDay(9, 6), test); 
     assertEquals(new MonthDay(10, 6), result); 
 } 


public void testWithFieldAdded_unknownField1275() { 
     MonthDay test = new MonthDay(9, 6); 
     try { 
         test.withFieldAdded(DurationFieldType.hours(), 6); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testPlusDays_same1276() { 
     MonthDay test = new MonthDay(5, 10, BuddhistChronology.getInstance()); 
     MonthDay result = test.plusDays(0); 
     assertSame(test, result); 
 } 


public void testPlusMonths_int_wrap1277() { 
     MonthDay test = new MonthDay(6, 5, ISO_UTC); 
     MonthDay result = test.plusMonths(10); 
     MonthDay expected = new MonthDay(4, 5, ISO_UTC); 
     assertEquals(expected, result); 
 } 


public void testMinusMonths_int1278() { 
     MonthDay test = new MonthDay(6, 5, BuddhistChronology.getInstance()); 
     MonthDay result = test.minusMonths(1); 
     MonthDay expected = new MonthDay(5, 5, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
 } 


public void testMinusDays_int_negativeFromLeap1279() { 
     MonthDay test = new MonthDay(2, 29, ISOChronology.getInstanceUTC()); 
     MonthDay result = test.minusDays(-1); 
     MonthDay expected = new MonthDay(3, 1, ISOChronology.getInstance()); 
     assertEquals(expected, result); 
 } 


public void testToLocalDate1280() { 
     MonthDay base = new MonthDay(6, 6, COPTIC_UTC); 
     LocalDate test = base.toLocalDate(2009); 
     assertEquals(new LocalDate(2009, 6, 6, COPTIC_UTC), test); 
     try { 
         base.toLocalDate(0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testToString_String_Locale1282() { 
     MonthDay test = new MonthDay(5, 6); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("--05-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", null)); 
     assertEquals("--05-06", test.toString(null, null)); 
 } 

    

    

    

    

    

    

    

    

    

    
    
    class MockMD extends MockPartial {
        
        @Override
        public Chronology getChronology() {
            return COPTIC_UTC;
        }
        
        @Override
        public DateTimeField[] getFields() {
            return new DateTimeField[] {
                COPTIC_UTC.monthOfYear(),
                COPTIC_UTC.dayOfMonth()
            };
        }
        
        @Override
        public int[] getValues() {
            return new int[] {10, 6};
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
    

    

    

    

    

    

    

    

    

    //-------------------------------------------------------------------------
    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    //-------------------------------------------------------------------------
    

    

    

    
    
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
    private void check(MonthDay test, int month, int day) {
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
    }
}
