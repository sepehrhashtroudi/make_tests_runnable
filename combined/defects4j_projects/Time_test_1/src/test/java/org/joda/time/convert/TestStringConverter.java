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
package org.joda.time.convert;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.MutableInterval;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;
import org.joda.time.TimeOfDay;
import org.joda.time.chrono.BuddhistChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

/**
 * This class is a Junit unit test for StringConverter.
 *
 * @author Stephen Colebourne
 */
public class TestStringConverter extends TestCase {

    private static final DateTimeZone ONE_HOUR = DateTimeZone.forOffsetHours(1);
    private static final DateTimeZone SIX = DateTimeZone.forOffsetHours(6);
    private static final DateTimeZone SEVEN = DateTimeZone.forOffsetHours(7);
    private static final DateTimeZone EIGHT = DateTimeZone.forOffsetHours(8);
    private static final DateTimeZone UTC = DateTimeZone.UTC;
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    private static final Chronology ISO_EIGHT = ISOChronology.getInstance(EIGHT);
    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static final Chronology ISO_LONDON = ISOChronology.getInstance(LONDON);
    private static Chronology ISO;
    private static Chronology JULIAN;
    
    private DateTimeZone zone = null;
    private Locale locale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestStringConverter.class);
    }

    public TestStringConverter(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        zone = DateTimeZone.getDefault();
        locale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
        Locale.setDefault(Locale.UK);
        
        JULIAN = JulianChronology.getInstance();
        ISO = ISOChronology.getInstance();
    }

    protected void tearDown() throws Exception {
        DateTimeZone.setDefault(zone);
        Locale.setDefault(locale);
        zone = null;
    }

    //-----------------------------------------------------------------------
public void testGetInstantMillis_Object_Chronology38() throws Exception { 
     assertEquals(123L, StringConverter.INSTANCE.getInstantMillis("PT12.345S", JULIAN)); 
     assertEquals(123L, StringConverter.INSTANCE.getInstantMillis("PT12.345s", (Chronology) null)); 
 }
public void testGetInstantMillis_Object_Chronology39() throws Exception { 
     long millis = StringConverter.INSTANCE.getInstantMillis("PT12.345S", JULIAN); 
     assertEquals(12345, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT12.345s", (Chronology) null); 
     assertEquals(12345, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT12s", (Chronology) null); 
     assertEquals(12000, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT12.s", (Chronology) null); 
     assertEquals(12000, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT-12.32s", (Chronology) null); 
     assertEquals(-12320, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT-0.32s", (Chronology) null); 
     assertEquals(-320, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT-0.0s", (Chronology) null); 
     assertEquals(0, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT0.0s", (Chronology) null); 
     assertEquals(0, millis); 
     millis = StringConverter.INSTANCE.getInstantMillis("PT12.3456s", (Chronology) null); 
     assertEquals(12345, millis); 
 }
public void testGetDurationMillis_Object141() throws Exception { 
     long millis = StringConverter.INSTANCE.getDurationMillis("PT12.345S"); 
     assertEquals(12345, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt12.345s"); 
     assertEquals(12345, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt12s"); 
     assertEquals(12000, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt12.s"); 
     assertEquals(12000, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt-12.32s"); 
     assertEquals(-12320, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt-0.32s"); 
     assertEquals(-320, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt-0.0s"); 
     assertEquals(0, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt0.0s"); 
     assertEquals(0, millis); 
     millis = StringConverter.INSTANCE.getDurationMillis("pt12.3456s"); 
     assertEquals(12345, millis); 
 }
public void testSetIntoPeriod_Object842() throws Exception { 
     MutablePeriod m = new MutablePeriod(); 
     try { 
         StringConverter.INSTANCE.setInto(m, "", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "PXY", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "PT0SXY", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "P2Y4W3DT12H24M48SX", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSetIntoIntervalEx_Object_Chronology143() throws Exception { 
     MutableInterval m = new MutableInterval(-1000L, 1000L); 
     try { 
         StringConverter.INSTANCE.setInto(m, "P1Y/", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSetIntoIntervalEx_Object_Chronology144() throws Exception { 
     MutableInterval m = new MutableInterval(-1000L, 1000L); 
     try { 
         StringConverter.INSTANCE.setInto(m, "", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSetIntoIntervalEx_Object_Chronology345() throws Exception { 
     MutableInterval m = new MutableInterval(-1000L, 1000L); 
     try { 
         StringConverter.INSTANCE.setInto(m, "P1Y/", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSetIntoInterval_Object846() throws Exception { 
     MutableInterval m = new MutableInterval(-1000L, 1000L); 
     try { 
         StringConverter.INSTANCE.setInto(m, "", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "P1Y/", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "PT0SXY", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "P1MT0H0M", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testSetIntoInterval_Object847() throws Exception { 
     MutableInterval m = new MutableInterval(-1000L, 1000L); 
     try { 
         StringConverter.INSTANCE.setInto(m, "", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "PXY", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "PT0SXY", null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         StringConverter.INSTANCE.setInto(m, "P2Y4W3DT12H24M48SX", null); 
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
    

    

            

            

            

            

            

            

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

}
