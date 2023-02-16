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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.base.AbstractInstant;
import org.joda.time.chrono.BaseChronology;
import org.joda.time.chrono.GregorianChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

/**
 * This class is a JUnit test for MutableDateTime.
 *
 * @author Stephen Colebourne
 */
public class TestMutableDateTime_Basics extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
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
            
    // 2002-04-05
    private long TEST_TIME1 =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    // 2003-05-06
    private long TEST_TIME2 =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMutableDateTime_Basics.class);
    }

    public TestMutableDateTime_Basics(String name) {
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

public void testToString_String542() { 
     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); 
     assertEquals("2002 01", test.toString("yyyy HH")); 
     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString((String) null)); 
 } 


public void testToString_String_String543() { 
     MutableDateTime test = new MutableDateTime(TEST_TIME_NOW); 
     assertEquals("Sun 9/6", test.toString("EEE d/M", Locale.ENGLISH)); 
     assertEquals("dim. 9/6", test.toString("EEE d/M", Locale.FRENCH)); 
     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, Locale.ENGLISH)); 
     assertEquals("Sun 9/6", test.toString("EEE d/M", null)); 
     assertEquals("2002-06-09T01:00:00.000+01:00", test.toString(null, null)); 
 } 


public void testRounding8939() { 
     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); 
     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); 
     assertEquals(null, test.getRoundingField()); 
     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_CEILING); 
     assertEquals(MutableDateTime.ROUND_CEILING, test.getRoundingMode()); 
     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); 
     test.setRounding(ISOChronology.getInstance().hourOfDay(), MutableDateTime.ROUND_NONE); 
     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); 
     assertEquals(null, test.getRoundingField()); 
     test.setRounding(null, -1); 
     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); 
     assertEquals(null, test.getRoundingField()); 
     test.setRounding(ISOChronology.getInstance().hourOfDay()); 
     assertEquals(MutableDateTime.ROUND_FLOOR, test.getRoundingMode()); 
     assertEquals(ISOChronology.getInstance().hourOfDay(), test.getRoundingField()); 
     test.setRounding(null); 
     assertEquals(MutableDateTime.ROUND_NONE, test.getRoundingMode()); 
     assertEquals(null, test.getRoundingField()); 
 } 


public void testToDateTime_DateTimeZone1003() { 
     MutableDateTime test = new MutableDateTime(TEST_TIME1); 
     MutableDateTime result = test.toMutableDateTime(LONDON); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(test.getChronology(), result.getChronology()); 
     assertEquals(LONDON, result.getZone()); 
     test = new MutableDateTime(TEST_TIME1); 
     result = test.toMutableDateTime(PARIS); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(PARIS, result.getZone()); 
     test = new MutableDateTime(TEST_TIME1, GregorianChronology.getInstance(PARIS)); 
     result = test.toMutableDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(GregorianChronology.getInstance(LONDON), result.getChronology()); 
     test = new MutableDateTime(TEST_TIME1, PARIS); 
     result = test.toMutableDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(LONDON, result.getZone()); 
     test = new MutableDateTime(TEST_TIME1); 
     result = test.toMutableDateTime((DateTimeZone) null); 
     assertEquals(test.getMillis(), result.getMillis()); 
     assertEquals(LONDON, result.getZone()); 
     assertEquals(ISOChronology.getInstance(), result.getChronology()); 
 } 


public void testRounding71008() { 
     MutableDateTime test = new MutableDateTime(2002, 6, 9, 5, 6, 7, 8); 
     try { 
         test.setRounding(ISOChronology.getInstance().hourOfDay(), -1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testProperty1044() { 
     MutableDateTime test = new MutableDateTime(); 
     assertEquals(test.year(), test.property(DateTimeFieldType.year())); 
     assertEquals(test.dayOfWeek(), test.property(DateTimeFieldType.dayOfWeek())); 
     assertEquals(test.secondOfMinute(), test.property(DateTimeFieldType.secondOfMinute())); 
     assertEquals(test.millisOfSecond(), test.property(DateTimeFieldType.millisOfSecond())); 
     DateTimeFieldType bad = new DateTimeFieldType("bad") { 
  
         private static final long serialVersionUID = 1L; 
  
         public DurationFieldType getDurationType() { 
             return DurationFieldType.weeks(); 
         } 
  
         public DurationFieldType getRangeDurationType() { 
             return null; 
         } 
  
         public DateTimeField getField(Chronology chronology) { 
             return UnsupportedDateTimeField.getInstance(this, UnsupportedDurationField.getInstance(getDurationType())); 
         } 
     }; 
     try { 
         test.property(bad); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.property(null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testCopy1059() { 
     MutableDateTime test = new MutableDateTime(TEST_TIME1); 
     MutableDateTime result = test.copy(); 
     assertEquals(true, test.equals(result)); 
     assertEquals(true, test != result); 
 } 


public void testClone1060() { 
     MutableDateTime test = new MutableDateTime(TEST_TIME1); 
     MutableDateTime result = (MutableDateTime) test.clone(); 
     assertEquals(true, test.equals(result)); 
     assertEquals(true, test != result); 
 } 


public void testCompareTo1409() { 
     MutableDateTime test1 = new MutableDateTime(TEST_TIME1); 
     MutableDateTime test1a = new MutableDateTime(TEST_TIME1); 
     assertEquals(0, test1.compareTo(test1a)); 
     assertEquals(0, test1a.compareTo(test1)); 
     assertEquals(0, test1.compareTo(test1)); 
     assertEquals(0, test1a.compareTo(test1a)); 
     MutableDateTime test2 = new MutableDateTime(TEST_TIME2); 
     assertEquals(-1, test1.compareTo(test2)); 
     assertEquals(+1, test2.compareTo(test1)); 
     MutableDateTime test3 = new MutableDateTime(TEST_TIME2, GregorianChronology.getInstance(PARIS)); 
     assertEquals(-1, test1.compareTo(test3)); 
     assertEquals(+1, test3.compareTo(test1)); 
     assertEquals(0, test3.compareTo(test2)); 
     assertEquals(+1, test2.compareTo(new MockInstant())); 
     assertEquals(0, test1.compareTo(new MockInstant())); 
     try { 
         test1.compareTo(null); 
         fail(); 
     } catch (NullPointerException ex) { 
     } 
 } 

    

    //-----------------------------------------------------------------------
    

    

    

    
    
    class MockInstant extends AbstractInstant {
        public String toString() {
            return null;
        }
        public long getMillis() {
            return TEST_TIME1;
        }
        public Chronology getChronology() {
            return ISOChronology.getInstance();
        }
    }

    class MockEqualsChronology extends BaseChronology {
        private static final long serialVersionUID = 1L;
        public boolean equals(Object obj) {
            return obj instanceof MockEqualsChronology;
        }
        public DateTimeZone getZone() {
            return null;
        }
        public Chronology withUTC() {
            return this;
        }
        public Chronology withZone(DateTimeZone zone) {
            return this;
        }
        public String toString() {
            return "";
        }
    }

    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
