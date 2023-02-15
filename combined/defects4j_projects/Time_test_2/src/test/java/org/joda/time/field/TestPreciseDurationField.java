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
public class TestPreciseDurationField extends TestCase {
    
    private static final long LONG_INTEGER_MAX = Integer.MAX_VALUE;
    private static final int INTEGER_MAX = Integer.MAX_VALUE;
    private static final long LONG_MAX = Long.MAX_VALUE;
    
    private PreciseDurationField iField;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPreciseDurationField.class);
    }

    public TestPreciseDurationField(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        iField = new PreciseDurationField(DurationFieldType.seconds(), 1000);
    }

    protected void tearDown() throws Exception {
        iField = null;
    }

    //-----------------------------------------------------------------------
public void test_getValue_long136() { 
     assertEquals(0, iField.getValue(0L)); 
     assertEquals(12345, iField.getValue(123456L)); 
     assertEquals(-1, iField.getValue(-1234L)); 
     assertEquals(INTEGER_MAX, iField.getValue(LONG_INTEGER_MAX * 1000L + 999L)); 
     try { 
         iField.getValue(LONG_INTEGER_MAX * 1000L + 1000L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_getValue_long137() { 
     assertEquals(0, iField.getValue(0L)); 
     assertEquals(12345, iField.getValue(123456L)); 
     assertEquals(-1, iField.getValue(-1234L)); 
     assertEquals(INTEGER_MAX, iField.getValue(LONG_INTEGER_MAX)); 
     try { 
         iField.getValue(LONG_INTEGER_MAX + 1L); 
         fail(); 
     } catch (ArithmeticException ex) { 
     } 
 }
public void test_getMillis_int_long195() { 
     assertEquals(0, iField.getMillis(0, 567L)); 
     assertEquals(1234, iField.getMillis(1234, 567L)); 
     assertEquals(-1234, iField.getMillis(-1234, 567L)); 
     assertEquals(LONG_INTEGER_MAX * 1000L, iField.getMillis(INTEGER_MAX, 567L)); 
 }
public void test_add_long_int196() { 
     assertEquals(567L, iField.add(567L, 0)); 
     assertEquals(567L + 1234000L, iField.add(567L, 1234)); 
     assertEquals(567L - 1234000L, iField.add(567L, -1234)); 
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
public void testSerialization197() throws Exception { 
     DurationField test = iField; 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(test); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     DurationField result = (DurationField) ois.readObject(); 
     ois.close(); 
     assertEquals(test, result); 
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
