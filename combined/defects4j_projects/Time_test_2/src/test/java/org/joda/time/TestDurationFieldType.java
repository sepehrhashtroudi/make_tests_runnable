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
package org.joda.time;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.CopticChronology;

/**
 * This class is a Junit unit test for DurationFieldType.
 *
 * @author Stephen Colebourne
 */
public class TestDurationFieldType extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDurationFieldType.class);
    }

    public TestDurationFieldType(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testIsSupported_DurationFieldType417() { 
     LocalDate test = new LocalDate(1970, 6, 9); 
     assertEquals(false, test.isSupported(DurationFieldType.eras())); 
     assertEquals(true, test.isSupported(DurationFieldType.centuries())); 
     assertEquals(true, test.isSupported(DurationFieldType.years())); 
     assertEquals(true, test.isSupported(DurationFieldType.months())); 
     assertEquals(true, test.isSupported(DurationFieldType.weekyears())); 
     assertEquals(true, test.isSupported(DurationFieldType.weeks())); 
     assertEquals(true, test.isSupported(DurationFieldType.days())); 
     assertEquals(false, test.isSupported(DurationFieldType.hours())); 
     assertEquals(false, test.isSupported((DurationFieldType) null)); 
 }
public void testWithFieldAdded_DurationFieldType_int_8418() { 
     LocalTime test = new LocalTime(0, 0, 0, 0); 
     LocalTime result = test.withFieldAdded(DurationFieldType.millis(), -1); 
     assertEquals(new LocalTime(23, 59, 59, 999), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.seconds(), -1); 
     assertEquals(new LocalTime(23, 59, 59, 0), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.minutes(), -1); 
     assertEquals(new LocalTime(23, 59, 0, 0), result); 
     test = new LocalTime(0, 0, 0, 0); 
     result = test.withFieldAdded(DurationFieldType.hours(), -1); 
     assertEquals(new LocalTime(23, 0, 0, 0), result); 
 }
public void test_centuries419() throws Exception { 
     assertEquals(DurationFieldType.centuries(), DurationFieldType.centuries()); 
     assertEquals("centuries", DurationFieldType.centuries().getName()); 
     assertEquals(CopticChronology.getInstanceUTC().centuries(), DurationFieldType.centuries().getField(CopticChronology.getInstanceUTC())); 
     assertEquals(CopticChronology.getInstanceUTC().centuries().isSupported(), DurationFieldType.centuries().isSupported(CopticChronology.getInstanceUTC())); 
     assertSerialization(DurationFieldType.centuries()); 
 }
public void test_weeks420() throws Exception { 
     assertEquals(DurationFieldType.weeks(), DurationFieldType.weeks()); 
     assertEquals("weeks", DurationFieldType.weeks().getName()); 
     assertEquals(CopticChronology.getInstanceUTC().weeks(), DurationFieldType.weeks().getField(CopticChronology.getInstanceUTC())); 
     assertEquals(CopticChronology.getInstanceUTC().weeks().isSupported(), DurationFieldType.weeks().isSupported(CopticChronology.getInstanceUTC())); 
     assertSerialization(DurationFieldType.weeks()); 
 }
public void test_seconds421() throws Exception { 
     assertEquals(DurationFieldType.seconds(), DurationFieldType.seconds()); 
     assertEquals("seconds", DurationFieldType.seconds().getName()); 
     assertEquals(CopticChronology.getInstanceUTC().seconds(), DurationFieldType.seconds().getField(CopticChronology.getInstanceUTC())); 
     assertEquals(CopticChronology.getInstanceUTC().seconds().isSupported(), DurationFieldType.seconds().isSupported(CopticChronology.getInstanceUTC())); 
     assertSerialization(DurationFieldType.seconds()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    private void assertSerialization(DurationFieldType type) throws Exception {
        DurationFieldType result = doSerialization(type);
        assertSame(type, result);
    }

    private DurationFieldType doSerialization(DurationFieldType type) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(type);
        byte[] bytes = baos.toByteArray();
        oos.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        DurationFieldType result = (DurationFieldType) ois.readObject();
        ois.close();
        return result;
    }

}
