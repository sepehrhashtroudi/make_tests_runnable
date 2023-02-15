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

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.Chronology;
import org.joda.time.DateTimeConstants;
import org.joda.time.DateTimeZone;
import org.joda.time.Duration;
import org.joda.time.PeriodType;
import org.joda.time.MutablePeriod;
import org.joda.time.ReadableDuration;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;

/**
 * This class is a Junit unit test for ReadableDurationConverter.
 *
 * @author Stephen Colebourne
 */
public class TestReadableDurationConverter extends TestCase {

    private static final DateTimeZone UTC = DateTimeZone.UTC;
    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final Chronology ISO_PARIS = ISOChronology.getInstance(PARIS);
    private static Chronology JULIAN;
    private static Chronology ISO;
    
    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestReadableDurationConverter.class);
    }

    public TestReadableDurationConverter(String name) {
        super(name);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        JULIAN = JulianChronology.getInstance();
        ISO = ISOChronology.getInstance();
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(PARIS);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        DateTimeZone.setDefault(zone);
    }

    //-----------------------------------------------------------------------
public void testSetIntoPeriod_Object1351() throws Exception { 
     Duration dur = new Duration(123L); 
     MutablePeriod m = new MutablePeriod(PeriodType.millis()); 
     ReadableDurationConverter.INSTANCE.setInto(m, dur, null); 
     assertEquals(0, m.getYears()); 
     assertEquals(0, m.getMonths()); 
     assertEquals(0, m.getWeeks()); 
     assertEquals(123L, m.getDays()); 
     assertEquals(0, m.getHours()); 
     assertEquals(0, m.getMinutes()); 
     assertEquals(0, m.getSeconds()); 
     assertEquals(123, m.getMillis()); 
 }
public void testSetIntoPeriod_Object1352() throws Exception { 
     Duration dur = new Duration(123L); 
     MutablePeriod m = new MutablePeriod(PeriodType.millis()); 
     ReadableDurationConverter.INSTANCE.setInto(m, dur, null); 
     assertEquals(0, m.getYears()); 
     assertEquals(0, m.getMonths()); 
     assertEquals(0, m.getWeeks()); 
     assertEquals(0, m.getDays()); 
     assertEquals(0, m.getHours()); 
     assertEquals(0, m.getMinutes()); 
     assertEquals(0, m.getSeconds()); 
     assertEquals(123, m.getMillis()); 
 }
public void testToString353() { 
     assertEquals("Converter[org.joda.time.ReadableDuration]", ReadableDurationConverter.INSTANCE.toString()); 
 }
public void testSupportedType354() throws Exception { 
     assertEquals(ReadableDuration.class, ReadableDurationConverter.INSTANCE.getSupportedType()); 
 }
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

}
