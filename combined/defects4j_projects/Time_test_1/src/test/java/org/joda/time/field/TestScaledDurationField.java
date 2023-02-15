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
public void test_getValue_long_long101() { 
     assertEquals(0, iField.getValue(0L, 567L)); 
     assertEquals(12345678 / 90, iField.getValue(12345678L, 567L)); 
     assertEquals(-1234 / 90, iField.getValue(-1234L, 567L)); 
     assertEquals(INTEGER_MAX / 90, iField.getValue(LONG_INTEGER_MAX * 90L + 999L, 567L)); 
     try { 
         iField.getValue(LONG_INTEGER_MAX * 90L + 1000L, 567L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_getMillis_long_long102() { 
     assertEquals(0L, iField.getMillis(0L, 567L)); 
     assertEquals(1234L * 90L, iField.getMillis(1234L, 567L)); 
     assertEquals(-1234L * 90L, iField.getMillis(-1234L, 567L)); 
     try { 
         iField.getMillis(LONG_MAX, 567L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_equals103() { 
     assertEquals(true, iField.equals(iField)); 
     assertEquals(false, iField.equals(ISOChronology.getInstance().minutes())); 
     DurationField dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 2); 
     assertEquals(false, iField.equals(dummy)); 
     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.minutes(), 90); 
     assertEquals(true, iField.equals(dummy)); 
     dummy = new ScaledDurationField(MillisDurationField.INSTANCE, DurationFieldType.millis(), 90); 
     assertEquals(false, iField.equals(dummy)); 
     assertEquals(false, iField.equals("")); 
     assertEquals(false, iField.equals(null)); 
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
