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

import java.util.Locale;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class is a Junit unit test for TimeOfDay.
 *
 * @author Stephen Colebourne
 */
@SuppressWarnings("deprecation")
public class TestTimeOfDay_Properties extends TestCase {

    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    
    private long TEST_TIME_NOW =
            10L * DateTimeConstants.MILLIS_PER_HOUR
            + 20L * DateTimeConstants.MILLIS_PER_MINUTE
            + 30L * DateTimeConstants.MILLIS_PER_SECOND
            + 40L;
            
    private long TEST_TIME1 =
        1L * DateTimeConstants.MILLIS_PER_HOUR
        + 2L * DateTimeConstants.MILLIS_PER_MINUTE
        + 3L * DateTimeConstants.MILLIS_PER_SECOND
        + 4L;
        
    private long TEST_TIME2 =
        1L * DateTimeConstants.MILLIS_PER_DAY
        + 5L * DateTimeConstants.MILLIS_PER_HOUR
        + 6L * DateTimeConstants.MILLIS_PER_MINUTE
        + 7L * DateTimeConstants.MILLIS_PER_SECOND
        + 8L;
        
    private DateTimeZone zone = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestTimeOfDay_Properties.class);
    }

    public TestTimeOfDay_Properties(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        zone = DateTimeZone.getDefault();
        DateTimeZone.setDefault(LONDON);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(zone);
        zone = null;
    }

    //-----------------------------------------------------------------------
public void testWithers453() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     check(test.withHourOfDay(6), 6, 20, 30, 40); 
     check(test.withMinuteOfHour(6), 10, 6, 30, 40); 
     check(test.withSecondOfMinute(6), 10, 20, 6, 40); 
     check(test.withMillisOfSecond(6), 10, 20, 30, 6); 
     try { 
         test.withHourOfDay(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.withHourOfDay(24); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertySetTextHour460() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.hourOfDay().setCopy("12"); 
     check(test, 10, 20, 30, 40); 
     check(copy, 12, 20, 30, 40); 
 }
public void testSetMilliOfSecond462() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.millisOfSecond().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 30, 12); 
     try { 
         test.millisOfSecond().setCopy(1000); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.millisOfSecond().setCopy(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertySetTextSecond463() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.secondOfMinute().setCopy("12"); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 12, 40); 
 }
public void testPropertyCompareToSecond465() { 
     TimeOfDay test1 = new TimeOfDay(TEST_TIME1); 
     TimeOfDay test2 = new TimeOfDay(TEST_TIME2); 
     assertEquals(true, test1.secondOfMinute().compareTo(test2) < 0); 
     assertEquals(true, test2.secondOfMinute().compareTo(test1) > 0); 
     assertEquals(true, test1.secondOfMinute().compareTo(test1) == 0); 
     try { 
         test1.secondOfMinute().compareTo((ReadablePartial) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     DateTime dt1 = new DateTime(TEST_TIME1); 
     DateTime dt2 = new DateTime(TEST_TIME2); 
     assertEquals(true, test1.secondOfMinute().compareTo(dt2) < 0); 
     assertEquals(true, test2.secondOfMinute().compareTo(dt1) > 0); 
     assertEquals(true, test1.secondOfMinute().compareTo(dt1) == 0); 
     try { 
         test1.secondOfMinute().compareTo((ReadableInstant) null); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testPropertySetSecond466() { 
     TimeOfDay test = new TimeOfDay(10, 20, 30, 40); 
     TimeOfDay copy = test.secondOfMinute().setCopy(12); 
     check(test, 10, 20, 30, 40); 
     check(copy, 10, 20, 12, 40); 
     try { 
         test.secondOfMinute().setCopy(60); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         test.secondOfMinute().setCopy(-1); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
    

    

    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    private void check(TimeOfDay test, int hour, int min, int sec, int milli) {
        assertEquals(hour, test.getHourOfDay());
        assertEquals(min, test.getMinuteOfHour());
        assertEquals(sec, test.getSecondOfMinute());
        assertEquals(milli, test.getMillisOfSecond());
    }
}
