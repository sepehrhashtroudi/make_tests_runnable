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

import org.joda.convert.StringConvert;
import org.joda.time.chrono.ISOChronology;

/**
 * Test string conversion.
 *
 * @author Stephen Colebourne
 */
public class TestStringConvert extends TestCase {

    private static final DateTimeZone ZONE = DateTimeZone.forID("+02:00");

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestStringConvert.class);
    }

    public TestStringConvert(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
    }

    protected void tearDown() throws Exception {
    }

    //-----------------------------------------------------------------------

public void testPeriod59() { 
     Period test = new Period(1, 2, 3, 4, 5, 6, 7, 8); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("P1Y2M3W4DT5H6M7.008S", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(Period.class, str)); 
 } 


public void testSeconds531() { 
     Seconds test = Seconds.seconds(5); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("PT5S", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(Seconds.class, str)); 
 } 


public void testWeeks553() { 
     Weeks test = Weeks.weeks(5); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("P5W", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(Weeks.class, str)); 
 } 


public void testDateTime569() { 
     DateTime test = new DateTime(2010, 6, 30, 2, 30, 50, 678, ISOChronology.getInstance(ZONE)); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("2010-06-30T02:30:50.678+02:00", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(DateTime.class, str)); 
 } 


public void testYears694() { 
     Years test = Years.years(5); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("P5Y", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(Years.class, str)); 
 } 


public void testHours1101() { 
     Hours test = Hours.hours(5); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("PT5H", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(Hours.class, str)); 
 } 


public void testMonthDay_leapDay1138() { 
     MonthDay test = new MonthDay(2, 29); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("--02-29", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(MonthDay.class, str)); 
 } 


public void testMonthDay1231() { 
     MonthDay test = new MonthDay(6, 30); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("--06-30", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(MonthDay.class, str)); 
 } 


public void testMutableDateTime1400() { 
     MutableDateTime test = new MutableDateTime(2010, 6, 30, 2, 30, 50, 678, ISOChronology.getInstance(ZONE)); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("2010-06-30T02:30:50.678+02:00", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(MutableDateTime.class, str)); 
 } 


@SuppressWarnings("deprecation") 
 public void testDateMidnight1429() { 
     DateMidnight test = new DateMidnight(2010, 6, 30, ISOChronology.getInstance(ZONE)); 
     String str = StringConvert.INSTANCE.convertToString(test); 
     assertEquals("2010-06-30T00:00:00.000+02:00", str); 
     assertEquals(test, StringConvert.INSTANCE.convertFromString(DateMidnight.class, str)); 
 } 

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

//    public void testInterval() {
//        DateTime a = new DateTime(2010, 6, 30, 2, 30, 50, 678, ISOChronology.getInstance(ZONE));
//        DateTime b = new DateTime(2011, 9, 10, 4, 20, 40, 234, ISOChronology.getInstance(ZONE));
//        Interval test = new Interval(a, b);
//        String str = StringConvert.INSTANCE.convertToString(test);
//        assertEquals("2010-06-30T02:30:50.678+02:00/2011-09-10T04:20:40.234+02:00", str);
//        assertEquals(test, StringConvert.INSTANCE.convertFromString(Interval.class, str));
//    }

    

    

    

    

    

    

    

    

    

    

}
