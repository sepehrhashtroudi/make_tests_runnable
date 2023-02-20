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

public void testForFields_weekBased_YW174() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.weekyear(), DateTimeFieldType.weekOfWeekyear() }; 
     int[] values = new int[] { 2005, 8 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("2005-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("2005W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_time_HMm382() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.millisOfSecond() }; 
     int[] values = new int[] { 10, 20, 40 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("10:20-.040", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("1020-.040", f.print(new Partial(fields, values))); 
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


public void testForFields_datetime_YH510() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.hourOfDay() }; 
     int[] values = new int[] { 2005, 12 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005T12", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005T12", f.print(new Partial(fields, values))); 
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


public void testForFields_calBased_YMD_unmodifiable824() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() }; 
     int[] values = new int[] { 2005, 6, 25 }; 
     List types = Collections.unmodifiableList(new ArrayList(Arrays.asList(fields))); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("2005-06-25", f.print(new Partial(fields, values))); 
     assertEquals(3, types.size()); 
     types = Arrays.asList(fields); 
     f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("2005-06-25", f.print(new Partial(fields, values))); 
     assertEquals(3, types.size()); 
 } 


public void testForFields_ordinalBased_D825() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.dayOfYear() }; 
     int[] values = new int[] { 177 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("-177", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("-177", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("-177", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("-177", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_calBased_YD826() { 
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


public void testForFields_weekBased_Y827() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.weekyear() }; 
     int[] values = new int[] { 2005 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("2005", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("2005", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_calBased_M828() { 
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


public void testForFields_calBased_MD829() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth() }; 
     int[] values = new int[] { 6, 25 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("--06-25", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("--06-25", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("--0625", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("--0625", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_datetime_DH830() { 
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


public void testForFields_weekBased_YD831() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.weekyear(), DateTimeFieldType.dayOfWeek() }; 
     int[] values = new int[] { 2005, 5 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("2005-W-5", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("2005W-5", f.print(new Partial(fields, values))); 
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


public void testForFields_weekBased_WD832() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.weekOfWeekyear(), DateTimeFieldType.dayOfWeek() }; 
     int[] values = new int[] { 8, 5 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("-W08-5", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("-W08-5", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("-W085", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("-W085", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_weekBased_W833() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.weekOfWeekyear() }; 
     int[] values = new int[] { 8 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("-W08", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
 } 


public void testForFields_datetime_DM834() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.dayOfMonth(), DateTimeFieldType.minuteOfHour() }; 
     int[] values = new int[] { 25, 20 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("---25T-20", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("---25T-20", f.print(new Partial(fields, values))); 
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


public void testForFields_time_HSm835() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.hourOfDay(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond() }; 
     int[] values = new int[] { 10, 30, 40 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("10-30.040", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("10-30.040", f.print(new Partial(fields, values))); 
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


public void testForFields_time_MS836() { 
     DateTimeFieldType[] fields = new DateTimeFieldType[] { DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute() }; 
     int[] values = new int[] { 20, 30 }; 
     List types = new ArrayList(Arrays.asList(fields)); 
     DateTimeFormatter f = ISODateTimeFormat.forFields(types, true, true); 
     assertEquals("-20:30", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, true, false); 
     assertEquals("-20:30", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, true); 
     assertEquals("-2030", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
     types = new ArrayList(Arrays.asList(fields)); 
     f = ISODateTimeFormat.forFields(types, false, false); 
     assertEquals("-2030", f.print(new Partial(fields, values))); 
     assertEquals(0, types.size()); 
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