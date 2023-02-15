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
package org.joda.time.format;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTimeFieldType;
import org.joda.time.Partial;

/**
 * This class is a Junit unit test for ISODateTimeFormat.
 *
 * @author Stephen Colebourne
 */
public class TestISODateTimeFormat_Fields extends TestCase {

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestISODateTimeFormat_Fields.class);
    }

    public TestISODateTimeFormat_Fields(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------
public void testForFields_calBased_YD356() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.dayOfMonth() }; 
     int[] values = new int[] { 2005, 25 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005--25", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005--25", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     try { 
         ISODateTimeFormat.forFields(types, true, true); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     types = new ArrayList(Arrays.asList(fields)); 
     try { 
         ISODateTimeFormat.forFields(types, false, true); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testForFields_datetime_DH358() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.dayOfMonth(), DateTimeFieldType.hourOfDay() }; 
     int[] values = new int[] { 25, 12 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("---25T12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("---25T12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("---25T12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("---25T12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 }
public void testForFields_calBased_M359() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.monthOfYear() }; 
     int[] values = new int[] { 6 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("--06", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("--06", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("--06", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("--06", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 }
public void testForFields_datetime_YH361() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.hourOfDay() }; 
     int[] values = new int[] { 2005, 12 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005-12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005-12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     try { 
         ISODateTimeFormat.forFields(types, true, true); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     types = new ArrayList(Arrays.asList(fields)); 
     try { 
         ISODateTimeFormat.forFields(types, false, true); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
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
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

}
