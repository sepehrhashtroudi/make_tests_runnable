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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;
import java.security.AllPermission;
import java.security.CodeSource;
import java.security.Permission;
import java.security.PermissionCollection;
import java.security.Permissions;
import java.security.Policy;
import java.security.ProtectionDomain;
import java.text.DateFormatSymbols;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;

import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.joda.time.tz.DefaultNameProvider;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.Provider;
import org.joda.time.tz.UTCProvider;
import org.joda.time.tz.ZoneInfoProvider;

/**
 * This class is a JUnit test for DateTimeZone.
 *
 * @author Stephen Colebourne
 */
public class TestDateTimeZone extends TestCase {
    private static final boolean OLD_JDK;
    static {
        String str = System.getProperty("java.version");
        boolean old = true;
        if (str.length() > 3 &&
            str.charAt(0) == '1' &&
            str.charAt(1) == '.' &&
            (str.charAt(2) == '4' || str.charAt(2) == '5' || str.charAt(2) == '6')) {
            old = false;
        }
        OLD_JDK = old;
    }
    
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
    private long TEST_TIME_SUMMER =
            (y2002days + 31L + 28L + 31L + 30L + 31L + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
    // 2002-01-09
    private long TEST_TIME_WINTER =
            (y2002days + 9L -1L) * DateTimeConstants.MILLIS_PER_DAY;
            
//    // 2002-04-05 Fri
//    private long TEST_TIME1 =
//            (y2002days + 31L + 28L + 31L + 5L -1L) * DateTimeConstants.MILLIS_PER_DAY
//            + 12L * DateTimeConstants.MILLIS_PER_HOUR
//            + 24L * DateTimeConstants.MILLIS_PER_MINUTE;
//        
//    // 2003-05-06 Tue
//    private long TEST_TIME2 =
//            (y2003days + 31L + 28L + 31L + 30L + 6L -1L) * DateTimeConstants.MILLIS_PER_DAY
//            + 14L * DateTimeConstants.MILLIS_PER_HOUR
//            + 28L * DateTimeConstants.MILLIS_PER_MINUTE;
    
    private static final Policy RESTRICT;
    private static final Policy ALLOW;
    static {
        // don't call Policy.getPolicy()
        RESTRICT = new Policy() {
            public PermissionCollection getPermissions(CodeSource codesource) {
                Permissions p = new Permissions();
                p.add(new AllPermission());  // enable everything
                return p;
            }
            public void refresh() {
            }
            public boolean implies(ProtectionDomain domain, Permission permission) {
                if (permission instanceof JodaTimePermission) {
                    return false;
                }
                return true;
//                return super.implies(domain, permission);
            }
        };
        ALLOW = new Policy() {
            public PermissionCollection getPermissions(CodeSource codesource) {
                Permissions p = new Permissions();
                p.add(new AllPermission());  // enable everything
                return p;
            }
            public void refresh() {
            }
        };
    }
    
    private DateTimeZone zone;
    private Locale locale;

    public static void main(String[] args) {
        junit.textui.TestRunner.run(suite());
    }

    public static TestSuite suite() {
        return new TestSuite(TestDateTimeZone.class);
    }

    public TestDateTimeZone(String name) {
        super(name);
    }

    protected void setUp() throws Exception {
        locale = Locale.getDefault();
        zone = DateTimeZone.getDefault();
        Locale.setDefault(Locale.UK);
    }

    protected void tearDown() throws Exception {
        Locale.setDefault(locale);
        DateTimeZone.setDefault(zone);
    }

    //-----------------------------------------------------------------------

public void testPatchedNameKeysLondon240() throws Exception { 
     DateTimeZone zone = DateTimeZone.forID("Europe/London"); 
     DateTime now = new DateTime(2007, 1, 1, 0, 0, 0, 0); 
     String str1 = zone.getName(now.getMillis()); 
     String str2 = zone.getName(now.plusMonths(6).getMillis()); 
     assertEquals(false, str1.equals(str2)); 
 } 


public void testIsFixed243() { 
     DateTimeZone zone = DateTimeZone.forID("Europe/Paris"); 
     assertEquals(false, zone.isFixed()); 
     assertEquals(true, DateTimeZone.UTC.isFixed()); 
 } 


public void testProvider_badClassName613() { 
     try { 
         System.setProperty("org.joda.time.DateTimeZone.Provider", "xxx"); 
         DateTimeZone.setProvider(null); 
     } catch (RuntimeException ex) { 
         assertEquals(ZoneInfoProvider.class, DateTimeZone.getProvider().getClass()); 
     } finally { 
         System.getProperties().remove("org.joda.time.DateTimeZone.Provider"); 
         DateTimeZone.setProvider(null); 
     } 
 } 


public void testSerialization2615() throws Exception { 
     DateTimeZone zone = DateTimeZone.forID("+01:00"); 
     ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
     ObjectOutputStream oos = new ObjectOutputStream(baos); 
     oos.writeObject(zone); 
     byte[] bytes = baos.toByteArray(); 
     oos.close(); 
     ByteArrayInputStream bais = new ByteArrayInputStream(bytes); 
     ObjectInputStream ois = new ObjectInputStream(bais); 
     DateTimeZone result = (DateTimeZone) ois.readObject(); 
     ois.close(); 
     assertSame(zone, result); 
 } 


public void testForOffsetHoursMinutes_int_int791() { 
     assertEquals(DateTimeZone.UTC, DateTimeZone.forOffsetHoursMinutes(0, 0)); 
     assertEquals(DateTimeZone.forID("+23:59"), DateTimeZone.forOffsetHoursMinutes(23, 59)); 
     assertEquals(DateTimeZone.forID("+02:15"), DateTimeZone.forOffsetHoursMinutes(2, 15)); 
     assertEquals(DateTimeZone.forID("+02:00"), DateTimeZone.forOffsetHoursMinutes(2, 0)); 
     try { 
         DateTimeZone.forOffsetHoursMinutes(2, -15); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     assertEquals(DateTimeZone.forID("+00:15"), DateTimeZone.forOffsetHoursMinutes(0, 15)); 
     assertEquals(DateTimeZone.forID("+00:00"), DateTimeZone.forOffsetHoursMinutes(0, 0)); 
     assertEquals(DateTimeZone.forID("-00:15"), DateTimeZone.forOffsetHoursMinutes(0, -15)); 
     assertEquals(DateTimeZone.forID("-02:00"), DateTimeZone.forOffsetHoursMinutes(-2, 0)); 
     assertEquals(DateTimeZone.forID("-02:15"), DateTimeZone.forOffsetHoursMinutes(-2, -15)); 
     assertEquals(DateTimeZone.forID("-02:15"), DateTimeZone.forOffsetHoursMinutes(-2, 15)); 
     assertEquals(DateTimeZone.forID("-23:59"), DateTimeZone.forOffsetHoursMinutes(-23, 59)); 
     try { 
         DateTimeZone.forOffsetHoursMinutes(2, 60); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeZone.forOffsetHoursMinutes(-2, 60); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeZone.forOffsetHoursMinutes(24, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
     try { 
         DateTimeZone.forOffsetHoursMinutes(-24, 0); 
         fail(); 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testForTimeZone_TimeZone792() { 
     assertEquals(DateTimeZone.getDefault(), DateTimeZone.forTimeZone((TimeZone) null)); 
     DateTimeZone zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("Europe/London")); 
     assertEquals("Europe/London", zone.getID()); 
     assertSame(DateTimeZone.UTC, DateTimeZone.forTimeZone(TimeZone.getTimeZone("UTC"))); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("+00:00")); 
     assertSame(DateTimeZone.UTC, zone); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+00:00")); 
     assertSame(DateTimeZone.UTC, zone); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+00:00")); 
     assertSame(DateTimeZone.UTC, zone); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+00")); 
     assertSame(DateTimeZone.UTC, zone); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+01:23")); 
     assertEquals("+01:23", zone.getID()); 
     assertEquals(DateTimeConstants.MILLIS_PER_HOUR + (23L * DateTimeConstants.MILLIS_PER_MINUTE), zone.getOffset(TEST_TIME_SUMMER)); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+1:23")); 
     assertEquals("+01:23", zone.getID()); 
     assertEquals(DateTimeConstants.MILLIS_PER_HOUR + (23L * DateTimeConstants.MILLIS_PER_MINUTE), zone.getOffset(TEST_TIME_SUMMER)); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT-02:00")); 
     assertEquals("-02:00", zone.getID()); 
     assertEquals((-2L * DateTimeConstants.MILLIS_PER_HOUR), zone.getOffset(TEST_TIME_SUMMER)); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("GMT+2")); 
     assertEquals("+02:00", zone.getID()); 
     assertEquals((2L * DateTimeConstants.MILLIS_PER_HOUR), zone.getOffset(TEST_TIME_SUMMER)); 
     zone = DateTimeZone.forTimeZone(TimeZone.getTimeZone("EST")); 
     assertEquals("America/New_York", zone.getID()); 
 } 


public void testForOffsetMillis_int793() { 
     assertSame(DateTimeZone.UTC, DateTimeZone.forOffsetMillis(0)); 
     assertEquals(DateTimeZone.forID("+23:59:59.999"), DateTimeZone.forOffsetMillis((24 * 60 * 60 * 1000) - 1)); 
     assertEquals(DateTimeZone.forID("+03:00"), DateTimeZone.forOffsetMillis(3 * 60 * 60 * 1000)); 
     assertEquals(DateTimeZone.forID("-02:00"), DateTimeZone.forOffsetMillis(-2 * 60 * 60 * 1000)); 
     assertEquals(DateTimeZone.forID("-23:59:59.999"), DateTimeZone.forOffsetMillis((-24 * 60 * 60 * 1000) + 1)); 
     assertEquals(DateTimeZone.forID("+04:45:17.045"), DateTimeZone.forOffsetMillis(4 * 60 * 60 * 1000 + 45 * 60 * 1000 + 17 * 1000 + 45)); 
 } 


public void testGetAvailableIDs794() { 
     assertTrue(DateTimeZone.getAvailableIDs().contains("UTC")); 
 } 


public void testProvider795() { 
     try { 
         assertNotNull(DateTimeZone.getProvider()); 
         Provider provider = DateTimeZone.getProvider(); 
         DateTimeZone.setProvider(null); 
         assertEquals(provider.getClass(), DateTimeZone.getProvider().getClass()); 
         try { 
             DateTimeZone.setProvider(new MockNullIDSProvider()); 
             fail(); 
         } catch (IllegalArgumentException ex) { 
         } 
         try { 
             DateTimeZone.setProvider(new MockEmptyIDSProvider()); 
             fail(); 
         } catch (IllegalArgumentException ex) { 
         } 
         try { 
             DateTimeZone.setProvider(new MockNoUTCProvider()); 
             fail(); 
         } catch (IllegalArgumentException ex) { 
         } 
         try { 
             DateTimeZone.setProvider(new MockBadUTCProvider()); 
             fail(); 
         } catch (IllegalArgumentException ex) { 
         } 
         Provider prov = new MockOKProvider(); 
         DateTimeZone.setProvider(prov); 
         assertSame(prov, DateTimeZone.getProvider()); 
         assertEquals(2, DateTimeZone.getAvailableIDs().size()); 
         assertTrue(DateTimeZone.getAvailableIDs().contains("UTC")); 
         assertTrue(DateTimeZone.getAvailableIDs().contains("Europe/London")); 
     } finally { 
         DateTimeZone.setProvider(null); 
         assertEquals(ZoneInfoProvider.class, DateTimeZone.getProvider().getClass()); 
     } 
     try { 
         System.setProperty("org.joda.time.DateTimeZone.Provider", "org.joda.time.tz.UTCProvider"); 
         DateTimeZone.setProvider(null); 
         assertEquals(UTCProvider.class, DateTimeZone.getProvider().getClass()); 
     } finally { 
         System.getProperties().remove("org.joda.time.DateTimeZone.Provider"); 
         DateTimeZone.setProvider(null); 
         assertEquals(ZoneInfoProvider.class, DateTimeZone.getProvider().getClass()); 
     } 
 } 


public void testNameProvider_badClassName796() { 
     try { 
         System.setProperty("org.joda.time.DateTimeZone.NameProvider", "xxx"); 
         DateTimeZone.setProvider(null); 
     } catch (RuntimeException ex) { 
         assertEquals(DefaultNameProvider.class, DateTimeZone.getNameProvider().getClass()); 
     } finally { 
         System.getProperties().remove("org.joda.time.DateTimeZone.NameProvider"); 
         DateTimeZone.setProvider(null); 
     } 
 } 


public void testNameProvider797() { 
     try { 
         assertNotNull(DateTimeZone.getNameProvider()); 
         NameProvider provider = DateTimeZone.getNameProvider(); 
         DateTimeZone.setNameProvider(null); 
         assertEquals(provider.getClass(), DateTimeZone.getNameProvider().getClass()); 
         provider = new MockOKButNullNameProvider(); 
         DateTimeZone.setNameProvider(provider); 
         assertSame(provider, DateTimeZone.getNameProvider()); 
         assertEquals("+00:00", DateTimeZone.UTC.getShortName(TEST_TIME_SUMMER)); 
         assertEquals("+00:00", DateTimeZone.UTC.getName(TEST_TIME_SUMMER)); 
     } finally { 
         DateTimeZone.setNameProvider(null); 
     } 
     try { 
         System.setProperty("org.joda.time.DateTimeZone.NameProvider", "org.joda.time.tz.DefaultNameProvider"); 
         DateTimeZone.setNameProvider(null); 
         assertEquals(DefaultNameProvider.class, DateTimeZone.getNameProvider().getClass()); 
     } finally { 
         System.getProperties().remove("org.joda.time.DateTimeZone.NameProvider"); 
         DateTimeZone.setNameProvider(null); 
         assertEquals(DefaultNameProvider.class, DateTimeZone.getNameProvider().getClass()); 
     } 
 } 


public void testConstructor798() { 
     assertEquals(1, DateTimeZone.class.getDeclaredConstructors().length); 
     assertTrue(Modifier.isProtected(DateTimeZone.class.getDeclaredConstructors()[0].getModifiers())); 
     try { 
         new DateTimeZone(null) { 
  
             public String getNameKey(long instant) { 
                 return null; 
             } 
  
             public int getOffset(long instant) { 
                 return 0; 
             } 
  
             public int getStandardOffset(long instant) { 
                 return 0; 
             } 
  
             public boolean isFixed() { 
                 return false; 
             } 
  
             public long nextTransition(long instant) { 
                 return 0; 
             } 
  
             public long previousTransition(long instant) { 
                 return 0; 
             } 
  
             public boolean equals(Object object) { 
                 return false; 
             } 
         }; 
     } catch (IllegalArgumentException ex) { 
     } 
 } 


public void testGetShortNameNullKey799() { 
     DateTimeZone zone = new MockDateTimeZone("Europe/London"); 
     assertEquals("Europe/London", zone.getShortName(TEST_TIME_SUMMER, Locale.ENGLISH)); 
 } 


public void testGetNameNullKey800() { 
     DateTimeZone zone = new MockDateTimeZone("Europe/London"); 
     assertEquals("Europe/London", zone.getName(TEST_TIME_SUMMER, Locale.ENGLISH)); 
 } 


public void testGetOffset_RI801() { 
     DateTimeZone zone = DateTimeZone.forID("Europe/Paris"); 
     assertEquals(2L * DateTimeConstants.MILLIS_PER_HOUR, zone.getOffset(new Instant(TEST_TIME_SUMMER))); 
     assertEquals(1L * DateTimeConstants.MILLIS_PER_HOUR, zone.getOffset(new Instant(TEST_TIME_WINTER))); 
     assertEquals(zone.getOffset(DateTimeUtils.currentTimeMillis()), zone.getOffset(null)); 
 } 


public void testGetMillisKeepLocal805() { 
     long millisLondon = TEST_TIME_SUMMER; 
     long millisParis = TEST_TIME_SUMMER - 1L * DateTimeConstants.MILLIS_PER_HOUR; 
     assertEquals(millisLondon, LONDON.getMillisKeepLocal(LONDON, millisLondon)); 
     assertEquals(millisParis, LONDON.getMillisKeepLocal(LONDON, millisParis)); 
     assertEquals(millisLondon, PARIS.getMillisKeepLocal(PARIS, millisLondon)); 
     assertEquals(millisParis, PARIS.getMillisKeepLocal(PARIS, millisParis)); 
     assertEquals(millisParis, LONDON.getMillisKeepLocal(PARIS, millisLondon)); 
     assertEquals(millisLondon, PARIS.getMillisKeepLocal(LONDON, millisParis)); 
     DateTimeZone zone = DateTimeZone.getDefault(); 
     try { 
         DateTimeZone.setDefault(LONDON); 
         assertEquals(millisLondon, PARIS.getMillisKeepLocal(null, millisParis)); 
     } finally { 
         DateTimeZone.setDefault(zone); 
     } 
 } 


public void testToTimeZone807() { 
     DateTimeZone zone = DateTimeZone.forID("Europe/Paris"); 
     TimeZone tz = zone.toTimeZone(); 
     assertEquals("Europe/Paris", tz.getID()); 
 } 


public void testGetShortNameProviderName1387() { 
     assertEquals(null, DateTimeZone.getNameProvider().getShortName(null, "Europe/London", "BST")); 
     assertEquals(null, DateTimeZone.getNameProvider().getShortName(Locale.ENGLISH, null, "BST")); 
     assertEquals(null, DateTimeZone.getNameProvider().getShortName(Locale.ENGLISH, "Europe/London", null)); 
     assertEquals(null, DateTimeZone.getNameProvider().getShortName(null, null, null)); 
 } 


public void testPatchedNameKeysSydneyHistoric1388() throws Exception { 
     DateTimeZone zone = DateTimeZone.forID("Australia/Sydney"); 
     DateTime now = new DateTime(1996, 1, 1, 0, 0, 0, 0); 
     String str1 = zone.getName(now.getMillis()); 
     String str2 = zone.getName(now.plusMonths(6).getMillis()); 
     assertEquals(false, str1.equals(str2)); 
 } 

    
            
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
            

    //-----------------------------------------------------------------------
            

    //-----------------------------------------------------------------------
            

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    
    
    

    static class MockNullIDSProvider implements Provider {
        public Set getAvailableIDs() {
            return null;
        }
        public DateTimeZone getZone(String id) {
            return null;
        }
    }
    static class MockEmptyIDSProvider implements Provider {
        public Set getAvailableIDs() {
            return new HashSet();
        }
        public DateTimeZone getZone(String id) {
            return null;
        }
    }
    static class MockNoUTCProvider implements Provider {
        public Set getAvailableIDs() {
            Set set = new HashSet();
            set.add("Europe/London");
            return set;
        }
        public DateTimeZone getZone(String id) {
            return null;
        }
    }
    static class MockBadUTCProvider implements Provider {
        public Set getAvailableIDs() {
            Set set = new HashSet();
            set.add("UTC");
            set.add("Europe/London");
            return set;
        }
        public DateTimeZone getZone(String id) {
            return null;
        }
    }
    static class MockOKProvider implements Provider {
        public Set getAvailableIDs() {
            Set set = new HashSet();
            set.add("UTC");
            set.add("Europe/London");
            return set;
        }
        public DateTimeZone getZone(String id) {
            return DateTimeZone.UTC;
        }
    }

    //-----------------------------------------------------------------------
    

    

    

    static class MockOKButNullNameProvider implements NameProvider {
        public String getShortName(Locale locale, String id, String nameKey) {
            return null;
        }
        public String getName(Locale locale, String id, String nameKey) {
            return null;
        }
    }

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    static final boolean JDK6;
    static {
      boolean jdk6 = true;
      try {
        DateFormatSymbols.class.getMethod("getInstance", new Class[] {Locale.class});
      } catch (Exception ex) {
        jdk6 = false;
      } 
      JDK6 = jdk6;
    }

    
// Defects4J: flaky method
//     public void testGetShortName() {
//         DateTimeZone zone = DateTimeZone.forID("Europe/London");
//         assertEquals("BST", zone.getShortName(TEST_TIME_SUMMER));
//         assertEquals("GMT", zone.getShortName(TEST_TIME_WINTER));
//         assertEquals("BST", zone.getShortName(TEST_TIME_SUMMER, Locale.ENGLISH));
//     }

    
// Defects4J: flaky method
//     public void testGetShortName_berlin() {
//         DateTimeZone berlin = DateTimeZone.forID("Europe/Berlin");
//         assertEquals("CET", berlin.getShortName(TEST_TIME_WINTER, Locale.ENGLISH));
//         assertEquals("CEST", berlin.getShortName(TEST_TIME_SUMMER, Locale.ENGLISH));
//         if (JDK6) {
//           assertEquals("MEZ", berlin.getShortName(TEST_TIME_WINTER, Locale.GERMAN));
//           assertEquals("MESZ", berlin.getShortName(TEST_TIME_SUMMER, Locale.GERMAN));
//         } else {
//           assertEquals("CET", berlin.getShortName(TEST_TIME_WINTER, Locale.GERMAN));
//           assertEquals("CEST", berlin.getShortName(TEST_TIME_SUMMER, Locale.GERMAN));
//         }
//     }

    

    

    
// Defects4J: flaky method
//     public void testGetName() {
//         DateTimeZone zone = DateTimeZone.forID("Europe/London");
//         assertEquals("British Summer Time", zone.getName(TEST_TIME_SUMMER));
//         assertEquals("Greenwich Mean Time", zone.getName(TEST_TIME_WINTER));
//         assertEquals("British Summer Time", zone.getName(TEST_TIME_SUMMER, Locale.ENGLISH));
//     }

    
// Defects4J: flaky method
//     public void testGetName_berlin() {
//       DateTimeZone berlin = DateTimeZone.forID("Europe/Berlin");
//       assertEquals("Central European Time", berlin.getName(TEST_TIME_WINTER, Locale.ENGLISH));
//       assertEquals("Central European Summer Time", berlin.getName(TEST_TIME_SUMMER, Locale.ENGLISH));
//       if (JDK6) {
//         assertEquals("Mitteleurop\u00e4ische Zeit", berlin.getName(TEST_TIME_WINTER, Locale.GERMAN));
//         assertEquals("Mitteleurop\u00e4ische Sommerzeit", berlin.getName(TEST_TIME_SUMMER, Locale.GERMAN));
//       } else {
//         assertEquals("Zentraleurop\u00e4ische Zeit", berlin.getName(TEST_TIME_WINTER, Locale.GERMAN));
//         assertEquals("Zentraleurop\u00e4ische Sommerzeit", berlin.getName(TEST_TIME_SUMMER, Locale.GERMAN));
//       }
//   }

    

    

    static class MockDateTimeZone extends DateTimeZone {
        public MockDateTimeZone(String id) {
            super(id);
        }
        public String getNameKey(long instant) {
            return null;  // null
        }
        public int getOffset(long instant) {
            return 0;
        }
        public int getStandardOffset(long instant) {
            return 0;
        }
        public boolean isFixed() {
            return false;
        }
        public long nextTransition(long instant) {
            return 0;
        }
        public long previousTransition(long instant) {
            return 0;
        }
        public boolean equals(Object object) {
            return false;
        }
    }

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

//    //-----------------------------------------------------------------------
//    public void testIsLocalDateTimeOverlap_Berlin() {
//        DateTimeZone zone = DateTimeZone.forID("Europe/Berlin");
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 1, 0)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 1, 59, 59, 99)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 2, 0)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 2, 30)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 2, 59, 59, 99)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 3, 0)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 10, 28, 4, 0)));
//        
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 25, 1, 30)));  // before gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 25, 2, 30)));  // gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 25, 3, 30)));  // after gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 12, 24, 12, 34)));
//    }
//
//    //-----------------------------------------------------------------------
//    public void testIsLocalDateTimeOverlap_NewYork() {
//        DateTimeZone zone = DateTimeZone.forID("America/New_York");
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 0, 0)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 0, 59, 59, 99)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 1, 0)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 1, 30)));
//        assertEquals(true, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 1, 59, 59, 99)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 2, 0)));
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 11, 4, 3, 0)));
//        
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 11, 1, 30)));  // before gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 11, 2, 30)));  // gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 3, 11, 3, 30)));  // after gap
//        assertEquals(false, zone.isLocalDateTimeOverlap(new LocalDateTime(2007, 12, 24, 12, 34)));
//    }

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

}
