/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.lang3.math;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.math.BigInteger;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.math.NumberUtils}.
 *
 * @version $Id$
 */
public class NumberUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void testConstructor60() { 
     assertNotNull(new NumberUtils()); 
     final Constructor<?>[] cons = NumberUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(NumberUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(NumberUtils.class.getModifiers())); 
 }
@Test
public void testToIntString61() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testToIntStringI62() { 
     assertTrue("toInt(String,int) 1 failed", NumberUtils.toInt("12345", 5) == 12345); 
     assertTrue("toInt(String,int) 2 failed", NumberUtils.toInt("1234.5", 5) == 5); 
 }
@Test
public void testToLongString63() { 
     assertTrue("toLong(String) 1 failed", NumberUtils.toLong("12345") == 12345l); 
     assertTrue("toLong(String) 2 failed", NumberUtils.toLong("abc") == 0l); 
     assertTrue("toLong(String) 3 failed", NumberUtils.toLong("1L") == 0l); 
     assertTrue("toLong(String) 4 failed", NumberUtils.toLong("1l") == 0l); 
     assertTrue("toLong(Long.MAX_VALUE) failed", NumberUtils.toLong(Long.MAX_VALUE + "") == Long.MAX_VALUE); 
     assertTrue("toLong(Long.MIN_VALUE) failed", NumberUtils.toLong(Long.MIN_VALUE + "") == Long.MIN_VALUE); 
     assertTrue("toLong(empty) failed", NumberUtils.toLong("") == 0l); 
     assertTrue("toLong(null) failed", NumberUtils.toLong(null) == 0l); 
 }
@Test
public void testToFloatString64() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testStringToDoubleString65() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testToByteString66() { 
     assertTrue("toByte(String) 1 failed", NumberUtils.toByte("123") == 123); 
     assertTrue("toByte(String) 2 failed", NumberUtils.toByte("abc") == 0); 
     assertTrue("toByte(empty) failed", NumberUtils.toByte("") == 0); 
     assertTrue("toByte(null) failed", NumberUtils.toByte(null) == 0); 
 }
@Test
public void testToByteStringI67() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testToShortString68() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testToShortStringI69() { 
     assertTrue("toShort(String,short) 1 failed", NumberUtils.toShort("12345", (short) 5) == 12345); 
     assertTrue("toShort(String,short) 2 failed", NumberUtils.toShort("1234.5", (short) 5) == 5); 
 }
@Test(expected = NumberFormatException.class) 
 public void testCreateNumberFailure_470() { 
     NumberUtils.createNumber("1eE+00001"); 
 }
@Test
public void testIsNumber71() { 
     String val = "12345"; 
     assertTrue("isNumber(String) 1 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 1 failed", checkCreateNumber(val)); 
     val = "1234.5"; 
     assertTrue("isNumber(String) 2 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 2 failed", checkCreateNumber(val)); 
     val = ".12345"; 
     assertTrue("isNumber(String) 3 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 3 failed", checkCreateNumber(val)); 
     val = "1234E5"; 
     assertTrue("isNumber(String) 4 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 4 failed", checkCreateNumber(val)); 
     val = "1234E+5"; 
     assertTrue("isNumber(String) 5 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 5 failed", checkCreateNumber(val)); 
     val = "1234E-5"; 
     assertTrue("isNumber(String) 6 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 6 failed", checkCreateNumber(val)); 
     val = "123.4E5"; 
     assertTrue("isNumber(String) 7 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 7 failed", checkCreateNumber(val)); 
     val = "-1234"; 
     assertTrue("isNumber(String) 8 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 8 failed", checkCreateNumber(val)); 
     val = "-1234.5"; 
     assertTrue("isNumber(String) 9 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 9 failed", checkCreateNumber(val)); 
     val = "-.12345"; 
     assertTrue("isNumber(String) 10 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 10 failed", checkCreateNumber(val)); 
     val = "-1234E5"; 
     assertTrue("isNumber(String) 11 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 11 failed", checkCreateNumber(val)); 
     val = "0"; 
     assertTrue("isNumber(String) 12 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 12 failed", checkCreateNumber(val)); 
     val = "-0"; 
     assertTrue("isNumber(String) 13 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 13 failed", checkCreateNumber(val)); 
     val = "01234"; 
     assertTrue("isNumber(String) 14 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 14 failed", checkCreateNumber(val)); 
     val = "-01234"; 
     assertTrue("isNumber(String) 15 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 15 failed", checkCreateNumber(val)); 
     val = "0xABC123"; 
     assertTrue("isNumber(String) 16 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 16 failed", checkCreateNumber(val)); 
     val = "0x0"; 
     assertTrue("isNumber(String) 17 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 17 failed", checkCreateNumber(val)); 
     val = "123.4E21D"; 
     assertTrue("isNumber(String) 19 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 19 failed", checkCreateNumber(val)); 
     val = "-221.23F"; 
     assertTrue("isNumber(String) 20 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 20 failed", checkCreateNumber(val)); 
     val = "22338L"; 
     assertTrue("isNumber(String) 21 failed", NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 21 failed", checkCreateNumber(val)); 
     val = null; 
     assertTrue("isNumber(String) 1 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 1 Neg failed", !checkCreateNumber(val)); 
     val = ""; 
     assertTrue("isNumber(String) 2 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 2 Neg failed", !checkCreateNumber(val)); 
     val = "--2.3"; 
     assertTrue("isNumber(String) 3 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 3 Neg failed", !checkCreateNumber(val)); 
     val = ".12.3"; 
     assertTrue("isNumber(String) 4 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 4 Neg failed", !checkCreateNumber(val)); 
     val = "-123E"; 
     assertTrue("isNumber(String) 5 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 5 Neg failed", !checkCreateNumber(val)); 
     val = "-123E+-212"; 
     assertTrue("isNumber(String) 6 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 6 Neg failed", !checkCreateNumber(val)); 
     val = "-123E2.12"; 
     assertTrue("isNumber(String) 7 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 7 Neg failed", !checkCreateNumber(val)); 
     val = "0xGF"; 
     assertTrue("isNumber(String) 8 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 8 Neg failed", !checkCreateNumber(val)); 
     val = "0xFAE-1"; 
     assertTrue("isNumber(String) 9 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 9 Neg failed", !checkCreateNumber(val)); 
     val = "."; 
     assertTrue("isNumber(String) 10 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 10 Neg failed", !checkCreateNumber(val)); 
     val = "-0ABC123"; 
     assertTrue("isNumber(String) 11 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 11 Neg failed", !checkCreateNumber(val)); 
     val = "123.4E-D"; 
     assertTrue("isNumber(String) 12 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 12 Neg failed", !checkCreateNumber(val)); 
     val = "123.4ED"; 
     assertTrue("isNumber(String) 13 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 13 Neg failed", !checkCreateNumber(val)); 
     val = "1234E5l"; 
     assertTrue("isNumber(String) 14 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 14 Neg failed", !checkCreateNumber(val)); 
     val = "11a"; 
     assertTrue("isNumber(String) 15 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 15 Neg failed", !checkCreateNumber(val)); 
     val = "1a"; 
     assertTrue("isNumber(String) 16 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 16 Neg failed", !checkCreateNumber(val)); 
     val = "a"; 
     assertTrue("isNumber(String) 17 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 17 Neg failed", !checkCreateNumber(val)); 
     val = "11g"; 
     assertTrue("isNumber(String) 18 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 18 Neg failed", !checkCreateNumber(val)); 
     val = "11z"; 
     assertTrue("isNumber(String) 19 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 19 Neg failed", !checkCreateNumber(val)); 
     val = "11def"; 
     assertTrue("isNumber(String) 20 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 20 Neg failed", !checkCreateNumber(val)); 
     val = "11d11"; 
     assertTrue("isNumber(String) 21 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 21 Neg failed", !checkCreateNumber(val)); 
     val = "11 11"; 
     assertTrue("isNumber(String) 22 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 22 Neg failed", !checkCreateNumber(val)); 
     val = " 1111"; 
     assertTrue("isNumber(String) 23 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 23 Neg failed", !checkCreateNumber(val)); 
     val = "1111 "; 
     assertTrue("isNumber(String) 24 Neg failed", !NumberUtils.isNumber(val)); 
     assertTrue("isNumber(String)/createNumber(String) 24 Neg failed", !checkCreateNumber(val)); 
     val = "2."; 
     assertTrue("isNumber(String) LANG-521 failed", NumberUtils.isNumber(val)); 
     val = "1.1L"; 
     assertFalse("isNumber(String) LANG-664 failed", NumberUtils.isNumber(val)); 
 }
@Test
public void TestLang747() { 
     assertEquals(Integer.valueOf(0x8000), NumberUtils.createNumber("0x8000")); 
     assertEquals(Integer.valueOf(0x80000), NumberUtils.createNumber("0x80000")); 
     assertEquals(Integer.valueOf(0x800000), NumberUtils.createNumber("0x800000")); 
     assertEquals(Integer.valueOf(0x8000000), NumberUtils.createNumber("0x8000000")); 
     assertEquals(Integer.valueOf(0x7FFFFFFF), NumberUtils.createNumber("0x7FFFFFFF")); 
     assertEquals(Long.valueOf(0x80000000L), NumberUtils.createNumber("0x80000000")); 
     assertEquals(Long.valueOf(0xFFFFFFFFL), NumberUtils.createNumber("0xFFFFFFFF")); 
     assertEquals(Integer.valueOf(0x8000000), NumberUtils.createNumber("0x08000000")); 
     assertEquals(Integer.valueOf(0x7FFFFFFF), NumberUtils.createNumber("0x007FFFFFFF")); 
     assertEquals(Long.valueOf(0x80000000L), NumberUtils.createNumber("0x080000000")); 
     assertEquals(Long.valueOf(0xFFFFFFFFL), NumberUtils.createNumber("0x00FFFFFFFF")); 
     assertEquals(Long.valueOf(0x800000000L), NumberUtils.createNumber("0x800000000")); 
     assertEquals(Long.valueOf(0x8000000000L), NumberUtils.createNumber("0x8000000000")); 
     assertEquals(Long.valueOf(0x80000000000L), NumberUtils.createNumber("0x80000000000")); 
     assertEquals(Long.valueOf(0x800000000000L), NumberUtils.createNumber("0x800000000000")); 
     assertEquals(Long.valueOf(0x8000000000000L), NumberUtils.createNumber("0x8000000000000")); 
     assertEquals(Long.valueOf(0x80000000000000L), NumberUtils.createNumber("0x80000000000000")); 
     assertEquals(Long.valueOf(0x800000000000000L), NumberUtils.createNumber("0x800000000000000")); 
     assertEquals(Long.valueOf(0x7FFFFFFFFFFFFFFFL), NumberUtils.createNumber("0x7FFFFFFFFFFFFFFF")); 
     assertEquals(new BigInteger("8000000000000000", 16), NumberUtils.createNumber("0x8000000000000000")); 
     assertEquals(new BigInteger("FFFFFFFFFFFFFFFF", 16), NumberUtils.createNumber("0xFFFFFFFFFFFFFFFF")); 
     assertEquals(Long.valueOf(0x80000000000000L), NumberUtils.createNumber("0x00080000000000000")); 
     assertEquals(Long.valueOf(0x800000000000000L), NumberUtils.createNumber("0x0800000000000000")); 
     assertEquals(Long.valueOf(0x7FFFFFFFFFFFFFFFL), NumberUtils.createNumber("0x07FFFFFFFFFFFFFFF")); 
     assertEquals(new BigInteger("8000000000000000", 16), NumberUtils.createNumber("0x00008000000000000000")); 
     assertEquals(new BigInteger("FFFFFFFFFFFFFFFF", 16), NumberUtils.createNumber("0x0FFFFFFFFFFFFFFFF")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss72() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test(expected = NumberFormatException.class) 
 public void testCreateNumberFailure_273() { 
     NumberUtils.createNumber("-1.1E+0-7e00"); 
 }
@Test(expected = NumberFormatException.class) 
 public void testCreateNumberFailure_374() { 
     NumberUtils.createNumber("-11E+0-7e00"); 
 }
@Test
public void testCreateFloat75() { 
     assertEquals("createFloat(String) failed", Float.valueOf("1234.5"), NumberUtils.createFloat("1234.5")); 
     assertEquals("createFloat(null) failed", null, NumberUtils.createFloat(null)); 
     this.testCreateFloatFailure(""); 
     this.testCreateFloatFailure(" "); 
     this.testCreateFloatFailure("\b\t\n\f\r"); 
     this.testCreateFloatFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testCreateDouble76() { 
     assertEquals("createDouble(String) failed", Double.valueOf("1234.5"), NumberUtils.createDouble("1234.5")); 
     assertEquals("createDouble(null) failed", null, NumberUtils.createDouble(null)); 
     this.testCreateDoubleFailure(""); 
     this.testCreateDoubleFailure(" "); 
     this.testCreateDoubleFailure("\b\t\n\f\r"); 
     this.testCreateDoubleFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testCreateInteger77() { 
     assertEquals("createInteger(String) failed", Integer.valueOf("12345"), NumberUtils.createInteger("12345")); 
     assertEquals("createInteger(null) failed", null, NumberUtils.createInteger(null)); 
     this.testCreateIntegerFailure(""); 
     this.testCreateIntegerFailure(" "); 
     this.testCreateIntegerFailure("\b\t\n\f\r"); 
     this.testCreateIntegerFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testCreateBigInteger78() { 
     assertEquals("createBigInteger(String) failed", new BigInteger("12345"), NumberUtils.createBigInteger("12345")); 
     assertEquals("createBigInteger(null) failed", null, NumberUtils.createBigInteger(null)); 
     this.testCreateBigIntegerFailure(""); 
     this.testCreateBigIntegerFailure(" "); 
     this.testCreateBigIntegerFailure("\b\t\n\f\r"); 
     this.testCreateBigIntegerFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
     assertEquals("createBigInteger(String) failed", new BigInteger("255"), NumberUtils.createBigInteger("0xff")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("255"), NumberUtils.createBigInteger("#ff")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("-255"), NumberUtils.createBigInteger("-0xff")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("255"), NumberUtils.createBigInteger("0377")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("-255"), NumberUtils.createBigInteger("-0377")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("-255"), NumberUtils.createBigInteger("-0377")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("-0"), NumberUtils.createBigInteger("-0")); 
     assertEquals("createBigInteger(String) failed", new BigInteger("0"), NumberUtils.createBigInteger("0")); 
     testCreateBigIntegerFailure("#"); 
     testCreateBigIntegerFailure("-#"); 
     testCreateBigIntegerFailure("0x"); 
     testCreateBigIntegerFailure("-0x"); 
 }
@Test
public void testCreateBigDecimal79() { 
     assertEquals("createBigDecimal(String) failed", new BigDecimal("1234.5"), NumberUtils.createBigDecimal("1234.5")); 
     assertEquals("createBigDecimal(null) failed", null, NumberUtils.createBigDecimal(null)); 
     this.testCreateBigDecimalFailure(""); 
     this.testCreateBigDecimalFailure(" "); 
     this.testCreateBigDecimalFailure("\b\t\n\f\r"); 
     this.testCreateBigDecimalFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
     this.testCreateBigDecimalFailure("-"); 
     this.testCreateBigDecimalFailure("--"); 
     this.testCreateBigDecimalFailure("--0"); 
     this.testCreateBigDecimalFailure("+"); 
     this.testCreateBigDecimalFailure("++"); 
     this.testCreateBigDecimalFailure("++0"); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinLong_nullArray80() { 
     NumberUtils.min((long[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinInt_emptyArray81() { 
     NumberUtils.min(new int[0]); 
 }
@Test
public void testMinInt82() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinByte_emptyArray83() { 
     NumberUtils.min(new byte[0]); 
 }
@Test
public void testMinByte84() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinDouble_nullArray85() { 
     NumberUtils.min((double[]) null); 
 }
@Test
public void testMinDouble86() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinFloat_nullArray87() { 
     NumberUtils.min((float[]) null); 
 }
@Test
public void testMinFloat88() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxLong_emptyArray89() { 
     NumberUtils.max(new long[0]); 
 }
@Test
public void testMaxLong90() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxInt_emptyArray91() { 
     NumberUtils.max(new int[0]); 
 }
@Test
public void testMaxInt92() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMaxShort93() { 
     assertEquals("max(short[]) failed for array length 1", 5, NumberUtils.max(new short[] { 5 })); 
     assertEquals("max(short[]) failed for array length 2", 9, NumberUtils.max(new short[] { 6, 9 })); 
     assertEquals("max(short[]) failed for array length 5", 10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_emptyArray94() { 
     NumberUtils.max(new byte[0]); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxDouble_nullArray95() { 
     NumberUtils.max((double[]) null); 
 }
@Test
public void testMaxDouble96() { 
     final double[] d = null; 
     try { 
         NumberUtils.max(d); 
         fail("No exception was thrown for null input."); 
     } catch (final IllegalArgumentException ex) { 
     } 
     try { 
         NumberUtils.max(new double[0]); 
         fail("No exception was thrown for empty input."); 
     } catch (final IllegalArgumentException ex) { 
     } 
     assertEquals("max(double[]) failed for array length 1", 5.1f, NumberUtils.max(new double[] { 5.1f }), 0); 
     assertEquals("max(double[]) failed for array length 2", 9.2f, NumberUtils.max(new double[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(double[]) failed for float length 5", 10.4f, NumberUtils.max(new double[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(10, NumberUtils.max(new double[] { -5, 0, 10, 5, -10 }), 0.0001); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxFloat_emptyArray97() { 
     NumberUtils.max(new float[0]); 
 }
@Test
public void testMaxFloat98() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testMinimumLong99() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testMinimumInt100() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testMinimumShort101() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMinimumByte102() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaximumLong103() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testMaximumInt104() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testMaximumShort105() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testMaximumByte106() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testMaximumDouble107() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(high, NumberUtils.max(low, mid, high), 0.0001); 
     assertEquals(high, NumberUtils.max(mid, low, high), 0.0001); 
     assertEquals(high, NumberUtils.max(mid, high, low), 0.0001); 
     assertEquals(mid, NumberUtils.max(low, mid, low), 0.0001); 
     assertEquals(high, NumberUtils.max(high, mid, high), 0.0001); 
 }
@Test
public void testMaximumFloat108() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(high, NumberUtils.max(low, mid, high), 0.0001f); 
     assertEquals(high, NumberUtils.max(mid, low, high), 0.0001f); 
     assertEquals(high, NumberUtils.max(mid, high, low), 0.0001f); 
     assertEquals(mid, NumberUtils.max(low, mid, low), 0.0001f); 
     assertEquals(high, NumberUtils.max(high, mid, high), 0.0001f); 
 }
@Test
public void testIsDigits109() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
    

    //---------------------------------------------------------------------

    /**
     * Test for {@link NumberUtils#toInt(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toInt(String, int)}.
     */
    

    /**
     * Test for {@link NumberUtils#toLong(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toLong(String, long)}.
     */
    

    /**
     * Test for {@link NumberUtils#toFloat(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toFloat(String, float)}.
     */
    
    
    /**
     * Test for {(@link NumberUtils#createNumber(String)}
     */
    
    /**
     * Test for {@link NumberUtils#toDouble(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toDouble(String, double)}.
     */
    

     /**
     * Test for {@link NumberUtils#toByte(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toByte(String, byte)}.
     */
    

    /**
     * Test for {@link NumberUtils#toShort(String)}.
     */
    

    /**
     * Test for {@link NumberUtils#toShort(String, short)}.
     */
    

    

    

    

    

    

    

    // Tests to show when magnitude causes switch to next Number type
    // Will probably need to be adjusted if code is changed to check precision (LANG-693)
    

    

    protected void testCreateFloatFailure(final String str) {
        try {
            final Float value = NumberUtils.createFloat(str);
            fail("createFloat(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    

    protected void testCreateDoubleFailure(final String str) {
        try {
            final Double value = NumberUtils.createDouble(str);
            fail("createDouble(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    

    protected void testCreateIntegerFailure(final String str) {
        try {
            final Integer value = NumberUtils.createInteger(str);
            fail("createInteger(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    

    protected void testCreateLongFailure(final String str) {
        try {
            final Long value = NumberUtils.createLong(str);
            fail("createLong(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    

    protected void testCreateBigIntegerFailure(final String str) {
        try {
            final BigInteger value = NumberUtils.createBigInteger(str);
            fail("createBigInteger(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    

    protected void testCreateBigDecimalFailure(final String str) {
        try {
            final BigDecimal value = NumberUtils.createBigDecimal(str);
            fail("createBigDecimal(\"" + str + "\") should have failed: " + value);
        } catch (final NumberFormatException ex) {
            // empty
        }
    }

    // min/max tests
    // ----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    // Testing JDK against old Lang functionality
    

    

    

    /**
     * Tests isNumber(String) and tests that createNumber(String) returns
     * a valid number iff isNumber(String) returns false.
     */
    

    private boolean checkCreateNumber(final String val) {
        try {
            final Object obj = NumberUtils.createNumber(val);
            if (obj == null) {
                return false;
            }
            return true;
        } catch (final NumberFormatException e) {
            return false;
       }
    }

    

    

    

}
