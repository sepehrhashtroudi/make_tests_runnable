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
package org.joda.time;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * This class is a JUnit test for PeriodType.
 *
 * @author Stephen Colebourne
 */
public class TestPeriodType extends TestCase {
    // Test in 2002/03 as time zones are more well known
    // (before the late 90's they were all over the place)

    private static final DateTimeZone PARIS = DateTimeZone.forID("Europe/Paris");
    private static final DateTimeZone LONDON = DateTimeZone.forID("Europe/London");
    
    long y2002days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365;
    long y2003days = 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 
                     366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 
                     365 + 365 + 366 + 365 + 365 + 365 + 366 + 365 + 365 + 365 +
                     366 + 365 + 365;
    
    // 2002-06-09
    private long TEST_TIME_NOW =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    // 2002-04-05
    private long TEST_TIME1 =
            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 12L * DateTimeConstants.MILLIS_PER_HOUR
            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
        
    // 2003-05-06
    private long TEST_TIME2 =
            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
            + 14L * DateTimeConstants.MILLIS_PER_HOUR
            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    
    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestPeriodType.class);
    }

    public TestPeriodType(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        DateTimeUtils.setCurrentMillisFixed(TEST_TIME_NOW);
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(LONDON);
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        DateTimeUtils.setCurrentMillisSystem();
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
    }

    //-----------------------------------------------------------------------
public void testForFields6324() throws Exception { 
     DurationFieldType[] types = null; 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     types = new DurationFieldType[0]; 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     types = new DurationFieldType[] { null, DurationFieldType.months() }; 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     types = new DurationFieldType[] { DurationFieldType.months(), null }; 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testForFields5325() throws Exception { 
     DurationFieldType[] types = new DurationFieldType[] { DurationFieldType.centuries(), DurationFieldType.months() }; 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         PeriodType.forFields(types); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 }
public void testForFields6326() throws Exception { 
     DurationFieldType[] types = new DurationFieldType[] { DurationFieldType.centuries(), DurationFieldType.months() }; 
     PeriodType type = PeriodType.forFields(types); 
     assertEquals(2, type.size()); 
     assertEquals(DurationFieldType.centuries(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.months(), type.getFieldType(1)); 
     assertEquals("StandardNoYearsNoMonthsNoWeeksNoDaysNoDaysNoMinutesNoSecondsNoMillis", type.getName()); 
     assertEquals("PeriodType[StandardNoYearsNoMonthsNoWeeksNoDaysNoMinutesNoSecondsNoMillis]", type.toString()); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type == PeriodType.forFields(types)); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.forFields(types).hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertSameAfterSerialization(type); 
 }
public void testName328() throws Exception { 
     PeriodType type = PeriodType.dayTime().withMillisRemoved(); 
     assertEquals("dayTime", type.getName()); 
     assertEquals(DurationFieldType.years(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.months(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(2)); 
     assertEquals("days", type.getName()); 
     assertEquals(DurationFieldType.days(), type.getFieldType(3)); 
     assertEquals("hours", type.getName()); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(4)); 
     assertEquals("minutes", type.getName()); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type == PeriodType.dayTime()); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.dayTime().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertSameAfterSerialization(type); 
 }
public void testToString331() { 
     PeriodType type = PeriodType.dayTime().withMillisRemoved(); 
     assertEquals("PeriodType[dayTime]", type.toString()); 
 }
public void testMaskMonths333() throws Exception { 
     PeriodType type = PeriodType.standard().withMonthsRemoved(); 
     assertEquals(7, type.size()); 
     assertEquals(DurationFieldType.months(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.days(), type.getFieldType(2)); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(3)); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(4)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.millis(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type.equals(PeriodType.standard().withMonthsRemoved())); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.standard().withMonthsRemoved().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertEquals("StandardNoMonths", type.getName()); 
     assertEquals("PeriodType[StandardNoMonths]", type.toString()); 
     assertEqualsAfterSerialization(type); 
 }
public void testMaskWeeks334() throws Exception { 
     PeriodType type = PeriodType.standard().withWeeksRemoved(); 
     assertEquals(7, type.size()); 
     assertEquals(DurationFieldType.years(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.months(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(2)); 
     assertEquals(DurationFieldType.days(), type.getFieldType(3)); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(4)); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type.equals(PeriodType.standard().withWeeksRemoved())); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.standard().withWeeksRemoved().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertEquals("StandardNoWeeks", type.getName()); 
     assertEquals("PeriodType[StandardNoWeeks]", type.toString()); 
     assertEqualsAfterSerialization(type); 
 }
public void testMaskDays335() throws Exception { 
     PeriodType type = PeriodType.standard().withDaysRemoved(); 
     assertEquals(7, type.size()); 
     assertEquals(DurationFieldType.months(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.days(), type.getFieldType(2)); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(3)); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(4)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.millis(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type.equals(PeriodType.standard().withDaysRemoved())); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.standard().withDaysRemoved().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertEquals("StandardNoDays", type.getName()); 
     assertEquals("PeriodType[StandardNoDays]", type.toString()); 
     assertEqualsAfterSerialization(type); 
 }
public void testMaskHours336() throws Exception { 
     PeriodType type = PeriodType.standard().withHoursRemoved(); 
     assertEquals(7, type.size()); 
     assertEquals(DurationFieldType.years(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.months(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(2)); 
     assertEquals(DurationFieldType.days(), type.getFieldType(3)); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(4)); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type.equals(PeriodType.standard().withHoursRemoved())); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.standard().withHoursRemoved().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertEquals("StandardNoHours", type.getName()); 
     assertEquals("PeriodType[StandardNoHours]", type.toString()); 
     assertEqualsAfterSerialization(type); 
 }
public void testMaskSeconds337() throws Exception { 
     PeriodType type = PeriodType.standard().withSecondsRemoved(); 
     assertEquals(7, type.size()); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(0)); 
     assertEquals(DurationFieldType.months(), type.getFieldType(1)); 
     assertEquals(DurationFieldType.weeks(), type.getFieldType(2)); 
     assertEquals(DurationFieldType.days(), type.getFieldType(3)); 
     assertEquals(DurationFieldType.hours(), type.getFieldType(4)); 
     assertEquals(DurationFieldType.minutes(), type.getFieldType(5)); 
     assertEquals(DurationFieldType.seconds(), type.getFieldType(6)); 
     assertEquals(true, type.equals(type)); 
     assertEquals(true, type.equals(PeriodType.standard().withSecondsRemoved())); 
     assertEquals(false, type.equals(PeriodType.millis())); 
     assertEquals(true, type.hashCode() == type.hashCode()); 
     assertEquals(true, type.hashCode() == PeriodType.standard().withSecondsRemoved().hashCode()); 
     assertEquals(false, type.hashCode() == PeriodType.millis().hashCode()); 
     assertEquals("StandardNoSeconds", type.getName()); 
     assertEquals("PeriodType[StandardNoSeconds]", type.toString()); 
     assertEqualsAfterSerialization(type); 
 }
    

    //-----------------------------------------------------------------------
    private void assertEqualsAfterSerialization(PeriodType type) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(type);
        byte[] bytes = baos.toByteArray();
        oos.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        PeriodType result = (PeriodType) ois.readObject();
        ois.close();
        
        assertEquals(type, result);
    }

    private void assertSameAfterSerialization(PeriodType type) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(type);
        byte[] bytes = baos.toByteArray();
        oos.close();
        
        ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bais);
        PeriodType result = (PeriodType) ois.readObject();
        ois.close();
        
        assertEquals(type, result);
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
    

    

    

    

    

    

    // ensure hash key distribution
    

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
