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

import org.joda.time.Chronology;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.TimeOfDay;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for BaseDateTimeField.
 *
 * @author Stephen Colebourne
 */
public class TestBaseDateTimeField extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestBaseDateTimeField.class);
    }

    public TestBaseDateTimeField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void test_getType152() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(DateTimeFieldType.secondOfMinute(), field.getType()); 
 }
public void test_getAsText_long_Locale153() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("29", field.getAsText(60L * 29, Locale.ENGLISH)); 
     assertEquals("29", field.getAsText(60L * 29, null)); 
 }
public void test_getAsText_long154() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("29", field.getAsText(60L * 29)); 
 }
public void test_getAsText_int_Locale155() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("20", field.getAsText(20, Locale.ENGLISH)); 
     assertEquals("20", field.getAsText(20, null)); 
 }
public void test_getAsShortText_RP_int_Locale156() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("20", field.getAsShortText(new TimeOfDay(12, 30, 40, 50), 20, Locale.ENGLISH)); 
     assertEquals("20", field.getAsShortText(new TimeOfDay(12, 30, 40, 50), 20, null)); 
 }
public void test_getAsShortText_RP_Locale157() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("40", field.getAsShortText(new TimeOfDay(12, 30, 40, 50), Locale.ENGLISH)); 
     assertEquals("40", field.getAsShortText(new TimeOfDay(12, 30, 40, 50), null)); 
 }
public void test_getAsShortText_int_Locale158() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals("20", field.getAsShortText(20, Locale.ENGLISH)); 
     assertEquals("20", field.getAsShortText(20, null)); 
 }
public void test_roundCeiling_long159() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(0L, field.roundCeiling(0L)); 
     assertEquals(60L, field.roundCeiling(29L)); 
     assertEquals(60L, field.roundCeiling(30L)); 
     assertEquals(60L, field.roundCeiling(31L)); 
     assertEquals(60L, field.roundCeiling(60L)); 
 }
public void test_set_long_String160() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(1000, field.set(0L, "0")); 
     assertEquals(1029, field.set(0L, "29")); 
 }
public void test_convertText_String_Locale163() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(5, field.convertText("5", Locale.ENGLISH)); 
     assertEquals(1, field.convertText("1", null)); 
 }
public void test_getMaximumValue_long164() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(59, field.getMaximumValue(0L)); 
 }
public void test_roundHalfCeiling_long165() { 
     BaseDateTimeField field = new MockBaseDateTimeField(); 
     assertEquals(0L, field.roundHalfCeiling(0L)); 
     assertEquals(0L, field.roundHalfCeiling(29L)); 
     assertEquals(0L, field.roundHalfCeiling(30L)); 
     assertEquals(60L, field.roundHalfCeiling(31L)); 
     assertEquals(60L, field.roundHalfCeiling(60L)); 
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
    static class MockBaseDateTimeField extends BaseDateTimeField {
        protected MockBaseDateTimeField() {
            super(DateTimeFieldType.secondOfMinute());
        }
        protected MockBaseDateTimeField(DateTimeFieldType type) {
            super(type);
        }
        public int get(long instant) {
            return (int) (instant / 60L);
        }
        public long set(long instant, int value) {
            return 1000 + value;
        }
        public DurationField getDurationField() {
            return new MockCountingDurationField(DurationFieldType.seconds());
        }
        public DurationField getRangeDurationField() {
            return new MockCountingDurationField(DurationFieldType.minutes());
        }
        public int getMinimumValue() {
            return 0;
        }
        public int getMaximumValue() {
            return 59;
        }
        public long roundFloor(long instant) {
            return (instant / 60L) * 60L;
        }
        public boolean isLenient() {
            return false;
        }
    }

    static class MockStandardBaseDateTimeField extends MockBaseDateTimeField {
        protected MockStandardBaseDateTimeField() {
            super();
        }
        public DurationField getDurationField() {
            return ISOChronology.getInstanceUTC().seconds();
        }
        public DurationField getRangeDurationField() {
            return ISOChronology.getInstanceUTC().minutes();
        }
    }

    //-----------------------------------------------------------------------
    static class MockCountingDurationField extends BaseDurationField {
        static int add_int = 0;
        static int add_long = 0;
        static int difference_long = 0;
        
        protected MockCountingDurationField(DurationFieldType type) {
            super(type);
        }
        public boolean isPrecise() {
            return false;
        }
        public long getUnitMillis() {
            return 0;
        }
        public long getValueAsLong(long duration, long instant) {
            return 0;
        }
        public long getMillis(int value, long instant) {
            return 0;
        }
        public long getMillis(long value, long instant) {
            return 0;
        }
        public long add(long instant, int value) {
            add_int++;
            return instant + (value * 60L);
        }
        public long add(long instant, long value) {
            add_long++;
            return instant + (value * 60L);
        }
        public long getDifferenceAsLong(long minuendInstant, long subtrahendInstant) {
            difference_long++;
            return 30;
        }
    }

    static class MockPartial extends BasePartial {
        protected DateTimeField getField(int index, Chronology chrono) {
            if (index == 0) {
                return ISOChronology.getInstanceUTC().minuteOfHour();
            }
            if (index == 1) {
                return ISOChronology.getInstanceUTC().millisOfSecond();
            }
            return null;
        }
        public int size() {
            return 2;
        }
        
    }
}
