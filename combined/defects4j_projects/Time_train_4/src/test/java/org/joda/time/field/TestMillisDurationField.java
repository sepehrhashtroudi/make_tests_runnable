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

public void test_getType1356() { 
     assertEquals(DurationFieldType.millis(), MillisDurationField.INSTANCE.getType()); 
 } 


public void test_isSupported1357() { 
     assertEquals(true, MillisDurationField.INSTANCE.isSupported()); 
 } 


public void test_compareTo1358() { 
     assertEquals(0, MillisDurationField.INSTANCE.compareTo(MillisDurationField.INSTANCE)); 
     assertEquals(-1, MillisDurationField.INSTANCE.compareTo(ISOChronology.getInstance().seconds())); 
     DurationField dummy = new PreciseDurationField(DurationFieldType.seconds(), 0); 
     assertEquals(1, MillisDurationField.INSTANCE.compareTo(dummy)); 
     try { 
         MillisDurationField.INSTANCE.compareTo(null); 
         fail(); 
     } catch (NullPointerException ex) { 
     } 
 } 


public void test_getValueAsLong_long1359() { 
     assertEquals(0L, MillisDurationField.INSTANCE.getValueAsLong(0L)); 
     assertEquals(1234L, MillisDurationField.INSTANCE.getValueAsLong(1234L)); 
     assertEquals(-1234L, MillisDurationField.INSTANCE.getValueAsLong(-1234L)); 
     assertEquals(((long) (Integer.MAX_VALUE)) + 1L, MillisDurationField.INSTANCE.getValueAsLong(((long) (Integer.MAX_VALUE)) + 1L)); 
 } 


public void test_getValue_long_long1360() { 
     assertEquals(0, MillisDurationField.INSTANCE.getValue(0L, 567L)); 
     assertEquals(1234, MillisDurationField.INSTANCE.getValue(1234L, 567L)); 
     assertEquals(-1234, MillisDurationField.INSTANCE.getValue(-1234L, 567L)); 
     try { 
         MillisDurationField.INSTANCE.getValue(((long) (Integer.MAX_VALUE)) + 1L, 567L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void test_getValueAsLong_long_long1361() { 
     assertEquals(0L, MillisDurationField.INSTANCE.getValueAsLong(0L, 567L)); 
     assertEquals(1234L, MillisDurationField.INSTANCE.getValueAsLong(1234L, 567L)); 
     assertEquals(-1234L, MillisDurationField.INSTANCE.getValueAsLong(-1234L, 567L)); 
     assertEquals(((long) (Integer.MAX_VALUE)) + 1L, MillisDurationField.INSTANCE.getValueAsLong(((long) (Integer.MAX_VALUE)) + 1L, 567L)); 
 } 


public void test_getMillis_int_long1362() { 
     assertEquals(0, MillisDurationField.INSTANCE.getMillis(0, 567L)); 
     assertEquals(1234, MillisDurationField.INSTANCE.getMillis(1234, 567L)); 
     assertEquals(-1234, MillisDurationField.INSTANCE.getMillis(-1234, 567L)); 
 } 


public void test_getMillis_long_long1363() { 
     assertEquals(0L, MillisDurationField.INSTANCE.getMillis(0L, 567L)); 
     assertEquals(1234L, MillisDurationField.INSTANCE.getMillis(1234L, 567L)); 
     assertEquals(-1234L, MillisDurationField.INSTANCE.getMillis(-1234L, 567L)); 
 } 


public void test_add_long_long1364() { 
     assertEquals(567L, MillisDurationField.INSTANCE.add(567L, 0L)); 
     assertEquals(567L + 1234L, MillisDurationField.INSTANCE.add(567L, 1234L)); 
     assertEquals(567L - 1234L, MillisDurationField.INSTANCE.add(567L, -1234L)); 
     try { 
         MillisDurationField.INSTANCE.add(Long.MAX_VALUE, 1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void test_getDifference_long_int1365() { 
     assertEquals(567, MillisDurationField.INSTANCE.getDifference(567L, 0L)); 
     assertEquals(567 - 1234, MillisDurationField.INSTANCE.getDifference(567L, 1234L)); 
     assertEquals(567 + 1234, MillisDurationField.INSTANCE.getDifference(567L, -1234L)); 
     try { 
         MillisDurationField.INSTANCE.getDifference(Long.MAX_VALUE, 1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 } 


public void test_toString1367() { 
     assertEquals("DurationField[millis]", MillisDurationField.INSTANCE.toString()); 
 } 


public void testSerialization1368() throws Exception { 
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
