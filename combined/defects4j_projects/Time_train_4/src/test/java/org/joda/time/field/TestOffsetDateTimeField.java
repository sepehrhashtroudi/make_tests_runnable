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
package org.joda.time.field;

import java.util.Arrays;
import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.TimeOfDay;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for PreciseDateTimeField.
 *
 * @author Stephen Colebourne
 */
public class TestOffsetDateTimeField extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestOffsetDateTimeField.class);
    }

    public TestOffsetDateTimeField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------

public void test_add_long_int1232() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(1001, field.add(1L, 1)); 
 } 


public void test_add_long_long1233() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(1001, field.add(1L, 1L)); 
 } 


public void test_addWrapField_long_int1234() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(29 * 1000L, field.addWrapField(1000L * 29, 0)); 
     assertEquals(59 * 1000L, field.addWrapField(1000L * 29, 30)); 
     assertEquals(0L, field.addWrapField(1000L * 29, 31)); 
 } 


public void test_roundFloor_long1235() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(-2000L, field.roundFloor(-1001L)); 
     assertEquals(-1000L, field.roundFloor(-1000L)); 
     assertEquals(-1000L, field.roundFloor(-999L)); 
     assertEquals(-1000L, field.roundFloor(-1L)); 
     assertEquals(0L, field.roundFloor(0L)); 
     assertEquals(0L, field.roundFloor(1L)); 
     assertEquals(0L, field.roundFloor(499L)); 
     assertEquals(0L, field.roundFloor(500L)); 
     assertEquals(0L, field.roundFloor(501L)); 
     assertEquals(1000L, field.roundFloor(1000L)); 
 } 


public void test_roundCeiling_long1236() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(-1000L, field.roundCeiling(-1001L)); 
     assertEquals(-1000L, field.roundCeiling(-1000L)); 
     assertEquals(0L, field.roundCeiling(-999L)); 
     assertEquals(0L, field.roundCeiling(-1L)); 
     assertEquals(0L, field.roundCeiling(0L)); 
     assertEquals(1000L, field.roundCeiling(1L)); 
     assertEquals(1000L, field.roundCeiling(499L)); 
     assertEquals(1000L, field.roundCeiling(500L)); 
     assertEquals(1000L, field.roundCeiling(501L)); 
     assertEquals(1000L, field.roundCeiling(1000L)); 
 } 


public void test_roundHalfFloor_long1237() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(0L, field.roundHalfFloor(0L)); 
     assertEquals(0L, field.roundHalfFloor(499L)); 
     assertEquals(0L, field.roundHalfFloor(500L)); 
     assertEquals(1000L, field.roundHalfFloor(501L)); 
     assertEquals(1000L, field.roundHalfFloor(1000L)); 
 } 


public void test_roundHalfCeiling_long1238() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(0L, field.roundHalfCeiling(0L)); 
     assertEquals(0L, field.roundHalfCeiling(499L)); 
     assertEquals(1000L, field.roundHalfCeiling(500L)); 
     assertEquals(1000L, field.roundHalfCeiling(501L)); 
     assertEquals(1000L, field.roundHalfCeiling(1000L)); 
 } 


public void test_remainder_long1239() { 
     OffsetDateTimeField field = new MockOffsetDateTimeField(); 
     assertEquals(0L, field.remainder(0L)); 
     assertEquals(499L, field.remainder(499L)); 
     assertEquals(500L, field.remainder(500L)); 
     assertEquals(501L, field.remainder(501L)); 
     assertEquals(0L, field.remainder(1000L)); 
 } 


public void test_getOffset1240() { 
     OffsetDateTimeField field = new OffsetDateTimeField(ISOChronology.getInstance().secondOfMinute(), 5); 
     assertEquals(5, field.getOffset()); 
 } 

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    //------------------------------------------------------------------------
//    public abstract DurationField getDurationField();
//
//    public abstract DurationField getRangeDurationField();

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //------------------------------------------------------------------------
    

    

    

    

    

    

    //-----------------------------------------------------------------------
    static class MockOffsetDateTimeField extends OffsetDateTimeField {
        protected MockOffsetDateTimeField() {
            super(ISOChronology.getInstance().secondOfMinute(), 3);
        }
    }

    static class MockStandardDateTimeField extends MockOffsetDateTimeField {
        protected MockStandardDateTimeField() {
            super();
        }
        public DurationField getDurationField() {
            return ISOChronology.getInstanceUTC().seconds();
        }
        public DurationField getRangeDurationField() {
            return ISOChronology.getInstanceUTC().minutes();
        }
    }

}
