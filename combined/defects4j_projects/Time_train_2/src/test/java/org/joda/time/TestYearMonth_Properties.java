/*
 *  Copyright 2001-2010 Stephen Colebourne
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

import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.chrono.CopticChronology;
import org.joda.time.chrono.LenientChronology;
import org.joda.time.chrono.StrictChronology;

/**
 * This class is a Junit unit test for YearMonth.
 *
 * @author Stephen Colebourne
 */
public class TestYearMonth_Properties extends TestCase {

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final Chronology COPTIC_PARIS = CopticChronology.getInstance(PARIS);

    private long TEST_TIME_NOW =
            (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    private long TEST_TIME1 =
        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 12L * DateTimeConstants.MILLIS_PER_HOUR
        + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private long TEST_TIME2 =
        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 14L * DateTimeConstants.MILLIS_PER_HOUR
        + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    private DateTimeZone zone = null;

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestYearMonth_Properties.class);
    }

    public TestYearMonth_Properties(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(DateTimeZone.UTC);
        systemDefaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.ENGLISH);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
        Locale.setDefault(systemDefaultLocale);
        systemDefaultLocale = null;
    }

    //-----------------------------------------------------------------------

public void testPropertySetTextYear339() { 
     YearMonth test = new YearMonth(1972, 6); 
     YearMonth copy = test.year().setCopy("12"); 
     check(test, 1972, 6); 
     check(copy, 12, 6); 
 } 


public void testPropertyEqualsHashCodeLenient343() { 
     YearMonth test1 = new YearMonth(1970, 6, LenientChronology.getInstance(COPTIC_PARIS)); 
     YearMonth test2 = new YearMonth(1970, 6, LenientChronology.getInstance(COPTIC_PARIS)); 
     assertEquals(true, test1.monthOfYear().equals(test2.monthOfYear())); 
     assertEquals(true, test2.monthOfYear().equals(test1.monthOfYear())); 
     assertEquals(true, test1.monthOfYear().equals(test1.monthOfYear())); 
     assertEquals(true, test2.monthOfYear().equals(test2.monthOfYear())); 
     assertEquals(true, test1.monthOfYear().hashCode() == test2.monthOfYear().hashCode()); 
     assertEquals(true, test1.monthOfYear().hashCode() == test1.monthOfYear().hashCode()); 
     assertEquals(true, test2.monthOfYear().hashCode() == test2.monthOfYear().hashCode()); 
 } 


public void testPropertyAddMonth344() { 
     YearMonth test = new YearMonth(1972, 6); 
     YearMonth copy = test.monthOfYear().addToCopy(6); 
     check(test, 1972, 6); 
     check(copy, 1972, 12); 
     copy = test.monthOfYear().addToCopy(7); 
     check(copy, 1973, 1); 
     copy = test.monthOfYear().addToCopy(-5); 
     check(copy, 1972, 1); 
     copy = test.monthOfYear().addToCopy(-6); 
     check(copy, 1971, 12); 
 } 


public void testPropertyAddWrapFieldMonth345() { 
     YearMonth test = new YearMonth(1972, 6); 
     YearMonth copy = test.monthOfYear().addWrapFieldToCopy(4); 
     check(test, 1972, 6); 
     check(copy, 1972, 10); 
     copy = test.monthOfYear().addWrapFieldToCopy(8); 
     check(copy, 1972, 2); 
     copy = test.monthOfYear().addWrapFieldToCopy(-8); 
     check(copy, 1972, 10); 
 } 


public void testPropertyEquals404() { 
     YearMonth test1 = new YearMonth(11, 11); 
     YearMonth test2 = new YearMonth(11, 12); 
     YearMonth test3 = new YearMonth(11, 11, CopticChronology.getInstanceUTC()); 
     assertEquals(true, test1.monthOfYear().equals(test1.monthOfYear())); 
     assertEquals(false, test1.monthOfYear().equals(test1.year())); 
     assertEquals(false, test1.monthOfYear().equals(test2.monthOfYear())); 
     assertEquals(false, test1.monthOfYear().equals(test2.year())); 
     assertEquals(false, test1.year().equals(test1.monthOfYear())); 
     assertEquals(true, test1.year().equals(test1.year())); 
     assertEquals(false, test1.year().equals(test2.monthOfYear())); 
     assertEquals(true, test1.year().equals(test2.year())); 
     assertEquals(false, test1.monthOfYear().equals(null)); 
     assertEquals(false, test1.monthOfYear().equals("any")); 
     assertEquals(false, test1.monthOfYear().equals(test3.monthOfYear())); 
 } 

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    private void check(YearMonth test, int year, int month) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
    }
}