/*
 *  Copyright 2001-2009 Stephen Colebourne
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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DurationField;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.ISOChronology;

/**
 * This class is a Junit unit test for PeriodFormatterBuilder.
 *
 * @author Stephen Colebourne
 */
public class TestMillisDurationField extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestMillisDurationField.class);
    }

    public TestMillisDurationField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void test_toString548() { 
     assertEquals("millis", MillisDurationField.INSTANCE.toString()); 
 }
public void test_isPrecise549() { 
     assertEquals(true, MillisDurationField.INSTANCE.isPrecise()); 
 }
public void test_getValue_long550() { 
     assertEquals(0, MillisDurationField.INSTANCE.getValue(0L)); 
     assertEquals(1234, MillisDurationField.INSTANCE.getValue(1234L)); 
     assertEquals(-1234, MillisDurationField.INSTANCE.getValue(-1234L)); 
     try { 
         MillisDurationField.INSTANCE.getValue(((long) (Integer.MAX_VALUE)) + 1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_getMillis_int551() { 
     assertEquals(0, MillisDurationField.INSTANCE.getMillis(0)); 
     assertEquals(1234, MillisDurationField.INSTANCE.getMillis(1234)); 
     assertEquals(-1234, MillisDurationField.INSTANCE.getMillis(-1234)); 
 }
public void test_getMillis_long552() { 
     assertEquals(0L, MillisDurationField.INSTANCE.getMillis(0L)); 
     assertEquals(1234L, MillisDurationField.INSTANCE.getMillis(1234L)); 
     assertEquals(-1234L, MillisDurationField.INSTANCE.getMillis(-1234L)); 
 }
public void test_add_long_int553() { 
     assertEquals(567L, MillisDurationField.INSTANCE.add(567L, 0)); 
     assertEquals(567L + 1234L, MillisDurationField.INSTANCE.add(567L, 1234)); 
     assertEquals(567L - 1234L, MillisDurationField.INSTANCE.add(567L, -1234)); 
     try { 
         MillisDurationField.INSTANCE.add(Long.MAX_VALUE, 1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_getDifferenceAsLong_long_long554() { 
     assertEquals(567L, MillisDurationField.INSTANCE.getDifferenceAsLong(567L, 0L)); 
     assertEquals(567L - 1234L, MillisDurationField.INSTANCE.getDifferenceAsLong(567L, 1234L)); 
     assertEquals(567L + 1234L, MillisDurationField.INSTANCE.getDifferenceAsLong(567L, -1234L)); 
     try { 
         MillisDurationField.INSTANCE.getDifferenceAsLong(Long.MAX_VALUE, 1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
    

    
    
    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
