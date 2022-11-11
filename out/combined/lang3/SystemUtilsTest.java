/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_4;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Locale;

import org.junit.Assert;

/**
 * Unit tests {@link org.apache.commons.lang3.SystemUtils}.
 * 
 * Only limited testing can be performed.
 * 
 * @version $Id$
 */
public class SystemUtilsTest {

@Test
public void testJavaAwtHeadless449() { 
     final boolean atLeastJava14 = SystemUtils.isJavaVersionAtLeast(JAVA_1_4); 
     final String expectedStringValue = System.getProperty("java.awt.headless"); 
     final String expectedStringValueWithDefault = System.getProperty("java.awt.headless", "false"); 
     assertNotNull(expectedStringValueWithDefault); 
     if (atLeastJava14) { 
         final boolean expectedValue = Boolean.valueOf(expectedStringValue).booleanValue(); 
         if (expectedStringValue != null) { 
             assertEquals(expectedStringValue, SystemUtils.JAVA_AWT_HEADLESS); 
         } 
         assertEquals(expectedValue, SystemUtils.isJavaAwtHeadless()); 
     } else { 
         assertNull(expectedStringValue); 
         assertNull(SystemUtils.JAVA_AWT_HEADLESS); 
         assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
     } 
     assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
 }
@Test
public void testGetJavaHome1389() { 
     final File dir = SystemUtils.getJavaHome(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testConstructor1828() { 
     assertNotNull(new SystemUtils()); 
     final Constructor<?>[] cons = SystemUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(SystemUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(SystemUtils.class.getModifiers())); 
 }
@Test
public void testGetJavaIoTmpDir1997() { 
     final File dir = SystemUtils.getJavaIoTmpDir(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testOSMatchesName2915() { 
     String osName = null; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = ""; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows 95"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows NT"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "OS/2"; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
 }
@Test
public void testJavaVersionMatches3164() { 
     String javaVersion = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.0"; 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.5.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.6.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.7.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
 }
@Test
public void testGetUserDir3335() { 
     final File dir = SystemUtils.getUserDir(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testGetUserHome3383() { 
     final File dir = SystemUtils.getUserHome(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testJavaVersionMatches3445() { 
     String javaVersion = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.0"; 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.5.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.6.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.7.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
 }
@Test
public void testOSMatchesName3662() { 
     String osName = null; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = ""; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows 95"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows NT"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "OS/2"; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
 }
@Test
public void testJavaAwtHeadless3667() { 
     final boolean atLeastJava14 = SystemUtils.isJavaVersionAtLeast(JAVA_1_4); 
     final String expectedStringValue = System.getProperty("java.awt.headless"); 
     final String expectedStringValueWithDefault = System.getProperty("java.awt.headless", "false"); 
     assertNotNull(expectedStringValueWithDefault); 
     if (atLeastJava14) { 
         final boolean expectedValue = Boolean.valueOf(expectedStringValue).booleanValue(); 
         if (expectedStringValue != null) { 
             assertEquals(expectedStringValue, SystemUtils.JAVA_AWT_HEADLESS); 
         } 
         assertEquals(expectedValue, SystemUtils.isJavaAwtHeadless()); 
     } else { 
         assertNull(expectedStringValue); 
         assertNull(SystemUtils.JAVA_AWT_HEADLESS); 
         assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
     } 
     assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
 }
@Test
public void testJavaVersionMatches3853() { 
     String javaVersion = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.0"; 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.5.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.6.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.7.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
 }
@Test
public void testJavaAwtHeadless4932() { 
     final boolean atLeastJava14 = SystemUtils.isJavaVersionAtLeast(JAVA_1_4); 
     final String expectedStringValue = System.getProperty("java.awt.headless"); 
     final String expectedStringValueWithDefault = System.getProperty("java.awt.headless", "false"); 
     assertNotNull(expectedStringValueWithDefault); 
     if (atLeastJava14) { 
         final boolean expectedValue = Boolean.valueOf(expectedStringValue).booleanValue(); 
         if (expectedStringValue != null) { 
             assertEquals(expectedStringValue, SystemUtils.JAVA_AWT_HEADLESS); 
         } 
         assertEquals(expectedValue, SystemUtils.isJavaAwtHeadless()); 
     } else { 
         assertNull(expectedStringValue); 
         assertNull(SystemUtils.JAVA_AWT_HEADLESS); 
         assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
     } 
     assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
 }
@Test
public void testGetJavaHome5504() { 
     final File dir = SystemUtils.getJavaHome(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testGetUserHome5706() { 
     final File dir = SystemUtils.getUserHome(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testOSMatchesName6226() { 
     String osName = null; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = ""; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows 95"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows NT"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "OS/2"; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
 }
@Test
public void testConstructor6521() { 
     assertNotNull(new SystemUtils()); 
     final Constructor<?>[] cons = SystemUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(SystemUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(SystemUtils.class.getModifiers())); 
 }
@Test
public void testGetJavaIoTmpDir6684() { 
     final File dir = SystemUtils.getJavaIoTmpDir(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testJavaVersionMatches7265() { 
     String javaVersion = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.0"; 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.3.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.1"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.4.2"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.5.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.6.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
     javaVersion = "1.7.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.1")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.2")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.3")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.4")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.5")); 
     assertFalse(SystemUtils.isJavaVersionMatch(javaVersion, "1.6")); 
     assertTrue(SystemUtils.isJavaVersionMatch(javaVersion, "1.7")); 
 }
@Test
public void testOSMatchesName7618() { 
     String osName = null; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = ""; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows 95"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "Windows NT"; 
     assertTrue(SystemUtils.isOSNameMatch(osName, "Windows")); 
     osName = "OS/2"; 
     assertFalse(SystemUtils.isOSNameMatch(osName, "Windows")); 
 }
@Test
public void testGetUserDir7628() { 
     final File dir = SystemUtils.getUserDir(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testJavaAwtHeadless9258() { 
     final boolean atLeastJava14 = SystemUtils.isJavaVersionAtLeast(JAVA_1_4); 
     final String expectedStringValue = System.getProperty("java.awt.headless"); 
     final String expectedStringValueWithDefault = System.getProperty("java.awt.headless", "false"); 
     assertNotNull(expectedStringValueWithDefault); 
     if (atLeastJava14) { 
         final boolean expectedValue = Boolean.valueOf(expectedStringValue).booleanValue(); 
         if (expectedStringValue != null) { 
             assertEquals(expectedStringValue, SystemUtils.JAVA_AWT_HEADLESS); 
         } 
         assertEquals(expectedValue, SystemUtils.isJavaAwtHeadless()); 
     } else { 
         assertNull(expectedStringValue); 
         assertNull(SystemUtils.JAVA_AWT_HEADLESS); 
         assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
     } 
     assertEquals(expectedStringValueWithDefault, "" + SystemUtils.isJavaAwtHeadless()); 
 }
@Test
public void testToString9681() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new String[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString12479() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString12480() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString12481() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    

    

    

    

    

    
}
