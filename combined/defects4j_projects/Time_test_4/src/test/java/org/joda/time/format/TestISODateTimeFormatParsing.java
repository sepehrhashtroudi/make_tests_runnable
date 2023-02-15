/*
 *  Copyright 2001-2006 Stephen Colebourne
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

import java.util.Locale;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 * This class is a Junit unit test for ISODateTimeFormat parsing.
 *
 * @author Stephen Colebourne
 */
public class TestISODateTimeFormatParsing extends TestCase {

    private DateTimeZone originalDateTimeZone = null;
    private TimeZone originalTimeZone = null;
    private Locale originalLocale = null;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestISODateTimeFormatParsing.class);
    }

    public TestISODateTimeFormatParsing(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        originalDateTimeZone = DateTimeZone.getDefault();
        originalTimeZone = TimeZone.getDefault();
        originalLocale = Locale.getDefault();
        DateTimeZone.setDefault(DateTimeZone.forID("Europe/London"));
        TimeZone.setDefault(TimeZone.getTimeZone("Europe/London"));
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        DateTimeZone.setDefault(originalDateTimeZone);
        TimeZone.setDefault(originalTimeZone);
        Locale.setDefault(originalLocale);
        originalDateTimeZone = null;
        originalTimeZone = null;
        originalLocale = null;
    }

    //-----------------------------------------------------------------------
public void test_ordinalDateTime326() { 
     DateTimeZone.setDefault(DateTimeZone.UTC); 
     DateTimeFormatter parser = ISODateTimeFormat.ordinalDateTime(); 
     assertParse(parser, "2006-123T10:20:30.400999999Z", new DateTime(2006, 1, 1, 10, 20, 30, 400).withDayOfYear(123)); 
     assertParse(parser, "2006-12T10:20:30.400Z", new DateTime(2006, 1, 1, 10, 20, 30, 400).withDayOfYear(12)); 
     assertParse(parser, "2006-1T10:20:30.40Z", new DateTime(2006, 1, 1, 10, 20, 30, 400).withDayOfYear(1)); 
     assertParse(parser, "2006-123T10:20:30.4Z", new DateTime(2006, 1, 1, 10, 20, 30, 400).withDayOfYear(123)); 
     assertParse(parser, false, "2006-T10:20:30.400Z"); 
     assertParse(parser, false, "2006T10:20:30.400Z"); 
     assertParse(parser, false, "2006-123T10:20:30.400Z"); 
     assertParse(parser, false, "2006-123T10:2Z"); 
     assertParse(parser, false, "2006-123T10Z"); 
     assertParse(parser, false, "2006-123T1Z"); 
 }
public void test_basicDate327() { 
     DateTimeZone.setDefault(DateTimeZone.UTC); 
     DateTimeFormatter parser = ISODateTimeFormat.basicDate(); 
     assertParse(parser, "20061204T102030.400999999Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.400Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.40Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.4Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, false, "2006120T102030.400Z"); 
     assertParse(parser, false, "200612T102030.400Z"); 
     assertParse(parser, false, "20061T102030.400Z"); 
     assertParse(parser, false, "2006T102030.400Z"); 
     assertParse(parser, false, "200T102030.400Z"); 
     assertParse(parser, false, "20T102030.400Z"); 
     assertParse(parser, false, "2T102030.400Z"); 
     assertParse(parser, false, "20061204T10203.400Z"); 
     assertParse(parser, false, "20061204T102.400Z"); 
     assertParse(parser, false, "20061204T10.400Z"); 
     assertParse(parser, false, "20061204T1.400Z"); 
 }
public void test_basicDate328() { 
     DateTimeFormatter parser = ISODateTimeFormat.basicDate(); 
     assertParse(parser, "20061204T102030.400999999Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.400Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.40Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, "20061204T102030.4Z", new DateTime(2006, 12, 4, 10, 20, 30, 400)); 
     assertParse(parser, false, "2006120T102030.400Z"); 
     assertParse(parser, false, "200612T102030.400Z"); 
     assertParse(parser, false, "20061T102030.400Z"); 
     assertParse(parser, false, "2006T102030.400Z"); 
     assertParse(parser, false, "200T102030.400Z"); 
     assertParse(parser, false, "20T102030.400Z"); 
     assertParse(parser, false, "2T102030.400Z"); 
     assertParse(parser, false, "20061204T10203.400Z"); 
     assertParse(parser, false, "20061204T102.400Z"); 
     assertParse(parser, false, "20061204T10.400Z"); 
     assertParse(parser, false, "20061204T1.400Z"); 
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
    private void assertParse(DateTimeFormatter parser, boolean expected, String str) {
        if (expected) {
            parser.parseMillis(str);
        } else {
            try {
                parser.parseMillis(str);
                fail();
            } catch (IllegalArgumentException ex) {
                // expected
            }
        }
    }

    private void assertParse(DateTimeFormatter parser, String str, DateTime expected) {
        DateTime dt = parser.parseDateTime(str);
        assertEquals(expected, dt);
    }

}
