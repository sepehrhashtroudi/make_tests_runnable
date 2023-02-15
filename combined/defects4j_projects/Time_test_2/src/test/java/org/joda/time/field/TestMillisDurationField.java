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
public void test_getValueAsLong_long571() { 
     assertEquals(0L, MillisDurationField.INSTANCE.getValueAsLong(0L)); 
     assertEquals(1234L, MillisDurationField.INSTANCE.getValueAsLong(1234L)); 
     assertEquals(-1234L, MillisDurationField.INSTANCE.getValueAsLong(-1234L)); 
     assertEquals(((long) (Integer.MAX_VALUE)) + 1L, MillisDurationField.INSTANCE.getValueAsLong(((long) (Integer.MAX_VALUE)) + 1L)); 
 }
public void test_getDifference_long_long572() { 
     assertEquals(567L, MillisDurationField.INSTANCE.getDifference(567L, 0L)); 
     assertEquals(567L - 1234L, MillisDurationField.INSTANCE.getDifference(567L, 1234L)); 
     assertEquals(567L + 1234L, MillisDurationField.INSTANCE.getDifference(567L, -1234L)); 
     try { 
         MillisDurationField.INSTANCE.getDifference(Long.MAX_VALUE, -1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_Serialization574() throws Exception { 
     DurationField test = MillisDurationField.INSTANCE; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     DurationField result = (DurationField) ois.readObject(); 
     ois.close(); 
     assertSame(test, result); 
 }
    

    
    
    

    

    

    
    
    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
