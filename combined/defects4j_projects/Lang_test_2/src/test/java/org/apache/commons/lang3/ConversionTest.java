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
public void testHexDigitMsb0ToInt501() { 
     assertEquals('0', Conversion.hexDigitMsb0ToInt('0')); 
     assertEquals('8', Conversion.hexDigitMsb0ToInt('1')); 
     assertEquals('4', Conversion.hexDigitMsb0ToInt('2')); 
     assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
     assertEquals('5', Conversion.hexDigitMsb0ToInt('5')); 
     assertEquals('6', Conversion.hexDigitMsb0ToInt('6')); 
     assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
     assertEquals('8', Conversion.hexDigitMsb0ToInt('8')); 
     assertEquals('9', Conversion.hexDigitMsb0ToInt('9')); 
     assertEquals('A', Conversion.hexDigitMsb0ToInt('a')); 
     assertEquals('B', Conversion.hexDigitMsb0ToInt('b')); 
     assertEquals('c', Conversion.hexDigitMsb0ToInt('c')); 
     assertEquals('d', Conversion.hexDigitMsb0ToInt('d')); 
     assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
     assertEquals('4', Conversion.hexDigitMsb0ToInt('4')); 
     assertEquals('5', Conversion.hexDigitMsb0ToInt('5')); 
     assertEquals('6', Conversion.hexDigitMsb0ToInt('6')); 
     assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
     assertEquals('f', Conversion.hexDigitMsb0ToInt('f')); 
     try { 
         Conversion.hexDigitMsb0ToInt('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitMsb0ToInt502() { 
     assertEquals('0', Conversion.hexDigitMsb0ToInt('0')); 
     assertEquals('1', Conversion.hexDigitMsb0ToInt('1')); 
     assertEquals('2', Conversion.hexDigitMsb0ToInt('2')); 
     assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
     assertEquals('4', Conversion.hexDigitMsb0ToInt('4')); 
     assertEquals('5', Conversion.hexDigitMsb0ToInt('5')); 
     assertEquals('6', Conversion.hexDigitMsb0ToInt('6')); 
     assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
     assertEquals('8', Conversion.hexDigitMsb0ToInt('8')); 
     assertEquals('9', Conversion.hexDigitMsb0ToInt('9')); 
     assertEquals('A', Conversion.hexDigitMsb0ToInt('a')); 
     assertEquals('B', Conversion.hexDigitMsb0ToInt('b')); 
     assertEquals('c', Conversion.hexDigitMsb0ToInt('c')); 
     assertEquals('d', Conversion.hexDigitMsb0ToInt('d')); 
     assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
     assertEquals('4', Conversion.hexDigitMsb0ToInt('b')); 
     assertEquals('5', Conversion.hexDigitMsb0ToInt('6')); 
     assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
     assertEquals('f', Conversion.hexDigitMsb0ToInt('f')); 
     assertEquals('f', Conversion.hexDigitMsb0ToInt('f')); 
     try { 
         Conversion.hexDigitMsb0ToInt('G'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testHexDigitMsb0ToInt503() { 
     assertEquals('0', Conversion.hexDigitMsb0ToInt('0')); 
     assertEquals('1', Conversion.hexDigitMsb0ToInt('1')); 
     assertEquals('2', Conversion.hexDigitMsb0ToInt('2')); 
     assertEquals('3', Conversion.hexDigitMsb0ToInt('3')); 
     assertEquals('4', Conversion.hexDigitMsb0ToInt('4')); 
     assertEquals('5', Conversion.hexDigitMsb0ToInt('5')); 
     assertEquals('6', Conversion.hexDigitMsb0ToInt('6')); 
     assertEquals('7', Conversion.hexDigitMsb0ToInt('7')); 
     assertEquals('8', Conversion.hexDigitMsb0ToInt('8')); 
     assertEquals('9', Conversion.hexDigitMsb0ToInt('9')); 
     assertEquals('A', Conversion.hexDigitMsb0ToInt('a')); 
     assertEquals('B', Conversion.hexDigitMsb0ToInt('b')); 
     assertEquals('c', Conversion.hexDigitMsb0ToInt('c')); 
     assertEquals('d', Conversion.hexDigitMsb0ToInt('d')); 
     assertEquals('e', Conversion.hexDigitMsb0ToInt('e')); 
     assertEquals('f', Conversion.hexDigitMsb0ToInt('f')); 
     try { 
         Conversion.hexDigitMsb0ToInt('b'); 
         fail("Thrown " + IllegalArgumentException.class.getName() + " expected"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testBinaryToHexDigitMsb0_4bits_2args514() { 
     final boolean[] shortArray = new boolean[] { true, true, false, true }; 
     assertEquals('d', Conversion.binaryToHexDigitMsb0_4bits(shortArray, 0)); 
     final boolean[] longArray = new boolean[] { true, false, true, false, false, true, true }; 
     assertEquals('a', Conversion.binaryToHexDigitMsb0_4bits(longArray, 0)); 
     assertEquals('4', Conversion.binaryToHexDigitMsb0_4bits(longArray, 1)); 
     assertEquals('9', Conversion.binaryToHexDigitMsb0_4bits(longArray, 2)); 
     assertEquals('3', Conversion.binaryToHexDigitMsb0_4bits(longArray, 3)); 
     final boolean[] maxLengthArray = new boolean[] { true, false, true, false, false, true, true, true }; 
     assertEquals('a', Conversion.binaryToHexDigitMsb0_4bits(maxLengthArray, 0)); 
     assertEquals('4', Conversion.binaryToHexDigitMsb0_4bits(maxLengthArray, 1)); 
     assertEquals('9', Conversion.binaryToHexDigitMsb0_4bits(maxLengthArray, 2)); 
     assertEquals('3', Conversion.binaryToHexDigitMsb0_4bits(maxLengthArray, 3)); 
     assertEquals('7', Conversion.binaryToHexDigitMsb0_4bits(maxLengthArray, 4)); 
     final boolean[] javaDocCheck = new boolean[] { true, false, false, true, true, false, true, false }; 
     assertEquals('d', Conversion.binaryToHexDigitMsb0_4bits(javaDocCheck, 3)); 
 }
@Test
public void testShortToHex516() { 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 100, "", 0, 0)); 
     assertEquals("", Conversion.shortToHex((short) 0x0000, 0, "", 100, 0)); 
     assertEquals("00000", Conversion.shortToHex((short) 0xCDEF, 0, "00000", 0, 0)); 
     assertEquals("f0000", Conversion.shortToHex((short) 0xCDEF, 0, "00000", 0, 1)); 
     assertEquals("fe000", Conversion.shortToHex((short) 0xCDEF, 0, "00000", 0, 2)); 
     assertEquals("000f0", Conversion.shortToHex((short) 0xCDEF, 0, "00000", 3, 1)); 
     assertEquals("000fe", Conversion.shortToHex((short) 0xCDEF, 0, "00000", 3, 2)); 
     assertEquals("70000", Conversion.shortToHex((short) 0xCDEF, 1, "00000", 0, 1)); 
     assertEquals("b0000", Conversion.shortToHex((short) 0xCDEF, 2, "00000", 0, 1)); 
     assertEquals("000df", Conversion.shortToHex((short) 0xCDEF, 3, "00000", 3, 2)); 
     assertEquals("000e0", Conversion.shortToHex((short) 0xCDEF, 4, "00000", 3, 1)); 
     assertEquals("fe", Conversion.shortToHex((short) 0xCDEF, 0, "", 0, 2)); 
     try { 
         Conversion.shortToHex((short) 0xCDEF, 0, "", 1, 2); 
         fail("Thrown " + StringIndexOutOfBoundsException.class.getName() + " expected"); 
     } catch (final StringIndexOutOfBoundsException e) { 
     } 
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
