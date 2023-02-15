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

/**
 * This class is a Junit unit test for LocalDateTime.
 *
 * @author Stephen Colebourne
 */
public class TestLocalDateTime_Properties extends TestCase {

    private static final CopticChronology COPTIC_UTC = CopticChronology.getInstanceUTC();

    private int MILLIS_OF_DAY =
        (int) (10L * DateTimeConstants.MILLIS_PER_HOUR
        + 20L * DateTimeConstants.MILLIS_PER_MINUTE
        + 30L * DateTimeConstants.MILLIS_PER_SECOND
        + 40L);
    private long TEST_TIME_NOW =
        (31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + MILLIS_OF_DAY;
    private long TEST_TIME1 =
        (31L + 28L + 31L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 1L * DateTimeConstants.MILLIS_PER_HOUR
        + 2L * DateTimeConstants.MILLIS_PER_MINUTE
        + 3L * DateTimeConstants.MILLIS_PER_SECOND
        + 4L;
    private long TEST_TIME2 =
        (365L + 31L + 28L + 31L + 30L + 7L -1L) * DateTimeConstants.MILLIS_PER_DAY
        + 4L * DateTimeConstants.MILLIS_PER_HOUR
        + 5L * DateTimeConstants.MILLIS_PER_MINUTE
        + 6L * DateTimeConstants.MILLIS_PER_SECOND
        + 7L;

    private DateTimeZone zone = null;

    private Locale systemDefaultLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestLocalDateTime_Properties.class);
    }

    public TestLocalDateTime_Properties(String name) {
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
public void testPropertyCompareToDay536() { 
     LocalDateTime test1 = new LocalDateTime(TEST_TIME1); 
     LocalDateTime test2 = new LocalDateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfMonth().compareTo(test2) < 0); 
     assertEquals(true, test2.dayOfMonth().compareTo(test1) > 0); 
     assertEquals(true, test1.dayOfMonth().compareTo(test1) == 0); 
     try { 
         test1.dayOfMonth().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.dayOfMonth().compareTo(dt2) < 0); 
     assertEquals(true, test2.dayOfMonth().compareTo(dt1) > 0); 
     assertEquals(true, test1.dayOfMonth().compareTo(dt1) == 0); 
     try { 
         test1.dayOfMonth().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertyWithMaxMinValueHour537() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 0, 20, 30, 40); 
     check(test.hourOfDay().withMaximumValue(), 2005, 6, 9, 23, 20, 30, 40); 
     check(test.hourOfDay().withMinimumValue(), 2005, 6, 9, 0, 20, 30, 40); 
 }
public void testPropertyAddToCopyYear540() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     LocalDateTime copy = test.year().addToCopy(9); 
     check(test, 2005, 6, 9, 10, 20, 30, 40); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addToCopy(0); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addToCopy(292278993 - 2005 + 1); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addToCopy(-292275054 - 2005 - 1); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addToCopy(-292275054 - 2005 - 1); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
 }
public void testPropertyAddWrapFieldLocalDateTime542() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     LocalDateTime copy = test.year().addWrapFieldToCopy(9); 
     check(test, 2005, 6, 9, 10, 20, 30, 40); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addWrapFieldToCopy(0); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addWrapFieldToCopy(292278993 - 2005 + 1); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.year().addWrapFieldToCopy(-292275054 - 2005 - 1); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
 }
public void testPropertyAddWrapFieldToCopyDay543() { 
     LocalDateTime test = new LocalDateTime(2005, 6, 9, 10, 20, 30, 40); 
     LocalDateTime copy = test.dayOfMonth().addWrapFieldToCopy(21); 
     check(test, 2005, 6, 9, 10, 20, 30, 40); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.dayOfMonth().addWrapFieldToCopy(22); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
     copy = test.dayOfMonth().addWrapFieldToCopy(-12); 
     check(copy, 2005, 6, 9, 10, 20, 30, 40); 
 }
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    private void check(LocalDateTime test, int year, int month, int day, int hour, int min, int sec, int mil) {
        assertEquals(year, test.getYear());
        assertEquals(month, test.getMonthOfYear());
        assertEquals(day, test.getDayOfMonth());
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(mil, test.getMillisOfSecond());
    }
}
