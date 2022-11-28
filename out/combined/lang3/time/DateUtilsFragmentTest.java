/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.time;

import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.*;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsFragmentTest {

    private static final int months = 7;   // second final prime before 12
    private static final int days = 23;    // second final prime before 31 (and valid)
    private static final int hours = 19;   // second final prime before 24
    private static final int minutes = 53; // second final prime before 60
    private static final int seconds = 47; // third final prime before 60
    private static final int millis = 991; // second final prime before 1000

    private Date aDate;
    private Calendar aCalendar;


    @Before
    public void setUp() {
        aCalendar = Calendar.getInstance();
        aCalendar.set(2005, months, days, hours, minutes, seconds);
        aCalendar.set(Calendar.MILLISECOND, millis);
        aDate = aCalendar.getTime();
    }
    
@Test
public void testHoursOfYearWithDate383() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testMinutesOfDayWithDate720() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfMonthWithDate816() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 }
@Test
public void testMillisecondsOfDayWithDate1480() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 }
@Test
public void testMinutesOfDayWithDate1620() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testHoursOfYearWithDate1681() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testMinutesOfDayWithDate1762() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMillisecondsOfDayWithDate1779() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 }
@Test
public void testMinutesOfMonthWithDate1781() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 }
@Test
public void testMinutesOfDayWithDate1968() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfHourWithCalendar2370() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 }
@Test
public void testNullCalendar2392() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Calendar) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinutesOfDayWithDate2493() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate2642() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testHoursOfYearWithDate2910() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testMinutesOfHourWithCalendar2970() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 }
@Test
public void testMinutesOfDayWithDate3297() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testHoursOfYearWithDate3305() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testMillisecondsOfDayWithDate3356() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 }
@Test
public void testMinutesOfMonthWithDate3360() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 }
@Test
public void testMinutesOfDayWithDate3401() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate3502() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testSecondsofMinuteWithDate3544() { 
     final long testResult = DateUtils.getFragmentInSeconds(aDate, Calendar.MINUTE); 
     assertEquals(seconds, testResult); 
 }
@Test
public void testMinutesOfDayWithDate3568() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate3737() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate4292() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfMonthWithDate4370() { 
     final long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.MONTH); 
     assertEquals(minutes + ((hours * DateUtils.MILLIS_PER_HOUR) + (days * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_MINUTE, testResult); 
 }
@Test
public void testHoursOfYearWithDate4528() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testSecondFragmentInLargerUnitWithCalendar4678() { 
     assertEquals(0, DateUtils.getFragmentInSeconds(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInMinutes(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInHours(aCalendar, Calendar.SECOND)); 
     assertEquals(0, DateUtils.getFragmentInDays(aCalendar, Calendar.SECOND)); 
 }
@Test
public void testNullDate4910() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinutesOfDayWithDate5293() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate5327() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate5421() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfHourWithCalendar5684() { 
     final long testResult = DateUtils.getFragmentInMinutes(aCalendar, Calendar.HOUR_OF_DAY); 
     assertEquals(minutes, testResult); 
 }
@Test
public void testMinutesOfDayWithDate5728() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate5737() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testNullDate5758() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinutesOfDayWithDate5977() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate6256() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate6288() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMillisecondsOfDayWithDate7047() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 }
@Test
public void testMinutesOfDayWithDate7198() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testHoursOfYearWithDate7641() { 
     final long testResult = DateUtils.getFragmentInHours(aDate, Calendar.YEAR); 
     final Calendar cal = Calendar.getInstance(); 
     cal.setTime(aDate); 
     assertEquals(hours + ((cal.get(Calendar.DAY_OF_YEAR) * DateUtils.MILLIS_PER_DAY)) / DateUtils.MILLIS_PER_HOUR, testResult); 
 }
@Test
public void testMinutesOfDayWithDate7792() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testNullDate7846() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinutesOfDayWithDate7935() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate7945() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate8015() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testNullDate8132() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testNullDate8316() { 
     try { 
         DateUtils.getFragmentInMilliseconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInSeconds((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInMinutes((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInHours((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
     try { 
         DateUtils.getFragmentInDays((Date) null, Calendar.MILLISECOND); 
         fail(); 
     } catch (final IllegalArgumentException iae) { 
     } 
 }
@Test
public void testMinutesOfDayWithDate8634() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMinutesOfDayWithDate8799() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
@Test
public void testMillisecondsOfDayWithDate8916() { 
     long testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DATE); 
     final long expectedValue = millis + (seconds * DateUtils.MILLIS_PER_SECOND) + (minutes * DateUtils.MILLIS_PER_MINUTE) + (hours * DateUtils.MILLIS_PER_HOUR); 
     assertEquals(expectedValue, testresult); 
     testresult = DateUtils.getFragmentInMilliseconds(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testresult); 
 }
@Test
public void testMillisecondFragmentInLargerUnitWithCalendar9122() { 
     assertEquals(0, DateUtils.getFragmentInMilliseconds(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInSeconds(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInMinutes(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInHours(aCalendar, Calendar.MILLISECOND)); 
     assertEquals(0, DateUtils.getFragmentInDays(aCalendar, Calendar.MILLISECOND)); 
 }
@Test
public void testMinutesOfDayWithDate9437() { 
     long testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DATE); 
     final long expectedValue = minutes + ((hours * DateUtils.MILLIS_PER_HOUR)) / DateUtils.MILLIS_PER_MINUTE; 
     assertEquals(expectedValue, testResult); 
     testResult = DateUtils.getFragmentInMinutes(aDate, Calendar.DAY_OF_YEAR); 
     assertEquals(expectedValue, testResult); 
 }
    

    
    
    

    

    

    
    
    

    
    
    

    

    

    

    

    

    

    

    //Calendar.SECOND as useful fragment
    
    

    

    //Calendar.MINUTE as useful fragment

    

    

    

    

    //Calendar.HOUR_OF_DAY as useful fragment
    
    
    
    

    

    

    

    

    //Calendar.DATE and Calendar.DAY_OF_YEAR as useful fragment
    
    
    

    

    

    

    
    
    

    
    
    
    //Calendar.MONTH as useful fragment
    

    
    
    

    

    

    

    

    
    
    //Calendar.YEAR as useful fragment
    

    
    
    

    

    

    

    

    
}
