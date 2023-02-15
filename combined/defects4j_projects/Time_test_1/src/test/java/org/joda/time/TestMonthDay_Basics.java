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
public void testFormat_unknownString542() { 
     try { 
         DateTimeFormat.forPattern(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeFormat.forPattern(""); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeFormat.forPattern("A"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeFormat.forPattern("dd/mm/AA"); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertySetMonthOfYear630() { 
     MonthDay test = new MonthDay(10, 6); 
     MonthDay copy = test.monthOfYear().setCopy(12); 
     check(test, 10, 6); 
     check(copy, 12, 6); 
 }
public void testPlusMonths_int631() { 
     MonthDay test = new MonthDay(6, 5, BuddhistChronology.getInstance()); 
     MonthDay result = test.plusMonths(1); 
     MonthDay expected = new MonthDay(8, 9, BuddhistChronology.getInstance()); 
     assertEquals(expected, result); 
 }
public void testPropertySetDayOfMonth637() { 
     MonthDay test = new MonthDay(4, 6); 
     MonthDay copy = test.dayOfMonth().setCopy(12); 
     check(test, 4, 6); 
     check(copy, 4, 12); 
     copy = test.dayOfMonth().setCopy(13); 
     check(copy, 4, 13); 
     copy = test.dayOfMonth().setCopy(14); 
     check(copy, 4, 4); 
     copy = test.dayOfMonth().setCopy(-12); 
     check(copy, 4, 4); 
 }
public void testToString_String638() { 
     MonthDay test = new MonthDay(5, 6); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("--05-06", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 6/5", test.toString("EEE d/M", null)); 
     assertEquals("--05-06", test.toString(null, null)); 
 }
public void testPropertyGetDayOfMonth639() { 
     MonthDay test = new MonthDay(4, 6); 
     assertSame(test.getChronology().dayOfMonth(), test.dayOfMonth().getField()); 
     assertEquals("dayOfMonth", test.dayOfMonth().getName()); 
     assertEquals("Property[dayOfMonth]", test.dayOfMonth().toString()); 
     assertSame(test, test.dayOfMonth().getReadablePartial()); 
     assertSame(test, test.dayOfMonth().getMonthDay()); 
     assertEquals(6, test.dayOfMonth().get()); 
     assertEquals("6", test.dayOfMonth().getAsString()); 
     assertEquals("6", test.dayOfMonth().getAsText()); 
     assertEquals("6", test.dayOfMonth().getAsText(Locale.FRENCH)); 
     assertEquals("6", test.dayOfMonth().getAsShortText()); 
     assertEquals("6", test.dayOfMonth().getAsShortText(Locale.FRENCH)); 
     assertEquals(test.getChronology().days(), test.dayOfMonth().getDurationField()); 
     assertEquals(test.getChronology().months(), test.dayOfMonth().getRangeDurationField()); 
     assertEquals(2, test.dayOfMonth().getMaximumTextLength(null)); 
     assertEquals(2, test.dayOfMonth().getMaximumShortTextLength(null)); 
     test = new MonthDay(4, 7); 
     assertEquals("7", test.dayOfMonth().getAsText(Locale.FRENCH)); 
     assertEquals("7", test.dayOfMonth().getAsShortText(Locale.FRENCH)); 
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
