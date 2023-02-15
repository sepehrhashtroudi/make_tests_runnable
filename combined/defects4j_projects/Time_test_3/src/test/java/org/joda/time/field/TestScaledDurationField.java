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
 * This class is a Junit unit test for PreciseDurationField.
 *
 * @author Stephen Colebourne
 */
public class TestScaledDurationField extends TestCase {
    
    private static final long LONG_INTEGER_MAX = Integer.MAX_VALUE;
    private static final int INTEGER_MAX = Integer.MAX_VALUE;
    private static final long LONG_MAX = Long.MAX_VALUE;
    
    private ScaledDurationField iField;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestScaledDurationField.class);
    }

    public TestScaledDurationField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DurationField base = MillisDurationField.INSTANCE;
        iField = new ScaledDurationField(base, DurationFieldType.minutes(), 90);
    }

    protected void tearDown() throws Exception {
        iField = null;
    }

    //-----------------------------------------------------------------------
public void test_constructor99() { 
     DurationField field = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 2); 
     assertEquals(DurationFieldType.minutes(), field.getType()); 
     try { 
         field = new ScaledDurationField(null, DurationFieldType.minutes(), 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         field = new ScaledDurationField(MillisDurationField.INSTANCE, null, 90); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         field = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.millis(), 90); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void test_getValueAsLong_long100() { 
     assertEquals(0L, iField.getValueAsLong(0L)); 
     assertEquals(12345678 / 90L, iField.getValueAsLong(12345678L)); 
     assertEquals(-1234 / 90L, iField.getValueAsLong(-1234L)); 
     assertEquals(LONG_INTEGER_MAX + 1L, iField.getValueAsLong(LONG_INTEGER_MAX * 90L + 90L)); 
 }
public void test_add_long_int101() { 
     assertEquals(567L, iField.add(567L, 0)); 
     assertEquals(567L + 1234L * 90L, iField.add(567L, 1234)); 
     assertEquals(567L - 1234L * 90L, iField.add(567L, -1234)); 
     try { 
         iField.add(LONG_MAX, 1); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
     try { 
         iField.add(1L, LONG_MAX); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_add_long_int102() { 
     assertEquals(567L, iField.add(567L, 0)); 
     assertEquals(567L + 1234L * 90L, iField.add(567L, 1234)); 
     assertEquals(567L - 1234L * 90L, iField.add(567L, -1234)); 
     try { 
         iField.add(LONG_MAX, 1); 
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
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
