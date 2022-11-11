/*******************************************************************************
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
 *******************************************************************************/
package org.apache.commons.lang3;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.UUID;

import org.junit.Test;


/**
 * Unit tests {@link Conversion}.
 * 
 * @version $Id$
 */
public class ConversionTest {

    /**
     * Tests {@link Conversion#hexDigitToInt(char)}.
     */
@Test
public void testHexToInt14() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt51() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToLong682() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0)); 
         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0)); 
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
         assertEquals( 
             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
         assertEquals( 
             0x123456789ABCDEF0L, 
             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}. 
      */
//@Test
//public void testHexToLong683() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 4));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 1));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong684() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 4));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 1));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong685() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789A7856785678L, Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#hexToLong(String, int, long, int, int)}.
//      */
//@Test
//public void testHexToLong686() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 4));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 1));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong688() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong689() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong690() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong693() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong694() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#hexToLong(String, int, long, int, int)}.
//      */
//@Test
//public void testHexToLong695() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 1));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 2));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L,
//             Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 24, 1));
//         assertEquals(
//             0x123456789ABCDEF0L,
//             Conversion.hexToLong(src, 7, 0x123456789ABCDEF0L, 8, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
//@Test
//public void testHexToLong696() {
//         final String src = "CDF1F0C10F12345678";
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 0, 0));
//         assertEquals(0x0000000000000000L, Conversion.hexToLong(src, 0, 0L, 100, 0));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0L, 0, 4));
//         assertEquals(0x00000000CDF1F0C10F12345678L, Conversion.hexToLong(src, 1, 0L, 0, 0));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 0));
//         assertEquals(
//             0x12345678CDF1F0C10F12345678L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 1));
//         assertEquals(
//             0x123456789ABCDEF0L, Conversion.hexToLong(src, 0, 0x123456789ABCDEF0L, 0, 2));
//     }
//
//     /**
//      * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
//      */
@Test
public void testHexToInt697() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt698() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt699() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt700() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt701() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt702() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt703() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt704() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt705() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 2)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 2)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
@Test
public void testHexToInt706() { 
         final String src = "CDF1F0C10F12345678"; 
         assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
         assertEquals(0x0000000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
         assertEquals(0x1C0F1, Conversion.hexToInt(src, 0, 0, 0, 4)); 
         assertEquals(0x1FDC, Conversion.hexToInt(src, 1, 0, 0, 4)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 0, 0x12345678, 24, 1)); 
         assertEquals(0x12345678, Conversion.hexToInt(src, 15, 0x12345678, 16, 2)); 
     } 
  
     /** 
      * Tests {@link Conversion#hexToShort(String, int, short, int, int)}. 
      */
    

    /**
     * Tests {@link Conversion#hexDigitMsb0ToInt(char)}.
     */
    

    /**
     * Tests {@link Conversion#hexDigitToBinary(char)}.
     */
    

    /**
     * Tests {@link Conversion#hexDigitMsb0ToBinary(char)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToHexDigit(boolean[])}.
     */
    

    /**
     * Tests {@link Conversion#binaryBeMsb0ToHexDigit(boolean[], int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToHexDigitMsb0_4bits(boolean[])}.
     */
    

    /**
     * Tests {@link Conversion#binaryToHexDigitMsb0_4bits(boolean[], int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToHexDigit(boolean[])}.
     */
    

    /**
     * Tests {@link Conversion#binaryToHexDigit(boolean[], int)}.
     */
    

    /**
     * Tests {@link Conversion#intToHexDigit(int)}.
     */
    

    /**
     * Tests {@link Conversion#intToHexDigitMsb0(int)}.
     */
    

    static String dbgPrint(final boolean[] src) {
        final StringBuilder sb = new StringBuilder();
        for (final boolean e : src) {
            if (e) {
                sb.append("1,");
            } else {
                sb.append("0,");
            }
        }
        final String out = sb.toString();
        return out.substring(0, out.length() - 1);
    }

    // org.junit.Assert(boolean[], boolean[]) does not exist in JUnit 4.2
    static void assertBinaryEquals(final boolean[] expected, final boolean[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; i++ ) {
            try {
                assertEquals(expected[i], actual[i]);
            } catch (final Throwable e) {
                final String msg = "Mismatch at index "
                    + i
                    + " between:\n"
                    + dbgPrint(expected)
                    + " and\n"
                    + dbgPrint(actual);
                fail(msg + "\n" + e.getMessage());
            }
        }
    }

    /**
     * Tests {@link Conversion#intArrayToLong(int[], int, long, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#shortArrayToLong(short[], int, long, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteArrayToLong(byte[], int, long, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#shortArrayToInt(short[], int, int, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteArrayToInt(byte[], int, int, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteArrayToShort(byte[], int, short, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#hexToLong(String, int, long, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#hexToInt(String, int, int, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#hexToShort(String, int, short, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#hexToByte(String, int, byte, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToLong(boolean[], int, long, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToInt(boolean[], int, int, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToShort(boolean[], int, short, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#binaryToByte(boolean[], int, byte, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#longToIntArray(long, int, int[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#longToShortArray(long, int, short[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#intToShortArray(int, int, short[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#longToByteArray(long, int, byte[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#intToByteArray(int, int, byte[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#shortToByteArray(short, int, byte[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#longToHex(long, int, String, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#intToHex(int, int, String, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#shortToHex(short, int, String, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteToHex(byte, int, String, int, int)}.
     */
    

    /**
     * Tests {@link Conversion#longToBinary(long, int, boolean[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#intToBinary(int, int, boolean[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#shortToBinary(short, int, boolean[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteToBinary(byte, int, boolean[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#uuidToByteArray(UUID, byte[], int, int)}.
     */
    

    /**
     * Tests {@link Conversion#byteArrayToUuid(byte[], int)}.
     */
    
}
