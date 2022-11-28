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
public void testHexToByte7() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit52() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToShort72() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testBinaryToInt81() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testBinaryToByte83() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testBinaryToLong113() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testIntToShortArray121() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testShortToBinary150() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testIntToHexDigitMsb0178() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToShortArray207() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testByteArrayToLong209() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryToLong217() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testByteToHex253() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb0297() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToBinary322() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testHexDigitToBinary355() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb0380() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToHex387() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteToBinary429() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testIntToHex435() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToHex456() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteArrayToLong458() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit485() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToLong498() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testHexDigitToBinary513() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigit539() { 
     assertEquals('0', Conversion.intToHexDigit(0)); 
     assertEquals('1', Conversion.intToHexDigit(1)); 
     assertEquals('2', Conversion.intToHexDigit(2)); 
     assertEquals('3', Conversion.intToHexDigit(3)); 
     assertEquals('4', Conversion.intToHexDigit(4)); 
     assertEquals('5', Conversion.intToHexDigit(5)); 
     assertEquals('6', Conversion.intToHexDigit(6)); 
     assertEquals('7', Conversion.intToHexDigit(7)); 
     assertEquals('8', Conversion.intToHexDigit(8)); 
     assertEquals('9', Conversion.intToHexDigit(9)); 
     assertEquals('a', Conversion.intToHexDigit(10)); 
     assertEquals('b', Conversion.intToHexDigit(11)); 
     assertEquals('c', Conversion.intToHexDigit(12)); 
     assertEquals('d', Conversion.intToHexDigit(13)); 
     assertEquals('e', Conversion.intToHexDigit(14)); 
     assertEquals('f', Conversion.intToHexDigit(15)); 
     try { 
         Conversion.intToHexDigit(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong550() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testIntToBinary551() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit556() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToHex578() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteToHex601() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigit684() { 
     assertEquals('0', Conversion.intToHexDigit(0)); 
     assertEquals('1', Conversion.intToHexDigit(1)); 
     assertEquals('2', Conversion.intToHexDigit(2)); 
     assertEquals('3', Conversion.intToHexDigit(3)); 
     assertEquals('4', Conversion.intToHexDigit(4)); 
     assertEquals('5', Conversion.intToHexDigit(5)); 
     assertEquals('6', Conversion.intToHexDigit(6)); 
     assertEquals('7', Conversion.intToHexDigit(7)); 
     assertEquals('8', Conversion.intToHexDigit(8)); 
     assertEquals('9', Conversion.intToHexDigit(9)); 
     assertEquals('a', Conversion.intToHexDigit(10)); 
     assertEquals('b', Conversion.intToHexDigit(11)); 
     assertEquals('c', Conversion.intToHexDigit(12)); 
     assertEquals('d', Conversion.intToHexDigit(13)); 
     assertEquals('e', Conversion.intToHexDigit(14)); 
     assertEquals('f', Conversion.intToHexDigit(15)); 
     try { 
         Conversion.intToHexDigit(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortArrayToInt745() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testBinaryToLong811() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testIntToBinary823() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testByteArrayToShort857() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testShortToHex864() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteToHex899() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToHex920() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToByteArray931() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testUuidToByteArray950() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testHexDigitToBinary988() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToUuid996() { 
     assertEquals(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), Conversion.byteArrayToUuid(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { 0, 0, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 2)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit1034() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb01045() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortArrayToInt1049() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testLongToByteArray1077() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testByteArrayToShort1084() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit1087() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToBinary1089() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testByteArrayToShort1105() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testBinaryToByte1124() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testIntToByteArray1152() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testLongToByteArray1163() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testIntToHexDigit1175() { 
     assertEquals('0', Conversion.intToHexDigit(0)); 
     assertEquals('1', Conversion.intToHexDigit(1)); 
     assertEquals('2', Conversion.intToHexDigit(2)); 
     assertEquals('3', Conversion.intToHexDigit(3)); 
     assertEquals('4', Conversion.intToHexDigit(4)); 
     assertEquals('5', Conversion.intToHexDigit(5)); 
     assertEquals('6', Conversion.intToHexDigit(6)); 
     assertEquals('7', Conversion.intToHexDigit(7)); 
     assertEquals('8', Conversion.intToHexDigit(8)); 
     assertEquals('9', Conversion.intToHexDigit(9)); 
     assertEquals('a', Conversion.intToHexDigit(10)); 
     assertEquals('b', Conversion.intToHexDigit(11)); 
     assertEquals('c', Conversion.intToHexDigit(12)); 
     assertEquals('d', Conversion.intToHexDigit(13)); 
     assertEquals('e', Conversion.intToHexDigit(14)); 
     assertEquals('f', Conversion.intToHexDigit(15)); 
     try { 
         Conversion.intToHexDigit(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb01186() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToByte1201() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testIntToBinary1337() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testLongToBinary1339() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testHexDigitToBinary1359() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToBinary1388() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit1390() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToByteArray1427() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testLongToHex1435() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteArrayToShort1436() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testLongToBinary1493() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testBinaryToShort1519() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testBinaryToShort1543() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testLongToShortArray1549() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testByteToHex1610() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortArrayToLong1650() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testUuidToByteArray1663() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testBinaryToInt1670() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testShortToBinary1678() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testByteArrayToLong1680() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testIntToByteArray1751() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testIntToHexDigitMsb01821() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToBinary1846() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testByteArrayToLong1869() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit1877() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit1880() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary1886() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary1908() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt1920() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testByteArrayToLong1931() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testIntArrayToLong1993() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testLongToHex1999() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToShortArray2003() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testLongToShortArray2043() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testHexToByte2073() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testIntArrayToLong2114() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testLongToHex2120() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryToByte2123() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testBinaryToInt2130() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testShortToHex2139() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testUuidToByteArray2169() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testIntToHexDigitMsb02170() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong2178() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testIntToHex2207() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteToHex2221() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryToInt2280() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testHexToShort2293() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testHexToShort2307() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testIntToHexDigitMsb02335() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHex2350() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb02355() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToByteArray2414() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testIntToHexDigitMsb02415() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToShort2416() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testUuidToByteArray2454() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testShortArrayToInt2477() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit2484() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToLong2501() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testHexDigitToBinary2555() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToUuid2557() { 
     assertEquals(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), Conversion.byteArrayToUuid(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { 0, 0, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 2)); 
 }
@Test
public void testLongToShortArray2575() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testShortArrayToInt2611() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testIntToHex2703() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortArrayToLong2723() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testBinaryToByte2724() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testBinaryToLong2728() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testShortToByteArray2750() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit2764() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit2781() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToHex2875() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToHex2881() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToByteArray2886() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit2921() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortArrayToLong2930() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testBinaryToInt2953() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testIntToBinary2964() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testLongToHex2982() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToByteArray3016() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testByteArrayToLong3027() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testShortArrayToLong3043() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testLongToHex3069() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb03074() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToByte3081() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testIntToHexDigitMsb03094() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToBinary3109() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testLongToIntArray3120() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testShortArrayToInt3129() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testByteToBinary3130() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testShortToHex3134() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToHex3171() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryToInt3198() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testBinaryToByte3204() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testByteArrayToInt3212() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testBinaryToLong3232() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testIntToHexDigitMsb03238() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToHex3241() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary3277() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit3282() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigit3334() { 
     assertEquals('0', Conversion.intToHexDigit(0)); 
     assertEquals('1', Conversion.intToHexDigit(1)); 
     assertEquals('2', Conversion.intToHexDigit(2)); 
     assertEquals('3', Conversion.intToHexDigit(3)); 
     assertEquals('4', Conversion.intToHexDigit(4)); 
     assertEquals('5', Conversion.intToHexDigit(5)); 
     assertEquals('6', Conversion.intToHexDigit(6)); 
     assertEquals('7', Conversion.intToHexDigit(7)); 
     assertEquals('8', Conversion.intToHexDigit(8)); 
     assertEquals('9', Conversion.intToHexDigit(9)); 
     assertEquals('a', Conversion.intToHexDigit(10)); 
     assertEquals('b', Conversion.intToHexDigit(11)); 
     assertEquals('c', Conversion.intToHexDigit(12)); 
     assertEquals('d', Conversion.intToHexDigit(13)); 
     assertEquals('e', Conversion.intToHexDigit(14)); 
     assertEquals('f', Conversion.intToHexDigit(15)); 
     try { 
         Conversion.intToHexDigit(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToHex3364() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToByteArray3371() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testIntToByteArray3404() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testHexToByte3408() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testShortArrayToInt3438() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testShortToBinary3441() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testShortToHex3483() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit3527() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt3563() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testShortArrayToInt3660() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testIntToByteArray3661() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testHexToShort3676() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testByteArrayToShort3696() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testByteToHex3711() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteArrayToShort3759() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testByteArrayToShort3790() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit3792() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit3838() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortArrayToLong3876() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testHexToShort3877() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testHexDigitToBinary3932() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToShortArray3933() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testShortToHex3948() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteArrayToShort3949() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testIntToHex3980() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToHex4043() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToBinary4074() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testIntToHexDigitMsb04086() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary4108() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToByte4113() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testHexToShort4120() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testIntToHexDigitMsb04162() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHex4216() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToByteArray4236() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testByteToHex4245() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb04284() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary4309() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex4327() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4328() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary4337() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb04356() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary4379() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb04383() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigit4432() { 
     assertEquals('0', Conversion.intToHexDigit(0)); 
     assertEquals('1', Conversion.intToHexDigit(1)); 
     assertEquals('2', Conversion.intToHexDigit(2)); 
     assertEquals('3', Conversion.intToHexDigit(3)); 
     assertEquals('4', Conversion.intToHexDigit(4)); 
     assertEquals('5', Conversion.intToHexDigit(5)); 
     assertEquals('6', Conversion.intToHexDigit(6)); 
     assertEquals('7', Conversion.intToHexDigit(7)); 
     assertEquals('8', Conversion.intToHexDigit(8)); 
     assertEquals('9', Conversion.intToHexDigit(9)); 
     assertEquals('a', Conversion.intToHexDigit(10)); 
     assertEquals('b', Conversion.intToHexDigit(11)); 
     assertEquals('c', Conversion.intToHexDigit(12)); 
     assertEquals('d', Conversion.intToHexDigit(13)); 
     assertEquals('e', Conversion.intToHexDigit(14)); 
     assertEquals('f', Conversion.intToHexDigit(15)); 
     try { 
         Conversion.intToHexDigit(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToLong4446() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testHexDigitToBinary4452() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToHex4467() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryToLong4468() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testIntToHex4472() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryToByte4495() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testByteToBinary4564() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testShortToByteArray4624() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testByteArrayToUuid4670() { 
     assertEquals(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), Conversion.byteArrayToUuid(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 0)); 
     assertEquals(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), Conversion.byteArrayToUuid(new byte[] { 0, 0, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, 2)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4674() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToShort4681() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4686() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4694() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong4765() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testHexDigitToBinary4783() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToBinary4798() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4800() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToShort4814() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testBinaryToInt4842() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testBinaryToShort4894() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testBinaryToByte4927() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testLongToIntArray4963() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4978() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit4993() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb05017() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToByteArray5019() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testIntToHex5029() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary5057() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToInt5067() { 
     assertEquals(0, Conversion.hexDigitToInt('0')); 
     assertEquals(1, Conversion.hexDigitToInt('1')); 
     assertEquals(2, Conversion.hexDigitToInt('2')); 
     assertEquals(3, Conversion.hexDigitToInt('3')); 
     assertEquals(4, Conversion.hexDigitToInt('4')); 
     assertEquals(5, Conversion.hexDigitToInt('5')); 
     assertEquals(6, Conversion.hexDigitToInt('6')); 
     assertEquals(7, Conversion.hexDigitToInt('7')); 
     assertEquals(8, Conversion.hexDigitToInt('8')); 
     assertEquals(9, Conversion.hexDigitToInt('9')); 
     assertEquals(10, Conversion.hexDigitToInt('A')); 
     assertEquals(10, Conversion.hexDigitToInt('a')); 
     assertEquals(11, Conversion.hexDigitToInt('B')); 
     assertEquals(11, Conversion.hexDigitToInt('b')); 
     assertEquals(12, Conversion.hexDigitToInt('C')); 
     assertEquals(12, Conversion.hexDigitToInt('c')); 
     assertEquals(13, Conversion.hexDigitToInt('D')); 
     assertEquals(13, Conversion.hexDigitToInt('d')); 
     assertEquals(14, Conversion.hexDigitToInt('E')); 
     assertEquals(14, Conversion.hexDigitToInt('e')); 
     assertEquals(15, Conversion.hexDigitToInt('F')); 
     assertEquals(15, Conversion.hexDigitToInt('f')); 
     try { 
         Conversion.hexDigitToInt('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt5099() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testHexDigitToBinary5184() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToBinary5249() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testBinaryToLong5253() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testHexDigitToBinary5254() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit5260() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong5270() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testBinaryToLong5272() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testBinaryToShort5289() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testLongToHex5329() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToShortArray5376() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testShortToByteArray5386() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testHexDigitToBinary5395() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToBinary5402() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testHexDigitToBinary5405() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToInt5413() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testLongToShortArray5432() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testIntToShortArray5436() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testLongToHex5448() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit5473() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb05478() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit5488() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary5513() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary5523() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToByte5548() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testLongToBinary5550() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testShortToBinary5551() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testIntToHex5563() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary5587() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToByte5599() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testHexToShort5626() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testBinaryToShort5685() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testIntArrayToLong5705() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testLongToIntArray5823() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit5830() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToLong5891() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryToByte5892() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testIntToHexDigitMsb05963() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToBinary5985() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testShortArrayToLong5991() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testByteArrayToShort6001() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testIntToByteArray6042() { 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.intToByteArray(0x00000000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xFC, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.intToByteArray(0x90ABCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 3)); 
 }
@Test
public void testByteToBinary6092() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testBinaryToShort6119() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testLongToIntArray6132() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryToShort6168() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testBinaryToInt6177() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testByteArrayToShort6182() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testByteArrayToInt6189() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testIntArrayToLong6195() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit6212() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortArrayToLong6214() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testLongToHex6263() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteToHex6300() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexToByte6311() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testLongToShortArray6454() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit6456() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToHex6484() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit6527() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit6528() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary6552() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex6566() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHex6625() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb06647() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb06651() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb06670() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToLong6693() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testByteArrayToInt6714() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testByteArrayToInt6738() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testIntToHex6741() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToByteArray6757() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testHexDigitToBinary6770() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToShortArray6783() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testLongToHex6796() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToBinary6809() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testShortArrayToLong6830() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testHexDigitToBinary6878() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt6879() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testHexDigitToBinary6936() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToShort6954() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testShortArrayToInt6962() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testIntToHexDigitMsb06973() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToIntArray6974() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testByteArrayToInt6987() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testBinaryToByte7002() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testHexToShort7003() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testLongToBinary7019() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testHexDigitToBinary7049() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToBinary7056() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testLongToHex7108() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHex7126() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHex7232() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testByteArrayToInt7240() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testHexDigitToBinary7261() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary7284() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong7314() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testIntToShortArray7318() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testIntToHexDigitMsb07325() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit7369() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary7380() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToIntArray7419() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryToShort7442() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testIntToHexDigitMsb07450() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToByte7493() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((byte) 0x00, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 0 * 4)); 
     assertEquals((byte) 0x0C, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 1 * 4)); 
     assertEquals((byte) 0xDC, Conversion.binaryToByte(src, 0 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0xFD, Conversion.binaryToByte(src, 1 * 4, (byte) 0, 0, 2 * 4)); 
     assertEquals((byte) 0x34, Conversion.binaryToByte(src, 0 * 4, (byte) 0x34, 0, 0 * 4)); 
     assertEquals((byte) 0x84, Conversion.binaryToByte(src, 17 * 4, (byte) 0x34, 4, 1 * 4)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit7551() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntArrayToLong7559() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testLongToIntArray7565() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testLongToHex7566() { 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 100, "", 0, 0)); 
     assertEquals("", Conversion.longToHex(0x0000000000000000L, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba098765432fffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 15)); 
     assertEquals("fedcba0987654321ffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 0, 16)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDE3L, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba098765432ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("ffffedcba0987654321fffff", Conversion.longToHex(0x1234567890ABCDEFL, 0, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.longToHex(0x1234567890ABCDEFL, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb975121fca86420fffff", Conversion.longToHex(0x1234567890ABCDEFL, 3, "ffffffffffffffffffffffff", 3, 16)); 
     assertEquals("fffedcba0987654321ffffff", Conversion.longToHex(0x1234567890ABCDEFL, 4, "ffffffffffffffffffffffff", 3, 15)); 
     assertEquals("fedcba0987654321", Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 0, 16)); 
     try { 
         Conversion.longToHex(0x1234567890ABCDEFL, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb07584() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit7587() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToShort7610() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testHexDigitToBinary7611() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testUuidToByteArray7613() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testLongToByteArray7627() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testBinaryToLong7648() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testByteToHex7661() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortArrayToLong7686() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testIntArrayToLong7700() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testShortToHex7706() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary7742() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb07751() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary7753() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb07769() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt7824() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testShortArrayToLong7829() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit7856() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHex7857() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary7901() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToShort7975() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testHexDigitToBinary7981() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToByteArray7985() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testIntToHexDigitMsb07989() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToShort7992() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8095() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToInt8184() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000000CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xC1F0F1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x0FC1F0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCD345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 24, 1)); 
 }
@Test
public void testByteArrayToShort8217() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x00CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0xF1CD, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 2)); 
     assertEquals((short) 0xF0F1, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 2)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0xCD34, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 8, 1)); 
 }
@Test
public void testHexToByte8226() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8268() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8292() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToByte8301() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testLongToBinary8314() { 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.longToBinary(0x0000000000000000L, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 0, 64)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 0, new boolean[69], 2, 64)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 1, new boolean[69], 0, 63)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 0, 62)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, true, true, true, true, false, false, true, true, false, true, false, true, false, false, false, true, false, true, true, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.longToBinary(0x1234567890ABCDEFL, 2, new boolean[69], 3, 62)); 
 }
@Test
public void testHexToByte8328() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testBinaryToInt8334() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testIntToShortArray8366() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testUuidToByteArray8370() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testHexDigitToBinary8374() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testUuidToByteArray8377() { 
     assertArrayEquals(new byte[] { (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff, (byte) 0xff }, Conversion.uuidToByteArray(new UUID(0xFFFFFFFFFFFFFFFFL, 0xFFFFFFFFFFFFFFFFL), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x44, (byte) 0x55, (byte) 0x66, (byte) 0x77 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 0, 16)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x00, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 4, 8)); 
     assertArrayEquals(new byte[] { (byte) 0x00, (byte) 0x00, (byte) 0x88, (byte) 0x99, (byte) 0xaa, (byte) 0xbb, (byte) 0xcc, (byte) 0xdd, (byte) 0xee, (byte) 0xff, (byte) 0x00, (byte) 0x11, (byte) 0x22, (byte) 0x33, (byte) 0x00, (byte) 0x00 }, Conversion.uuidToByteArray(new UUID(0xFFEEDDCCBBAA9988L, 0x7766554433221100L), new byte[16], 2, 12)); 
 }
@Test
public void testByteToBinary8393() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testIntToHex8434() { 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 100, "", 0, 0)); 
     assertEquals("", Conversion.intToHex(0x00000000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fedcba0fffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 7)); 
     assertEquals("fedcba09ffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 0, 8)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.intToHex(0x90ABCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("ffffedcfffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("ffffedcba0ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("ffffedcba09fffffffffffff", Conversion.intToHex(0x90ABCDEF, 0, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.intToHex(0x90ABCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb97512ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 3, "ffffffffffffffffffffffff", 3, 8)); 
     assertEquals("fffedcba09ffffffffffffff", Conversion.intToHex(0x90ABCDEF, 4, "ffffffffffffffffffffffff", 3, 7)); 
     assertEquals("fedcba09", Conversion.intToHex(0x90ABCDEF, 0, "", 0, 8)); 
     try { 
         Conversion.intToHex(0x90ABCDEF, 0, "", 1, 8); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testShortToBinary8438() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testHexToShort8443() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testHexDigitToBinary8481() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb08496() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex8548() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8565() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary8630() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8659() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToBinary8677() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testLongToByteArray8707() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testLongToIntArray8709() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testHexToByte8766() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testIntToShortArray8798() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testByteToHex8805() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToBinary8817() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testLongToByteArray8852() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testByteToBinary8864() { 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.byteToBinary((byte) 0x00, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.byteToBinary((byte) 0xEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, true, false, false, true, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 0, 8)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, true, false, true, false, false, true, false, false, false }, Conversion.byteToBinary((byte) 0x95, 0, new boolean[13], 2, 8)); 
     assertBinaryEquals(new boolean[] { false, true, false, true, false, false, true, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 1, new boolean[13], 0, 7)); 
     assertBinaryEquals(new boolean[] { true, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 0, 6)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, false, true, false, false, true, false, false, false, false }, Conversion.byteToBinary((byte) 0x95, 2, new boolean[13], 3, 6)); 
 }
@Test
public void testIntToHexDigitMsb08868() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex8889() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testHexDigitToBinary8929() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteArrayToLong8948() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testShortArrayToInt8949() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit8969() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexToByte8974() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 17, (byte) 0x34, 4, 1)); 
 }
@Test
public void testLongToByteArray8980() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testLongToByteArray9007() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testByteArrayToLong9027() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryToLong9032() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.binaryToLong(src, 0, 0L, 0, 1 * 4)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.binaryToLong(src, 0, 0L, 0, 8 * 4)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.binaryToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.binaryToLong(src, 15 * 4, 0x123456798ABCDEF0L, 24, 3 * 4)); 
 }
@Test
public void testBinaryBeMsb0ToHexDigit9058() { 
     assertEquals('0', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, false })); 
     assertEquals('1', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, false, true })); 
     assertEquals('2', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, false })); 
     assertEquals('3', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, false, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, false })); 
     assertEquals('5', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, false, true })); 
     assertEquals('6', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, false })); 
     assertEquals('7', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { false, true, true, true })); 
     assertEquals('8', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false })); 
     assertEquals('9', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, true })); 
     assertEquals('a', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, false })); 
     assertEquals('b', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, true, true })); 
     assertEquals('c', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, false })); 
     assertEquals('d', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, false, true })); 
     assertEquals('e', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, false })); 
     assertEquals('f', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, true, true, true })); 
     assertEquals('4', Conversion.binaryBeMsb0ToHexDigit(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false })); 
     try { 
         Conversion.binaryBeMsb0ToHexDigit(new boolean[] {}); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex9070() { 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 100, "", 0, 0)); 
     assertEquals("", Conversion.byteToHex((byte) 0x00, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.byteToHex((byte) 0xEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.byteToHex((byte) 0xEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.byteToHex((byte) 0xEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.byteToHex((byte) 0xEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.byteToHex((byte) 0xEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.byteToHex((byte) 0xEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.byteToHex((byte) 0xEF, 0, "", 0, 2)); 
     try { 
         Conversion.byteToHex((byte) 0xEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb09096() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitToBinary9109() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToByteArray9111() { 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.shortToByteArray((short) 0x0000, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0xFE, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.shortToByteArray((short) 0xCDEF, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1 }, 3, 1)); 
 }
@Test
public void testLongToIntArray9112() { 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 100, new int[] {}, 0, 0)); 
     assertArrayEquals(new int[] {}, Conversion.longToIntArray(0x0000000000000000L, 0, new int[] {}, 100, 0)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new int[] { 0x90ABCDEF, 0x12345678, 0xFFFFFFFF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0x12345678 }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0xFFFFFFFF, 0x90ABCDEF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 0, new int[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x4855E6F7, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 1, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x242AF37B, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 2, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x121579BD, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 3, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0xFFFFFFFF, 0xFFFFFFFF, 0x890ABCDE, 0xFFFFFFFF }, Conversion.longToIntArray(0x1234567890ABCDEFL, 4, new int[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new int[] { 0x091A2B3C }, Conversion.longToIntArray(0x1234567890ABCDEFL, 33, new int[] { 0 }, 0, 1)); 
 }
@Test
public void testIntToBinary9116() { 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.intToBinary(0x00000000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.intToBinary(0x90ABCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 0, 32)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 0, new boolean[37], 2, 32)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 1, new boolean[37], 0, 31)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 0, 30)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, true, true, false, true, false, true, false, true, false, false, false, false, true, false, false, true, false, false, false, false }, Conversion.intToBinary(0x90ABCDEF, 2, new boolean[37], 3, 30)); 
 }
@Test
public void testShortArrayToLong9157() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testByteArrayToLong9165() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000000000CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.byteArrayToLong(src, 0, 0L, 0, 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.byteArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.byteArrayToLong(src, 7, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testShortArrayToInt9184() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testBinaryToInt9226() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
@Test
public void testIntToHexDigitMsb09253() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToShortArray9254() { 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.intToShortArray(0x00000000, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0x5678, (short) 0x1234, (short) 0xFFFF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0x1234 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0x5678 }, Conversion.intToShortArray(0x12345678, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x2B3C, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x159E, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x8ACF, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x4567, (short) 0xFFFF }, Conversion.intToShortArray(0x12345678, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0x091A }, Conversion.intToShortArray(0x12345678, 17, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testIntToHexDigitMsb09291() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testShortToBinary9293() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testShortToBinary9296() { 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 100, new boolean[] {}, 0, 0)); 
     assertBinaryEquals(new boolean[] {}, Conversion.shortToBinary((short) 0x0000, 0, new boolean[] {}, 100, 0)); 
     assertBinaryEquals(new boolean[69], Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[69], 0, 0)); 
     assertBinaryEquals(new boolean[] { true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 1)); 
     assertBinaryEquals(new boolean[] { true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 2)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 3)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 0, 16)); 
     assertBinaryEquals(new boolean[] { false, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 1)); 
     assertBinaryEquals(new boolean[] { false, false, true, true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 0, new boolean[21], 2, 16)); 
     assertBinaryEquals(new boolean[] { true, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 1, new boolean[21], 0, 15)); 
     assertBinaryEquals(new boolean[] { true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 0, 14)); 
     assertBinaryEquals(new boolean[] { false, false, false, true, true, false, true, true, true, true, false, true, true, false, false, true, true, false, false, false, false }, Conversion.shortToBinary((short) 0xCDEF, 2, new boolean[21], 3, 14)); 
 }
@Test
public void testShortArrayToInt9341() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testHexDigitToBinary9343() { 
     assertBinaryEquals(new boolean[] { false, false, false, false }, Conversion.hexDigitToBinary('0')); 
     assertBinaryEquals(new boolean[] { true, false, false, false }, Conversion.hexDigitToBinary('1')); 
     assertBinaryEquals(new boolean[] { false, true, false, false }, Conversion.hexDigitToBinary('2')); 
     assertBinaryEquals(new boolean[] { true, true, false, false }, Conversion.hexDigitToBinary('3')); 
     assertBinaryEquals(new boolean[] { false, false, true, false }, Conversion.hexDigitToBinary('4')); 
     assertBinaryEquals(new boolean[] { true, false, true, false }, Conversion.hexDigitToBinary('5')); 
     assertBinaryEquals(new boolean[] { false, true, true, false }, Conversion.hexDigitToBinary('6')); 
     assertBinaryEquals(new boolean[] { true, true, true, false }, Conversion.hexDigitToBinary('7')); 
     assertBinaryEquals(new boolean[] { false, false, false, true }, Conversion.hexDigitToBinary('8')); 
     assertBinaryEquals(new boolean[] { true, false, false, true }, Conversion.hexDigitToBinary('9')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('A')); 
     assertBinaryEquals(new boolean[] { false, true, false, true }, Conversion.hexDigitToBinary('a')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('B')); 
     assertBinaryEquals(new boolean[] { true, true, false, true }, Conversion.hexDigitToBinary('b')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('C')); 
     assertBinaryEquals(new boolean[] { false, false, true, true }, Conversion.hexDigitToBinary('c')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('D')); 
     assertBinaryEquals(new boolean[] { true, false, true, true }, Conversion.hexDigitToBinary('d')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('E')); 
     assertBinaryEquals(new boolean[] { false, true, true, true }, Conversion.hexDigitToBinary('e')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('F')); 
     assertBinaryEquals(new boolean[] { true, true, true, true }, Conversion.hexDigitToBinary('f')); 
     try { 
         Conversion.hexDigitToBinary('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testLongToShortArray9405() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryToShort9420() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 4 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 3 * 4)); 
 }
@Test
public void testShortArrayToLong9427() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x00000000F0C1CDF1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x780034560F12F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456CDF1BCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123478003456DEF0L, Conversion.shortArrayToLong(src, 3, 0x123456789ABCDEF0L, 16, 2)); 
 }
@Test
public void testLongToByteArray9450() { 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 100, new byte[] {}, 0, 0)); 
     assertArrayEquals(new byte[] {}, Conversion.longToByteArray(0x0000000000000000L, 0, new byte[] {}, 100, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 2)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 4)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xEF, (byte) 0xCD, (byte) 0xAB, (byte) 0x90, (byte) 0x78, (byte) 0x56, (byte) 0x34, (byte) 0x12 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 0, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xF7, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 1, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0x7B, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 2, new byte[] { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x6F, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00 }, Conversion.longToByteArray(0x1234567890ABCDEFL, 5, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 8)); 
     assertArrayEquals(new byte[] { (byte) 0xFF, (byte) 0x00, (byte) 0xFF, (byte) 0x5E, (byte) 0x85, (byte) 0xC4, (byte) 0xB3, (byte) 0xA2, (byte) 0x91, (byte) 0x00, (byte) 0xFF }, Conversion.longToByteArray(0x1234567890ABCDEFL, 13, new byte[] { -1, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1 }, 3, 7)); 
 }
@Test
public void testShortArrayToInt9454() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x00000000, Conversion.shortArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x0000CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF0C1CDF1, Conversion.shortArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F12F0C1, Conversion.shortArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.shortArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.shortArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testIntArrayToLong9468() { 
     final int[] src = new int[] { 0xCDF1F0C1, 0x0F123456, 0x78000000 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 1, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F123456CDF1F0C1L, Conversion.intArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.intArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.intArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testShortToHex9508() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("ffffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 0)); 
     assertEquals("3fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("feffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 2)); 
     assertEquals("fedfffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 3)); 
     assertEquals("fedcffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 0, 4)); 
     assertEquals("fff3ffffffffffffffffffff", Conversion.shortToHex((short) 0xCDE3, 0, "ffffffffffffffffffffffff", 3, 1)); 
     assertEquals("ffffefffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 0, "ffffffffffffffffffffffff", 3, 2)); 
     assertEquals("7fffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 1, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("bfffffffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 2, "ffffffffffffffffffffffff", 0, 1)); 
     assertEquals("fffdb9ffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 3, "ffffffffffffffffffffffff", 3, 4)); 
     assertEquals("fffedcffffffffffffffffff", Conversion.shortToHex((short) 0xCDEF, 4, "ffffffffffffffffffffffff", 3, 3)); 
     assertEquals("fedc", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 4)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 4); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
 }
@Test
public void testLongToShortArray9519() { 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 100, new short[] {}, 0, 0)); 
     assertArrayEquals(new short[] {}, Conversion.longToShortArray(0x0000000000000000L, 0, new short[] {}, 100, 0)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 0)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 1)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0xFFFF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 2)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 3)); 
     assertArrayEquals(new short[] { (short) 0xCDEF, (short) 0x90AB, (short) 0x5678, (short) 0x1234 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB, (short) 0x5678 }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 1, 3)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0x90AB }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 2)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xFFFF, (short) 0xCDEF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 0, new short[] { -1, -1, -1, -1 }, 3, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xE6F7, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xF37B, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 2, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0x79BD, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 3, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xFFFF, (short) 0xFFFF, (short) 0xBCDE, (short) 0xFFFF }, Conversion.longToShortArray(0x1234567890ABCDEFL, 4, new short[] { -1, -1, -1, -1 }, 2, 1)); 
     assertArrayEquals(new short[] { (short) 0xE6F7, (short) 0x4855, (short) 0x2B3C, (short) 0x091A }, Conversion.longToShortArray(0x1234567890ABCDEFL, 1, new short[] { -1, -1, -1, -1 }, 0, 4)); 
     assertArrayEquals(new short[] { (short) 0x2B3C }, Conversion.longToShortArray(0x1234567890ABCDEFL, 33, new short[] { 0 }, 0, 1)); 
 }
@Test
public void testBinaryToInt9527() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x0000000C, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0x1C0F1FDC, Conversion.binaryToInt(src, 0 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x01C0F1FD, Conversion.binaryToInt(src, 1 * 4, 0, 0, 8 * 4)); 
     assertEquals(0x12345679, Conversion.binaryToInt(src, 0 * 4, 0x12345679, 0, 0 * 4)); 
     assertEquals(0x87645679, Conversion.binaryToInt(src, 15 * 4, 0x12345679, 20, 3 * 4)); 
 }
    

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
