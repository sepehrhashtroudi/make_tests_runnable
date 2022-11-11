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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

/**
 * 
 * @version $Id$
 */
public class EnumUtilsTest {

@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVector_nullElement24() { 
     EnumUtils.generateBitVector(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable165() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_getEnum_nullClass370() { 
     EnumUtils.getEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test(expected = NullPointerException.class) 
 public void test_isEnum_nullClass572() { 
     EnumUtils.isValidEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void test_generateBitVectorsFromArray641() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test
public void test_generateBitVectorsFromArray686() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement737() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_generateBitVectorsFromArray990() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test(expected = NullPointerException.class) 
 public void test_isEnum_nullClass1063() { 
     EnumUtils.isValidEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void test_isEnum1090() { 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "RED")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "AMBER")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "GREEN")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, "PURPLE")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable1092() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_getEnum_nullClass1179() { 
     EnumUtils.getEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void test_generateBitVectorsFromArray1285() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable1346() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement1431() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_getEnumMap1569() { 
     final Map<String, Traffic> test = EnumUtils.getEnumMap(Traffic.class); 
     assertEquals("getEnumMap not created correctly", "{RED=RED, AMBER=AMBER, GREEN=GREEN}", test.toString()); 
     assertEquals(3, test.size()); 
     assertTrue(test.containsKey("RED")); 
     assertEquals(Traffic.RED, test.get("RED")); 
     assertTrue(test.containsKey("AMBER")); 
     assertEquals(Traffic.AMBER, test.get("AMBER")); 
     assertTrue(test.containsKey("GREEN")); 
     assertEquals(Traffic.GREEN, test.get("GREEN")); 
     assertFalse(test.containsKey("PURPLE")); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullClassWithArray1666() { 
     EnumUtils.generateBitVector(null, Traffic.RED); 
 }
@Test
public void test_isEnum1708() { 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "RED")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "AMBER")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "GREEN")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, "PURPLE")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, null)); 
 }
@Test
public void test_processBitVector1720() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_isEnum_nullClass1755() { 
     EnumUtils.isValidEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void testConstructable2093() { 
     new EnumUtils(); 
 }
@Test
public void test_generateBitVector2172() { 
     assertEquals(0L, EnumUtils.generateBitVector(Traffic.class, EnumSet.noneOf(Traffic.class))); 
     assertEquals(1L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.RED))); 
     assertEquals(2L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.AMBER))); 
     assertEquals(4L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.GREEN))); 
     assertEquals(3L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER))); 
     assertEquals(5L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN))); 
     assertEquals(6L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN))); 
     assertEquals(7L, EnumUtils.generateBitVector(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN))); 
 }
@Test
public void test_generateBitVectorsFromArray2391() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test
public void test_getEnum2418() { 
     assertEquals(Traffic.RED, EnumUtils.getEnum(Traffic.class, "RED")); 
     assertEquals(Traffic.AMBER, EnumUtils.getEnum(Traffic.class, "AMBER")); 
     assertEquals(Traffic.GREEN, EnumUtils.getEnum(Traffic.class, "GREEN")); 
     assertEquals(null, EnumUtils.getEnum(Traffic.class, "PURPLE")); 
     assertEquals(null, EnumUtils.getEnum(Traffic.class, null)); 
 }
@Test
public void test_getEnum2507() { 
     assertEquals(Traffic.RED, EnumUtils.getEnum(Traffic.class, "RED")); 
     assertEquals(Traffic.AMBER, EnumUtils.getEnum(Traffic.class, "AMBER")); 
     assertEquals(Traffic.GREEN, EnumUtils.getEnum(Traffic.class, "GREEN")); 
     assertEquals(null, EnumUtils.getEnum(Traffic.class, "PURPLE")); 
     assertEquals(null, EnumUtils.getEnum(Traffic.class, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable2509() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVectors_nullArray2539() { 
     EnumUtils.generateBitVectors(Traffic.class, (Traffic[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVector_nullElement2558() { 
     EnumUtils.generateBitVector(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable2925() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullClassWithArray3272() { 
     EnumUtils.generateBitVector(null, Traffic.RED); 
 }
@Test
public void test_processBitVector3374() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test
public void test_getEnumMap3958() { 
     final Map<String, Traffic> test = EnumUtils.getEnumMap(Traffic.class); 
     assertEquals("getEnumMap not created correctly", "{RED=RED, AMBER=AMBER, GREEN=GREEN}", test.toString()); 
     assertEquals(3, test.size()); 
     assertTrue(test.containsKey("RED")); 
     assertEquals(Traffic.RED, test.get("RED")); 
     assertTrue(test.containsKey("AMBER")); 
     assertEquals(Traffic.AMBER, test.get("AMBER")); 
     assertTrue(test.containsKey("GREEN")); 
     assertEquals(Traffic.GREEN, test.get("GREEN")); 
     assertFalse(test.containsKey("PURPLE")); 
 }
@Test
public void test_processBitVector4132() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVectors_nullArray4196() { 
     EnumUtils.generateBitVectors(Traffic.class, (Traffic[]) null); 
 }
@Test
public void test_generateBitVectorsFromArray4208() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement4507() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_processBitVector_longClass4569() { 
     EnumUtils.processBitVector(TooMany.class, 0L); 
 }
@Test
public void test_processBitVector4582() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test
public void test_getEnumMap4608() { 
     final Map<String, Traffic> test = EnumUtils.getEnumMap(Traffic.class); 
     assertEquals("getEnumMap not created correctly", "{RED=RED, AMBER=AMBER, GREEN=GREEN}", test.toString()); 
     assertEquals(3, test.size()); 
     assertTrue(test.containsKey("RED")); 
     assertEquals(Traffic.RED, test.get("RED")); 
     assertTrue(test.containsKey("AMBER")); 
     assertEquals(Traffic.AMBER, test.get("AMBER")); 
     assertTrue(test.containsKey("GREEN")); 
     assertEquals(Traffic.GREEN, test.get("GREEN")); 
     assertFalse(test.containsKey("PURPLE")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement4676() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_generateBitVectorsFromArray4719() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.GREEN), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.GREEN), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.AMBER, Traffic.GREEN), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN), 7L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, Traffic.RED, Traffic.AMBER, Traffic.GREEN, Traffic.GREEN), 7L); 
 }
@Test
public void test_generateBitVectors4751() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.noneOf(Traffic.class)), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED)), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER)), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.GREEN)), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER)), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN)), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN)), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN)), 7L); 
 }
@Test(expected = NullPointerException.class) 
 public void test_isEnum_nullClass4955() { 
     EnumUtils.isValidEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVector_nullElement5106() { 
     EnumUtils.generateBitVector(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable5129() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test
public void test_generateBitVectors5322() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.noneOf(Traffic.class)), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED)), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER)), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.GREEN)), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER)), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN)), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN)), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN)), 7L); 
 }
@Test
public void test_processBitVector5415() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test
public void test_generateBitVectors5528() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.noneOf(Traffic.class)), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED)), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER)), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.GREEN)), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER)), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN)), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN)), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN)), 7L); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement5561() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_getEnumMap5720() { 
     final Map<String, Traffic> test = EnumUtils.getEnumMap(Traffic.class); 
     assertEquals("getEnumMap not created correctly", "{RED=RED, AMBER=AMBER, GREEN=GREEN}", test.toString()); 
     assertEquals(3, test.size()); 
     assertTrue(test.containsKey("RED")); 
     assertEquals(Traffic.RED, test.get("RED")); 
     assertTrue(test.containsKey("AMBER")); 
     assertEquals(Traffic.AMBER, test.get("AMBER")); 
     assertTrue(test.containsKey("GREEN")); 
     assertEquals(Traffic.GREEN, test.get("GREEN")); 
     assertFalse(test.containsKey("PURPLE")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_processBitVector_longClass5928() { 
     EnumUtils.processBitVector(TooMany.class, 0L); 
 }
@Test
public void test_generateBitVectors6416() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.noneOf(Traffic.class)), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED)), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER)), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.GREEN)), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER)), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN)), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN)), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN)), 7L); 
 }
@Test(expected = NullPointerException.class) 
 public void test_getEnum_nullClass6604() { 
     EnumUtils.getEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void test_generateBitVectors6722() { 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.noneOf(Traffic.class)), 0L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED)), 1L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER)), 2L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.GREEN)), 4L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER)), 3L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.GREEN)), 5L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.AMBER, Traffic.GREEN)), 6L); 
     assertArrayEquals(EnumUtils.generateBitVectors(Traffic.class, EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN)), 7L); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVector_nullElement6766() { 
     EnumUtils.generateBitVector(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable6779() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement7242() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_isEnum7267() { 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "RED")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "AMBER")); 
     assertTrue(EnumUtils.isValidEnum(Traffic.class, "GREEN")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, "PURPLE")); 
     assertFalse(EnumUtils.isValidEnum(Traffic.class, null)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable7282() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_getEnum_nullClass7423() { 
     EnumUtils.getEnum((Class<Traffic>) null, "PURPLE"); 
 }
@Test
public void test_processBitVector7534() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVectors_nullArray7677() { 
     EnumUtils.generateBitVectors(Traffic.class, (Traffic[]) null); 
 }
@Test
public void test_processBitVector7760() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void test_generateBitVectors_nullElement8103() { 
     EnumUtils.generateBitVectors(Traffic.class, Arrays.asList(Traffic.RED, null)); 
 }
@Test
public void test_processBitVector8363() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test
public void test_processBitVector8453() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullClassWithArray8729() { 
     EnumUtils.generateBitVector(null, Traffic.RED); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable8756() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable8977() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test
public void test_getEnumList9016() { 
     final List<Traffic> test = EnumUtils.getEnumList(Traffic.class); 
     assertEquals(3, test.size()); 
     assertEquals(Traffic.RED, test.get(0)); 
     assertEquals(Traffic.AMBER, test.get(1)); 
     assertEquals(Traffic.GREEN, test.get(2)); 
 }
@Test
public void test_processBitVector9278() { 
     assertEquals(EnumSet.noneOf(Traffic.class), EnumUtils.processBitVector(Traffic.class, 0L)); 
     assertEquals(EnumSet.of(Traffic.RED), EnumUtils.processBitVector(Traffic.class, 1L)); 
     assertEquals(EnumSet.of(Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 2L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER), EnumUtils.processBitVector(Traffic.class, 3L)); 
     assertEquals(EnumSet.of(Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 4L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 5L)); 
     assertEquals(EnumSet.of(Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 6L)); 
     assertEquals(EnumSet.of(Traffic.RED, Traffic.AMBER, Traffic.GREEN), EnumUtils.processBitVector(Traffic.class, 7L)); 
 }
@Test(expected = NullPointerException.class) 
 public void test_generateBitVector_nullIterable9376() { 
     EnumUtils.generateBitVector(Traffic.class, (Iterable<Traffic>) null); 
 }
@Test
public void test_getEnumMap9499() { 
     final Map<String, Traffic> test = EnumUtils.getEnumMap(Traffic.class); 
     assertEquals("getEnumMap not created correctly", "{RED=RED, AMBER=AMBER, GREEN=GREEN}", test.toString()); 
     assertEquals(3, test.size()); 
     assertTrue(test.containsKey("RED")); 
     assertEquals(Traffic.RED, test.get("RED")); 
     assertTrue(test.containsKey("AMBER")); 
     assertEquals(Traffic.AMBER, test.get("AMBER")); 
     assertTrue(test.containsKey("GREEN")); 
     assertEquals(Traffic.GREEN, test.get("GREEN")); 
     assertFalse(test.containsKey("PURPLE")); 
 }
@Test
public void test_getEnumList9544() { 
     final List<Traffic> test = EnumUtils.getEnumList(Traffic.class); 
     assertEquals(3, test.size()); 
     assertEquals(Traffic.RED, test.get(0)); 
     assertEquals(Traffic.AMBER, test.get(1)); 
     assertEquals(Traffic.GREEN, test.get(2)); 
 }
    

    

    

    

    

    

    

    

    
    
    

    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    

    

    
    
    
    
    

    
    
    

    

    
    
    

    private void assertArrayEquals(final long[] actual, final long... expected) {
        Assert.assertArrayEquals(expected, actual);
    }

    

    

    

    

    
    
    public void test_processBitVectors_longClass() {
        assertEquals(EnumSet.noneOf(TooMany.class), EnumUtils.processBitVectors(TooMany.class, 0L));
        assertEquals(EnumSet.of(TooMany.A), EnumUtils.processBitVectors(TooMany.class, 1L));
        assertEquals(EnumSet.of(TooMany.B), EnumUtils.processBitVectors(TooMany.class, 2L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B), EnumUtils.processBitVectors(TooMany.class, 3L));
        assertEquals(EnumSet.of(TooMany.C), EnumUtils.processBitVectors(TooMany.class, 4L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 5L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 6L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 7L));

        assertEquals(EnumSet.noneOf(TooMany.class), EnumUtils.processBitVectors(TooMany.class, 0L, 0L));
        assertEquals(EnumSet.of(TooMany.A), EnumUtils.processBitVectors(TooMany.class, 0L, 1L));
        assertEquals(EnumSet.of(TooMany.B), EnumUtils.processBitVectors(TooMany.class, 0L, 2L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B), EnumUtils.processBitVectors(TooMany.class, 0L, 3L));
        assertEquals(EnumSet.of(TooMany.C), EnumUtils.processBitVectors(TooMany.class, 0L, 4L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 0L, 5L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 0L, 6L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 0L, 7L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C), EnumUtils.processBitVectors(TooMany.class, 0L, 7L));

        assertEquals(EnumSet.of(TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 0L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 1L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 2L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 3L));
        assertEquals(EnumSet.of(TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 4L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 5L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 6L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 7L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 1L, 7L));

        // demonstrate tolerance of irrelevant high-order digits:
        assertEquals(EnumSet.of(TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 0L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 1L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 2L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 3L));
        assertEquals(EnumSet.of(TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 4L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 5L));
        assertEquals(EnumSet.of(TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 6L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 7L));
        assertEquals(EnumSet.of(TooMany.A, TooMany.B, TooMany.C, TooMany.M2), EnumUtils.processBitVectors(TooMany.class, 9L, 7L));
    }

}

enum Traffic {
    RED, AMBER, GREEN
}

enum TooMany {
    A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z,
    A1,B1,C1,D1,E1,F1,G1,H1,I1,J1,K1,L1,M1,N1,O1,P1,Q1,R1,S1,T1,U1,V1,W1,X1,Y1,Z1,
    A2,B2,C2,D2,E2,F2,G2,H2,I2,J2,K2,L2,M2;
}
