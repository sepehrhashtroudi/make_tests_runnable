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
public void testBinaryToHexDigit_2args590() { 
     final boolean[] shortArray = new boolean[] { false, true, true }; 
     assertEquals('6', Conversion.binaryToHexDigit(shortArray, 0)); 
     assertEquals('3', Conversion.binaryToHexDigit(shortArray, 1)); 
     assertEquals('1', Conversion.binaryToHexDigit(shortArray, 2)); 
     final boolean[] longArray = new boolean[] { true, false, true, false, false, true, true }; 
     assertEquals('5', Conversion.binaryToHexDigit(longArray, 0)); 
     assertEquals('2', Conversion.binaryToHexDigit(longArray, 1)); 
     assertEquals('9', Conversion.binaryToHexDigit(longArray, 2)); 
     assertEquals('c', Conversion.binaryToHexDigit(longArray, 3)); 
     assertEquals('6', Conversion.binaryToHexDigit(longArray, 4)); 
     assertEquals('3', Conversion.binaryToHexDigit(longArray, 5)); 
     assertEquals('1', Conversion.binaryToHexDigit(longArray, 6)); 
 }
@Test
public void testIntToHexDigit591() { 
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
public void testIntArrayToLong592() { 
     final int[] src = new int[] { 0, 1, 2, 3, 0 }; 
     assertEquals(0x0000000000000000L, Conversion.intArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.intArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.intArrayToLong(src, 0, 0L, 0, 8)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.intArrayToLong(src, 1, 0L, 0, 8)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.intArrayToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.intArrayToLong(src, 15, 0x123456798ABCDEF0L, 24, 3)); 
 }
@Test
public void testByteArrayToLong593() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x0000000000000000L, Conversion.byteArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x000000000000000CL, Conversion.byteArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x000000001C0F1FDCL, Conversion.byteArrayToLong(src, 0, 0L, 0, 8)); 
     assertEquals(0x0000000001C0F1FDL, Conversion.byteArrayToLong(src, 1, 0L, 0, 8)); 
     assertEquals(0x123456798ABCDEF0L, Conversion.byteArrayToLong(src, 0, 0x123456798ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567876BCDEF0L, Conversion.byteArrayToLong(src, 15, 0x123456798ABCDEF0L, 24, 3)); 
 }
@Test
public void testByteArrayToInt594() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x00CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0x0F1FDC, Conversion.byteArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDEF, Conversion.byteArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testByteArrayToInt595() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x00CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0xF0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDEF, Conversion.byteArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testByteArrayToInt596() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals(0x00000000, Conversion.byteArrayToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x00CD, Conversion.byteArrayToInt(src, 0, 0, 0, 1)); 
     assertEquals(0xF1CD, Conversion.byteArrayToInt(src, 0, 0, 0, 2)); 
     assertEquals(0xF0F1, Conversion.byteArrayToInt(src, 1, 0, 0, 2)); 
     assertEquals(0x12345678, Conversion.byteArrayToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0xCDF15678, Conversion.byteArrayToInt(src, 0, 0x12345678, 16, 1)); 
 }
@Test
public void testHexToShort597() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((short) 0x0000, Conversion.hexToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.hexToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.hexToShort(src, 0, (short) 0, 0, 8)); 
     assertEquals((short) 0xF1FD, Conversion.hexToShort(src, 1, (short) 0, 0, 8)); 
     assertEquals((short) 0x1234, Conversion.hexToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.hexToShort(src, 15, (short) 0x1234, 4, 3)); 
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
