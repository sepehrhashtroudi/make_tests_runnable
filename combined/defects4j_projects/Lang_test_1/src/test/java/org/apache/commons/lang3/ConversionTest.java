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
public void testHexDigitToInt515() { 
     assertEquals(0, Conversion.hexDigitToInt('0')); 
     assertEquals(1, Conversion.hexDigitToInt('1')); 
     assertEquals(2, Conversion.hexDigitToInt('2')); 
     try { 
         Conversion.hexDigitToInt('3'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         Conversion.hexDigitToInt((char) 0); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testByteToHex517() { 
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
public void testByteArrayToShort518() { 
     final byte[] src = new byte[] { (byte) 0xCD, (byte) 0xF1, (byte) 0xF0, (byte) 0xC1, (byte) 0x0F, (byte) 0x12, (byte) 0x34, (byte) 0x56, (byte) 0x78 }; 
     assertEquals((short) 0x0000, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 0)); 
     assertEquals((short) 0x000C, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 1)); 
     assertEquals((short) 0x1FDC, Conversion.byteArrayToShort(src, 0, (short) 0, 0, 4)); 
     assertEquals((short) 0xF1FD, Conversion.byteArrayToShort(src, 1, (short) 0, 0, 4)); 
     assertEquals((short) 0x1234, Conversion.byteArrayToShort(src, 0, (short) 0x1234, 0, 0)); 
     assertEquals((short) 0x8764, Conversion.byteArrayToShort(src, 15, (short) 0x1234, 4, 3)); 
 }
@Test
public void testHexToByte519() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 100, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 15, (byte) 0x34, 4, 3)); 
 }
@Test
public void testHexToByte520() { 
     final String src = "CDF1F0C10F12345678"; 
     assertEquals((byte) 0x00, Conversion.hexToByte(src, 0, (byte) 0, 0, 0)); 
     assertEquals((byte) 0x0C, Conversion.hexToByte(src, 0, (byte) 0, 0, 1)); 
     assertEquals((byte) 0xDC, Conversion.hexToByte(src, 0, (byte) 0, 0, 2)); 
     assertEquals((byte) 0xFD, Conversion.hexToByte(src, 1, (byte) 0, 0, 2)); 
     assertEquals((byte) 0x34, Conversion.hexToByte(src, 0, (byte) 0x34, 0, 0)); 
     assertEquals((byte) 0x84, Conversion.hexToByte(src, 15, (byte) 0x34, 4, 3)); 
 }
@Test
public void testBinaryToLong521() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 0 * 4)); 
     assertEquals(0x00000000000000CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 2 * 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 2 * 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 0, 0 * 4)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.binaryToLong(src, 7 * 4, 0x123456789ABCDEF0L, 8, 2 * 4)); 
 }
@Test
public void testBinaryToLong522() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 0 * 4)); 
     assertEquals(0x00000000000000CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 8 * 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 0, 0 * 4)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.binaryToLong(src, 7 * 4, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryToLong523() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 0 * 4)); 
     assertEquals(0x00000000000000CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 2 * 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 0, 0 * 4)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.binaryToLong(src, 7 * 4, 0x123456789ABCDEF0L, 8, 2)); 
 }
@Test
public void testBinaryToLong524() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x0000000000000000L, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 0 * 4)); 
     assertEquals(0x00000000000000CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x00000000C1F0F1CDL, Conversion.binaryToLong(src, 0 * 4, 0L, 0, 2 * 4)); 
     assertEquals(0x000000000FC1F0F1L, Conversion.binaryToLong(src, 1 * 4, 0L, 0, 1 * 4)); 
     assertEquals(0x123456789ABCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 0, 0 * 4)); 
     assertEquals(0x12345678CDBCDEF0L, Conversion.binaryToLong(src, 0 * 4, 0x123456789ABCDEF0L, 24, 1)); 
     assertEquals(0x123456789A7856F0L, Conversion.binaryToLong(src, 7 * 4, 0x123456789ABCDEF0L, 8, 2 * 4)); 
 }
@Test
public void testBinaryToInt525() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x000000CD, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0xCDEF0, Conversion.binaryToInt(src, 0 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x0FC1, Conversion.binaryToInt(src, 1 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x12345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 0, 0 * 4)); 
     assertEquals(0xCD345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 24, 1 * 4)); 
 }
@Test
public void testBinaryToInt526() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x000000CD, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0xCDF1, Conversion.binaryToInt(src, 0 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x0FC1, Conversion.binaryToInt(src, 1 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x12345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 0, 0 * 4)); 
     assertEquals(0xCD345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 24, 1 * 4)); 
 }
@Test
public void testBinaryToInt527() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x000000CD, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0xCDF1, Conversion.binaryToInt(src, 0 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x0FC1, Conversion.binaryToInt(src, 1 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x12345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 0, 0 * 4)); 
     assertEquals(0xCD345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 24, 1 * 4)); 
 }
@Test
public void testBinaryToInt528() { 
     final boolean[] src = new boolean[] { false, false, true, true, true, false, true, true, true, true, true, true, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, false, false, false, false, false, false, false, false, true, true, true, true, false, false, false, false, true, false, false, true, true, false, false, false, false, true, false, true, false, true, false, false, true, true, false, true, true, true, false, false, false, false, true }; 
     assertEquals(0x00000000, Conversion.binaryToInt(src, 0 * 4, 0, 0, 0 * 4)); 
     assertEquals(0x000000CD, Conversion.binaryToInt(src, 0 * 4, 0, 0, 1 * 4)); 
     assertEquals(0xCDF1F0C1, Conversion.binaryToInt(src, 0 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x0FC1F0C1, Conversion.binaryToInt(src, 1 * 4, 0, 0, 2 * 4)); 
     assertEquals(0x12345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 0, 0 * 4)); 
     assertEquals(0xCD345678, Conversion.binaryToInt(src, 0 * 4, 0x12345678, 24, 1 * 4)); 
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
