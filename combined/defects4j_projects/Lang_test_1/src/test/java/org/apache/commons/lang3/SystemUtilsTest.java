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
public void testHeadless300() { 
     assertFalse(SystemUtils.isJavaAwtHeadless()); 
     final boolean headless = SystemUtils.isJavaAwtHeadless(); 
     assertTrue(headless); 
     assertFalse(SystemUtils.isJavaAwtHeadless()); 
 }
@Test
public void testJavaVersionMatches303() { 
     String version = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.2")); 
     version = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.5")); 
     version = "1.6"; 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "1.7")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "1.8")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "9")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "10")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "11")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "12")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "13")); 
 }
@Test
public void testMatchesJavaVersion304() { 
     String version = null; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.2")); 
     version = ""; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.5")); 
     version = "4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.5")); 
     version = "4.0"; 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "1.6")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "1.5")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "7.1")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "8.0")); 
     assertTrue(SystemUtils.isJavaVersionMatch(version, "9.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "10.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "11.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "12.0")); 
     assertFalse(SystemUtils.isJavaVersionMatch(version, "13.0")); 
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
