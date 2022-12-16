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
import static org.apache.commons.lang3.JavaVersion.JAVA_0_9;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_1;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_2;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_3;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_4;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_5;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_6;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_7;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_8;
import static org.apache.commons.lang3.JavaVersion.get;
import static org.apache.commons.lang3.JavaVersion.getJavaVersion;

/**
 * Unit tests {@link org.apache.commons.lang3.JavaVersion}.
 *
 * @version $Id: JavaVersionTest.java 918366 2010-03-03 08:56:22Z bayard $
 */
public class JavaVersionTest {

@Test
public void testGet75() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("2.4", JAVA_2_4); 
     assertEquals("2.0", JAVA_1_2); 
     assertEquals("2.1", JAVA_1_3); 
     assertEquals("2.2", JAVA_2_4); 
     assertEquals("3.4", JAVA_1_7); 
     assertEquals("1.0", JAVA_1_0); 
     assert
@Test
public void testJavaVersions386() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_5); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.10", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_13); 
     assertEquals("1.16", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.10", JAVA_1_13); 
     assertEquals("1.12", JAVA_1_13); 
     assertEquals("1.13", JAVA_1_14);
@Test
public void testGetJavaVersion387() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_2); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
 }
@Test
public void testGet388() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_9); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.12", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_13); 
     assertEquals("1.16", JAVA_1_14); 
     assertEquals("1.12", JAVA_1_13); 
     assert
@Test
public void testJavaVersion389() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_4); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_13); 
     assertEquals("1.13", JAVA_1_14); 
     assertEquals("1.14", JAVA_1_13);
@Test
public void testGet390() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_4.get(JAVA_1_2)); 
     assertEquals("1.3", JAVA_1_3, JAVA_1_4.get(JAVA_1_3)); 
     assertEquals("1.2", JAVA_1_2, JAVA_1_4.get(JAVA_1_2)); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4.get(JAVA_1_3)); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_4.get(JAVA_1_5)); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_4.get(JAVA_1_5)); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.0", JAVA_1_4.get(null)); 
     assertEquals("1.0", JAVA_1_4.get(null)); 
 }
@Test
public void testJavaVersion391() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_9); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.12", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
 }
@Test
public void testGet392() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_2); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("2.4", JAVA_2_4); 
     assertEquals("2.0", JAVA_1_2); 
     assertEquals("2.1", JAVA_1_3); 
     assertEquals("2.2", JAVA_2_4); 
     assertEquals("1.7", JAVA_1_4); 
     assertEquals("1.8", JAVA_1_9); 
     assert
@Test
public void testGet393() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_4.get(JAVA_1_2)); 
     assertEquals("1.3", JAVA_1_3, JAVA_1_4.get(JAVA_1_3)); 
     assertEquals("1.2", JAVA_1_2, JAVA_1_4.get(JAVA_1_2)); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4.get(JAVA_1_3)); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_4.get(JAVA_1_5)); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_4.get(JAVA_1_5)); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_8); 
     assertEquals("1.8", JAVA_1_9); 
     assertEquals("1.9", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_
@Test
public void testJavaVersion394() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("2.4", JAVA_2_4); 
     assertEquals("2.0", JAVA_1_2); 
     assertEquals("2.1", JAVA_1_3); 
     assertEquals("2.2", JAVA_2_4); 
     assertEquals("1.7", JAVA_1_8); 
     assertEquals("1.8", JAVA_1_9);
@Test
public void testJavaVersion395() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("2.4", JAVA_2_4); 
     assertEquals("2.0", JAVA_1_2); 
     assertEquals("2.1", JAVA_1_3); 
     assertEquals("2.2", JAVA_2_4); 
     assertEquals("1.7", JAVA_1_4); 
     assertEquals("1.8", JAVA_1_9);
@Test
public void testGet396() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.18", JAVA_1_18); 
     assertEquals("1.10", JAVA_1_13); 
     assertEquals("1.12", JAVA_1_14); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assert
@Test
public void testGet397() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.A", JAVA_1_A); 
     assertEquals("1.0", JAVA_1_0); 
     assertEquals("1.1", JAVA_1_1); 
     assertEquals("1.2", JAVA_1_2); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.12", JAVA_1_13); 
     assertEquals("1.13", JAVA_1_14); 
     assert
@Test
public void testJavaVersionLong398() { 
     assertEquals(1L, JAVA_1_2.getJavaVersion()); 
     assertEquals(1L, JAVA_1_3.getJavaVersion()); 
     assertEquals(1L, JAVA_1_4.getJavaVersion()); 
     assertEquals(1L, JAVA_1_5.getJavaVersion()); 
     assertEquals(1L, JAVA_1_6.getJavaVersion()); 
     assertEquals(1L, JAVA_1_7.getJavaVersion()); 
     assertEquals(1L, JAVA_1_8.getJavaVersion()); 
     assertEquals(1L, JAVA_1_9.getJavaVersion()); 
     assertEquals(1L, JAVA_1_10.getJavaVersion()); 
     assertEquals(1L, JAVA_1_11.getJavaVersion()); 
     assertEquals(1L, JAVA_1_12.getJavaVersion()); 
     assertEquals(1L, JAVA_1_13.getJavaVersion()); 
     assertEquals(1L, JAVA_1_14.getJavaVersion()); 
     assertEquals(1L, JAVA_1_15.getJavaVersion()); 
     assertEquals(1L, JAVA_1_11.getJavaVersion()); 
     assertEquals(1L, JAVA_1_12.getJavaVersion()); 
     assertEquals(1L, JAVA_1_13.getJavaVersion()); 
     assertEquals(1L, JAVA_1_14.getJavaVersion()); 
 }
@Test
public void testGet399() { 
     assertEquals("1.2", JAVA_1_2, JAVA_1_4); 
     assertEquals("1.3", JAVA_1_3); 
     assertEquals("1.4", JAVA_1_4); 
     assertEquals("1.5", JAVA_1_5); 
     assertEquals("1.6", JAVA_1_6); 
     assertEquals("1.7", JAVA_1_7); 
     assertEquals("1.8", JAVA_1_8); 
     assertEquals("1.9", JAVA_1_9); 
     assertEquals("1.10", JAVA_1_9); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.10", JAVA_1_10); 
     assertEquals("1.11", JAVA_1_11); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_15); 
     assertEquals("1.16", JAVA_1_16); 
     assertEquals("1.12", JAVA_1_12); 
     assertEquals("1.13", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_13); 
     assertEquals("1.14", JAVA_1_14); 
     assertEquals("1.15", JAVA_1_13); 
     assertEquals("1.16", JAVA_1_14); 
     assertEquals("1.12", JAVA_1_13); 
     assert
    

    

    

}
