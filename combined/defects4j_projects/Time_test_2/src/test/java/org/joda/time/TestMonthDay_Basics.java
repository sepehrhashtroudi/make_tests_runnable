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
public void testEqualsHashCode521() { 
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
public void testWithChronologyRetainFields_sameChrono524() { 
     MonthDay base = new MonthDay(6, 6, COPTIC_PARIS); 
     MonthDay test = base.withChronologyRetainFields(COPTIC_TOKYO); 
     assertSame(base, test); 
 }
public void testGetFieldTypes525() { 
     MonthDay test = new MonthDay(6, 6); 
     DateTimeFieldType[] fields = test.getFieldTypes(); 
     assertSame(DateTimeFieldType.monthOfYear(), fields[0]); 
     assertSame(DateTimeFieldType.dayOfMonth(), fields[1]); 
     assertSame(DateTimeFieldType.dayOfWeek(), fields[2]); 
     assertNotSame(test.getFieldTypes(), test.getFieldTypes()); 
 }
public void testGetFieldTypes526() { 
     MonthDay test = new MonthDay(6, 6); 
     DateTimeFieldType[] fields = test.getFieldTypes(); 
     assertSame(DateTimeFieldType.monthOfYear(), fields[0]); 
     assertSame(DateTimeFieldType.dayOfMonth(), fields[1]); 
     assertNotSame(test.getFieldTypes(), test.getFieldTypes()); 
 }
public void testWithField_same527() { 
     MonthDay test = new MonthDay(9, 6); 
     MonthDay result = test.withField(DateTimeFieldType.monthOfYear(), 9); 
     assertEquals(new MonthDay(9, 6), test); 
     assertSame(test, result); 
 }
public void testMinusMonths_int528() { 
     MonthDay test = new MonthDay(2, 3, ISO_UTC); 
     MonthDay result = test.minusMonths(1); 
     MonthDay expected = new MonthDay(2, 3, ISO_UTC); 
     assertEquals(expected, result); 
     result = test.minusMonths(0); 
     assertSame(test, result); 
 }
public void testMinusDays_int529() { 
     MonthDay test = new MonthDay(5, 10, BuddhistChronology.getInstance()); 
     MonthDay result = test.minusDays(1); 
     MonthDay expected = new MonthDay(5, 11, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 }
public void testMinusDays_int530() { 
     MonthDay test = new MonthDay(5, 10, BuddhistChronology.getInstance()); 
     MonthDay result = test.minusDays(1); 
     MonthDay expected = new MonthDay(5, 10, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
     result = test.minusDays(0); 
     assertSame(test, result); 
 }
public void testToString_String_Locale531() { 
     MonthDay test = new MonthDay(6, 6); 
     assertEquals("--06-06", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("--06-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("--06-06", test.toString("EEE d/M", null)); 
     assertEquals("--06-06", test.toString(null, null)); 
 }
public void testToString_String_Locale532() { 
     MonthDay test = new MonthDay(6, 6); 
     assertEquals("--06-06", test.toString("MM HH")); 
     assertEquals("--06-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("--06-06", test.toString("MM HH")); 
     assertEquals("--06-06", test.toString(null, null)); 
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
