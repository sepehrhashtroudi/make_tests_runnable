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
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a Junit unit test for Partial.
 *
 * @author Stephen Colebourne
 */
public class TestPartial_Basics extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final DateTimeZone TOKYO = DateTimeZone.forID("Asia/Tokyo");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);
    private static final Chronology COPTIC_TOKYO = CopticChronology.getInstance(TOKYO);
    private static final Chronology COPTIC_UTC = CopticChronology.getInstanceUTC();
    private static final Chronology ISO_UTC = ISOChronology.getInstanceUTC();
    private static final Chronology BUDDHIST_LONDON = BuddhistChronology.getInstance(LONDON);
    private static final Chronology BUDDHIST_TOKYO = BuddhistChronology.getInstance(TOKYO);
    private static final Chronology BUDDHIST_UTC = BuddhistChronology.getInstanceUTC();
    
    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;
    private long TEST_TIME2 =
        1L * DateTimeConstants.MILLIS_PER_DAY
        + 5L * DateTimeConstants.MILLIS_PER_HOUR
        + 6L * DateTimeConstants.MILLIS_PER_MINUTE
        + 7L * DateTimeConstants.MILLIS_PER_SECOND
        + 8L;
        
    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPartial_Basics.class);
    }

    public TestPartial_Basics(String name) {
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
public void testWithField1253() { 
     Partial test = createHourMinPartial(); 
     Partial result = test.withField(DateTimeFieldType.hourOfDay(), 15); 
     check(test, 10, 20); 
     check(result, 15, 20); 
 }
public void testToString2265() { 
     Partial test = new Partial(); 
     assertEquals("[]", test.toString()); 
 }
public void testWith3f266() { 
     Partial test = new Partial(DateTimeFieldType.halfdayOfDay(), 0); 
     Partial result = test.with(DateTimeFieldType.era(), 1); 
     assertEquals(2, result.size()); 
     assertEquals(1, result.get(DateTimeFieldType.era())); 
     assertEquals(0, result.get(DateTimeFieldType.halfdayOfDay())); 
     assertEquals(0, result.indexOf(DateTimeFieldType.era())); 
     assertEquals(1, result.indexOf(DateTimeFieldType.halfdayOfDay())); 
 }
public void testToString_String268() { 
     Partial test = new Partial(DateTimeFieldType.year(), 2005); 
     assertEquals("2005", test.toString("yyyy HH")); 
     assertEquals("2005-06", test.toString((String) null)); 
 }
public void testToString_String_Locale269() { 
     Partial test = new Partial(DateTimeFieldType.year(), 2005); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2005-06-09", test.toString(null, Locale.ENGLISH)); 
     assertEquals("\ufffd 9/6", test.toString("EEE d/M", null)); 
     assertEquals("2005-06-09", test.toString(null, null)); 
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
    private Partial createHourMinPartial() {
        return createHourMinPartial(ISO_UTC);
    }

    private Partial createHourMinPartial(Chronology chrono) {
        return createHourMinPartial(10, 20, chrono);
    }

    private Partial createHourMinPartial2(Chronology chrono) {
        return createHourMinPartial(15, 20, chrono);
    }

    private Partial createHourMinPartial(int hour, int min, Chronology chrono) {
        return new Partial(
            new DateTimeFieldType[] {DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour()},
            new int[] {hour, min},
            chrono);
    }

    private Partial createTODPartial(Chronology chrono) {
        return new Partial(
            new DateTimeFieldType[] {
                    DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(),
                    DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond()},
            new int[] {10, 20, 30, 40},
            chrono);
    }

    private void check(Partial test, int hour, int min) {
        assertEquals(test.toString(), hour, test.get(DateTimeFieldType.hourOfDay()));
        assertEquals(test.toString(), min, test.get(DateTimeFieldType.minuteOfHour()));
    }
}
