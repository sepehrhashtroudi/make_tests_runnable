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

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.GJChronology;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.field.FieldUtils;
import org.joda.time.field.SkipDateTimeField;

/**
 * Tests IllegalFieldValueException by triggering it from other methods.
 *
 * @author Brian S O'Neill
 */
public class TestIllegalFieldValueException extends TestCase {
    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestIllegalFieldValueException.class);
    }

    public TestIllegalFieldValueException(String name) {
        super(name);
    }

public void testOtherConstructors414() { 
     IllegalFieldValueException e = new IllegalFieldValueException(DurationFieldType.days(), new Integer(1), new Integer(2), new Integer(3)); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.days(), e.getDurationFieldType()); 
     assertEquals("days", e.getFieldName()); 
     assertEquals(new Integer(1), e.getIllegalNumberValue()); 
     assertEquals(null, e.getIllegalStringValue()); 
     assertEquals("1", e.getIllegalValueAsString()); 
     assertEquals(new Integer(2), e.getLowerBound()); 
     assertEquals(new Integer(3), e.getUpperBound()); 
     e = new IllegalFieldValueException(DurationFieldType.months(), "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.months(), e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
     e = new IllegalFieldValueException("months", "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(null, e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
 }
public void testFieldName416() { 
     IllegalFieldValueException e = new IllegalFieldValueException(DurationFieldType.days(), new Integer(1), new Integer(2), new Integer(3)); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.days(), e.getDurationFieldType()); 
     assertEquals("days", e.getFieldName()); 
     assertEquals(new Integer(1), e.getIllegalNumberValue()); 
     assertEquals(null, e.getIllegalStringValue()); 
     assertEquals("1", e.getIllegalValueAsString()); 
     assertEquals(new Integer(2), e.getLowerBound()); 
     assertEquals(new Integer(3), e.getUpperBound()); 
     e = new IllegalFieldValueException(DurationFieldType.months(), "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.months(), e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
     e = new IllegalFieldValueException("months", "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(null, e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
 }
public void testNumberValue417() { 
     IllegalFieldValueException e = new IllegalFieldValueException(DurationFieldType.days(), new Integer(1), new Integer(2), new Integer(3)); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.days(), e.getDurationFieldType()); 
     assertEquals("days", e.getFieldName()); 
     assertEquals(new Integer(1), e.getIllegalNumberValue()); 
     assertEquals(null, e.getIllegalStringValue()); 
     assertEquals("1", e.getIllegalValueAsString()); 
     assertEquals(new Integer(2), e.getLowerBound()); 
     assertEquals(new Integer(3), e.getUpperBound()); 
     e = new IllegalFieldValueException(DurationFieldType.months(), "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(DurationFieldType.months(), e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
     e = new IllegalFieldValueException("months", "five"); 
     assertEquals(null, e.getDateTimeFieldType()); 
     assertEquals(null, e.getDurationFieldType()); 
     assertEquals("months", e.getFieldName()); 
     assertEquals(null, e.getIllegalNumberValue()); 
     assertEquals("five", e.getIllegalStringValue()); 
     assertEquals("five", e.getIllegalValueAsString()); 
     assertEquals(null, e.getLowerBound()); 
     assertEquals(null, e.getUpperBound()); 
 }
    

    

    

    

    

    

    

    // Test extra constructors not currently called by anything
    
}
