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
public void testGetJavaHome289() { 
     final File dir = SystemUtils.getJavaHome(); 
     Assert.assertNotNull(dir); 
     Assert.assertTrue(dir.exists()); 
 }
@Test
public void testOSNameMatches291() { 
     assertFalse(SystemUtils.isOSNameMatch(null, "1")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "1")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "2")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "3")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "4")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "5")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "6")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "7")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "8")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "9")); 
     assertFalse(SystemUtils.isOSNameMatch("1", "10")); 
 }
@Test
public void testOSNameMatches292() { 
     assertFalse(SystemUtils.isOSNameMatch(null, "1.0")); 
     assertFalse(SystemUtils.isOSNameMatch("1.1", "1.1")); 
     assertFalse(SystemUtils.isOSNameMatch("1.2", "1.2")); 
     assertFalse(SystemUtils.isOSNameMatch("1.3", "1.3")); 
     assertFalse(SystemUtils.isOSNameMatch("1.4", "1.4")); 
     assertFalse(SystemUtils.isOSNameMatch("1.5", "1.5")); 
     assertFalse(SystemUtils.isOSNameMatch("1.6", "1.6")); 
     assertFalse(SystemUtils.isOSNameMatch("1.7", "1.7")); 
     assertFalse(SystemUtils.isOSNameMatch("1.8", "1.8")); 
     assertFalse(SystemUtils.isOSNameMatch("1.9", "1.9")); 
     assertFalse(SystemUtils.isOSNameMatch("1.10", "1.10")); 
     assertFalse(SystemUtils.isOSNameMatch("1.11", "1.11")); 
     assertFalse(SystemUtils.isOSNameMatch("1.12", "1.12")); 
     assertFalse(SystemUtils.isOSNameMatch("1.13", "1.13")); 
     assertFalse(SystemUtils.isOSNameMatch("1.14", "1.14")); 
     assertFalse(SystemUtils.isOSNameMatch("1.15", "1.15")); 
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
