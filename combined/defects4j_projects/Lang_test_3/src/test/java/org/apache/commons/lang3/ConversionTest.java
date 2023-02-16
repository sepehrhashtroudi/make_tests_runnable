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
public void testIntToHexDigitMsb0527() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     try { 
         Conversion.intToHexDigitMsb0(16); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testIntToHexDigitMsb0528() { 
     assertEquals('0', Conversion.intToHexDigitMsb0(0)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(1)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(2)); 
     assertEquals('3', Conversion.intToHexDigitMsb0(3)); 
     assertEquals('4', Conversion.intToHexDigitMsb0(4)); 
     assertEquals('5', Conversion.intToHexDigitMsb0(5)); 
     assertEquals('6', Conversion.intToHexDigitMsb0(6)); 
     assertEquals('7', Conversion.intToHexDigitMsb0(7)); 
     assertEquals('8', Conversion.intToHexDigitMsb0(8)); 
     assertEquals('9', Conversion.intToHexDigitMsb0(9)); 
     assertEquals('A', Conversion.intToHexDigitMsb0(10)); 
     assertEquals('a', Conversion.intToHexDigitMsb0(11)); 
     assertEquals('B', Conversion.intToHexDigitMsb0(12)); 
     assertEquals('b', Conversion.intToHexDigitMsb0(13)); 
     assertEquals('c', Conversion.intToHexDigitMsb0(14)); 
     assertEquals('d', Conversion.intToHexDigitMsb0(15)); 
     assertEquals('e', Conversion.intToHexDigitMsb0(16)); 
     assertEquals('f', Conversion.intToHexDigitMsb0(15)); 
     assertEquals('1', Conversion.intToHexDigitMsb0(20)); 
     assertEquals('2', Conversion.intToHexDigitMsb0(25)); 
 }
@Test
public void testShortArrayToLong533() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F12F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000FCDF1F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.shortArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testShortArrayToLong534() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F12F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000F123456L, Conversion.shortArrayToLong(src, 1, 0L, 0, 1)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x123456787800L, Conversion.shortArrayToLong(src, 2, 0x123456789ABCDEF0L, 0, 1)); 
 }
@Test
public void testShortArrayToLong535() { 
     final short[] src = new short[] { (short) 0xCDF1, (short) 0xF0C1, (short) 0x0F12, (short) 0x3456, (short) 0x7800 }; 
     assertEquals(0x0000000000000000L, Conversion.shortArrayToLong(src, 0, 0L, 0, 0)); 
     assertEquals(0x00000000CDF1F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 1)); 
     assertEquals(0x0F12F0C1L, Conversion.shortArrayToLong(src, 0, 0L, 0, 2)); 
     assertEquals(0x000000000FCDF1F0C1L, Conversion.shortArrayToLong(src, 1, 0L, 0, 2)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 0, 0)); 
     assertEquals(0x1234567878000000L, Conversion.shortArrayToLong(src, 0, 0x123456789ABCDEF0L, 16, 1)); 
 }
@Test
public void testHexToInt537() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals(0x00000000, Conversion.hexToInt(src, 0, 0, 0, 0)); 
     assertEquals(0x000C, Conversion.hexToInt(src, 0, 0, 0, 1)); 
     assertEquals(0x1FDC, Conversion.hexToInt(src, 0, 0, 0, 4)); 
     assertEquals(0x12345678, Conversion.hexToInt(src, 1, 0, 0, 4)); 
     assertEquals(0xCDF15678, Conversion.hexToInt(src, 0, 0x12345678, 0, 0)); 
     assertEquals(0x87645679, Conversion.hexToInt(src, 15, 0x12345678, 4, 3)); 
 }
@Test
public void testBinaryToShort538() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, true, false, false, false, true, true, true, true, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals((short) 0x0000, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 0 * 4)); 
     assertEquals((short) 0x000C, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 1 * 4)); 
     assertEquals((short) 0x1FDC, Conversion.binaryToShort(src, 0 * 4, (short) 0, 0, 2 * 4)); 
     assertEquals((short) 0xF1FD, Conversion.binaryToShort(src, 1 * 4, (short) 0, 0, 2 * 4)); 
     assertEquals((short) 0x1234, Conversion.binaryToShort(src, 0 * 4, (short) 0x1234, 0, 0 * 4)); 
     assertEquals((short) 0x8764, Conversion.binaryToShort(src, 15 * 4, (short) 0x1234, 4, 1 * 4)); 
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
