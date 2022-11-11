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
public void testMinFloat20() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss62() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsDigits79() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_nullArray87() { 
     NumberUtils.max((byte[]) null); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss105() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber158() { 
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
public void testMaxDouble192() { 
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
@Test
public void testIsNumber193() { 
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
public void testMinShort195() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testToLongString319() { 
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
public void testIsDigits350() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testIsNumber358() { 
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
public void testMaxInt384() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testCreateNumberMagnitude411() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinLong_nullArray416() { 
     NumberUtils.min((long[]) null); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss500() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaxByte552() { 
     assertEquals("max(byte[]) failed for array length 1", 5, NumberUtils.max(new byte[] { 5 })); 
     assertEquals("max(byte[]) failed for array length 2", 9, NumberUtils.max(new byte[] { 6, 9 })); 
     assertEquals("max(byte[]) failed for array length 5", 10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinimumShort564() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaxDouble633() { 
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
@Test
public void testMinimumByte706() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMinimumShort723() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testToByteStringI736() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testMinInt741() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testIsNumber764() { 
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
public void testIsNumber777() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testMaxLong_emptyArray835() { 
     NumberUtils.max(new long[0]); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinInt_emptyArray843() { 
     NumberUtils.min(new int[0]); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss896() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss898() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss901() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinimumShort905() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testIsNumber922() { 
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
public void testIsNumber959() { 
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
public void testIsNumber980() { 
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
public void testIsNumber994() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss1010() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber1032() { 
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
public void testCreateNumberMagnitude1066() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringToDoubleString1091() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testToShortString1110() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testIsNumber1114() { 
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
public void testMinLong1139() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testCreateInteger1156() { 
     assertEquals("createInteger(String) failed", Integer.valueOf("12345"), NumberUtils.createInteger("12345")); 
     assertEquals("createInteger(null) failed", null, NumberUtils.createInteger(null)); 
     this.testCreateIntegerFailure(""); 
     this.testCreateIntegerFailure(" "); 
     this.testCreateIntegerFailure("\b\t\n\f\r"); 
     this.testCreateIntegerFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testMaxFloat1168() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testMinDouble1176() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testToFloatString1185() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testLang3811203() { 
     assertTrue(Double.isNaN(NumberUtils.min(1.2, 2.5, Double.NaN))); 
     assertTrue(Double.isNaN(NumberUtils.max(1.2, 2.5, Double.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.min(1.2f, 2.5f, Float.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.max(1.2f, 2.5f, Float.NaN))); 
     final double[] a = new double[] { 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(a))); 
     assertTrue(Double.isNaN(NumberUtils.min(a))); 
     final double[] b = new double[] { Double.NaN, 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(b))); 
     assertTrue(Double.isNaN(NumberUtils.min(b))); 
     final float[] aF = new float[] { 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(aF))); 
     final float[] bF = new float[] { Float.NaN, 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(bF))); 
 }
@Test
public void testIsNumber1245() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss1269() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1290() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinShort1315() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMaxFloat1330() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1338() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber1358() { 
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
public void testIsNumber1394() { 
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
public void testMinFloat1402() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testMaximumByte1439() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinByte_emptyArray1485() { 
     NumberUtils.min(new byte[0]); 
 }
@Test
public void testIsNumber1498() { 
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
public void testCreateNumberMagnitude1520() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1533() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1594() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringToDoubleString1595() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1603() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber1640() { 
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
public void testIsNumber1648() { 
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
public void testIsDigits1687() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testMaxByte1727() { 
     assertEquals("max(byte[]) failed for array length 1", 5, NumberUtils.max(new byte[] { 5 })); 
     assertEquals("max(byte[]) failed for array length 2", 9, NumberUtils.max(new byte[] { 6, 9 })); 
     assertEquals("max(byte[]) failed for array length 5", 10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testIsDigits1733() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1739() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1750() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber1754() { 
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
public void testMinInt1849() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testCreateNumberMagnitude1857() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsDigits1873() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testMaximumFloat1888() { 
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
public void testMaximumShort1895() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss1901() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testToIntString1915() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testMinInt1929() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testCreateNumberMagnitude1941() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumShort1950() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testMinFloat2019() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testMaxInt2030() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testIsNumber2034() { 
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
public void testToByteString2035() { 
     assertTrue("toByte(String) 1 failed", NumberUtils.toByte("123") == 123); 
     assertTrue("toByte(String) 2 failed", NumberUtils.toByte("abc") == 0); 
     assertTrue("toByte(empty) failed", NumberUtils.toByte("") == 0); 
     assertTrue("toByte(null) failed", NumberUtils.toByte(null) == 0); 
 }
@Test
public void testToShortString2109() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxLong_emptyArray2134() { 
     NumberUtils.max(new long[0]); 
 }
@Test
public void testToFloatString2171() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testMinimumByte2173() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testIsNumber2199() { 
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
public void testMaximumInt2203() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testCreateNumberMagnitude2218() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testCreateNumberMagnitude2222() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumLong2261() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss2311() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinByte2324() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMinDouble2326() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testMaximumInt2331() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testMaxByte2359() { 
     assertEquals("max(byte[]) failed for array length 1", 5, NumberUtils.max(new byte[] { 5 })); 
     assertEquals("max(byte[]) failed for array length 2", 9, NumberUtils.max(new byte[] { 6, 9 })); 
     assertEquals("max(byte[]) failed for array length 5", 10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testToByteStringI2368() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testIsNumber2411() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss2429() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinimumInt2431() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_nullArray2442() { 
     NumberUtils.max((byte[]) null); 
 }
@Test
public void testIsNumber2448() { 
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
public void testToFloatString2469() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testToFloatString2495() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testMinInt2535() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testIsNumber2544() { 
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
public void testIsNumber2556() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss2563() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaximumByte2572() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss2605() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinByte2623() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_nullArray2626() { 
     NumberUtils.max((byte[]) null); 
 }
@Test
public void testIsNumber2656() { 
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
public void testToLongString2684() { 
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
public void testToByteStringI2709() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testIsNumber2739() { 
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
public void testMinDouble2752() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testCreateNumberMagnitude2768() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumInt2874() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testMinLong2906() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMinimumInt2962() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testCreateNumberMagnitude3028() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testCreateBigInteger3067() { 
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
public void testConstructor3102() { 
     assertNotNull(new NumberUtils()); 
     final Constructor<?>[] cons = NumberUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(NumberUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(NumberUtils.class.getModifiers())); 
 }
@Test
public void testMinDouble3140() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testMinShort3143() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss3144() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss3174() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinimumByte3213() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testCreateNumberMagnitude3217() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_nullArray3279() { 
     NumberUtils.max((byte[]) null); 
 }
@Test
public void testMinimumByte3283() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testToIntString3299() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testIsNumber3309() { 
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
public void testIsNumber3322() { 
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
public void testMaxLong3337() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testCreateNumberMagnitude3367() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinimumLong3387() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testIsNumber3388() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testMaxLong_emptyArray3397() { 
     NumberUtils.max(new long[0]); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss3402() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinimumByte3415() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testToShortString3446() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testCreateNumberMagnitude3447() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber3555() { 
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
public void testMaxLong3560() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinimumLong3582() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testMinByte3591() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMinimumLong3596() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testIsNumber3603() { 
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
public void testMaxLong3616() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testCreateNumberMagnitude3618() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber3650() { 
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
public void testIsNumber3672() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss3703() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber3719() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss3751() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testLang3813767() { 
     assertTrue(Double.isNaN(NumberUtils.min(1.2, 2.5, Double.NaN))); 
     assertTrue(Double.isNaN(NumberUtils.max(1.2, 2.5, Double.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.min(1.2f, 2.5f, Float.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.max(1.2f, 2.5f, Float.NaN))); 
     final double[] a = new double[] { 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(a))); 
     assertTrue(Double.isNaN(NumberUtils.min(a))); 
     final double[] b = new double[] { Double.NaN, 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(b))); 
     assertTrue(Double.isNaN(NumberUtils.min(b))); 
     final float[] aF = new float[] { 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(aF))); 
     final float[] bF = new float[] { Float.NaN, 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(bF))); 
 }
@Test
public void testCreateNumberMagnitude3772() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumShort3785() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testIsNumber3808() { 
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
public void testMinLong3815() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testToByteStringI3878() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testIsNumber3903() { 
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
public void testCreateNumberMagnitude3979() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testCreateNumberMagnitude4000() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testLang3814020() { 
     assertTrue(Double.isNaN(NumberUtils.min(1.2, 2.5, Double.NaN))); 
     assertTrue(Double.isNaN(NumberUtils.max(1.2, 2.5, Double.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.min(1.2f, 2.5f, Float.NaN))); 
     assertTrue(Float.isNaN(NumberUtils.max(1.2f, 2.5f, Float.NaN))); 
     final double[] a = new double[] { 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(a))); 
     assertTrue(Double.isNaN(NumberUtils.min(a))); 
     final double[] b = new double[] { Double.NaN, 1.2, Double.NaN, 3.7, 27.0, 42.0, Double.NaN }; 
     assertTrue(Double.isNaN(NumberUtils.max(b))); 
     assertTrue(Double.isNaN(NumberUtils.min(b))); 
     final float[] aF = new float[] { 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(aF))); 
     final float[] bF = new float[] { Float.NaN, 1.2f, Float.NaN, 3.7f, 27.0f, 42.0f, Float.NaN }; 
     assertTrue(Float.isNaN(NumberUtils.max(bF))); 
 }
@Test
public void testMinDouble4064() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testStringToDoubleString4085() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testIsNumber4126() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss4145() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testCreateNumberMagnitude4150() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringToDoubleString4178() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4191() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaxLong4228() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testIsNumber4252() { 
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
public void testMaximumFloat4287() { 
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
public void testMinFloat4291() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testIsNumber4306() { 
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
public void testToFloatString4314() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testMaximumDouble4330() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss4332() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaximumDouble4364() { 
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
public void testMinDouble4365() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testIsNumber4381() { 
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
public void testMinShort4418() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testToIntString4429() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4491() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4501() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4521() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber4591() { 
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
public void testToIntString4597() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testCreateLong4599() { 
     assertEquals("createLong(String) failed", Long.valueOf("12345"), NumberUtils.createLong("12345")); 
     assertEquals("createLong(null) failed", null, NumberUtils.createLong(null)); 
     this.testCreateLongFailure(""); 
     this.testCreateLongFailure(" "); 
     this.testCreateLongFailure("\b\t\n\f\r"); 
     this.testCreateLongFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testIsNumber4611() { 
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
public void testMinimumFloat4619() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(low, NumberUtils.min(low, mid, high), 0.0001f); 
     assertEquals(low, NumberUtils.min(mid, low, high), 0.0001f); 
     assertEquals(low, NumberUtils.min(mid, high, low), 0.0001f); 
     assertEquals(low, NumberUtils.min(low, mid, low), 0.0001f); 
     assertEquals(mid, NumberUtils.min(high, mid, high), 0.0001f); 
 }
@Test
public void testCreateNumberMagnitude4621() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumShort4626() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringToDoubleString4630() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testMaximumLong4662() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4688() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinShort4718() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testIsNumber4729() { 
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
public void testMinFloat4756() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4792() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaximumByte4793() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testMinimumLong4846() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testMaxFloat4860() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testCreateNumberMagnitude4873() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testToByteString4874() { 
     assertTrue("toByte(String) 1 failed", NumberUtils.toByte("123") == 123); 
     assertTrue("toByte(String) 2 failed", NumberUtils.toByte("abc") == 0); 
     assertTrue("toByte(empty) failed", NumberUtils.toByte("") == 0); 
     assertTrue("toByte(null) failed", NumberUtils.toByte(null) == 0); 
 }
@Test
public void testMinimumShort4886() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss4893() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaximumLong4896() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testCreateNumberMagnitude4976() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinShort4977() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testToShortString5006() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testMaximumByte5028() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testIsNumber5039() { 
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
public void testMinLong5063() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMaxByte5115() { 
     assertEquals("max(byte[]) failed for array length 1", 5, NumberUtils.max(new byte[] { 5 })); 
     assertEquals("max(byte[]) failed for array length 2", 9, NumberUtils.max(new byte[] { 6, 9 })); 
     assertEquals("max(byte[]) failed for array length 5", 10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinFloat5131() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testCreateFloat5143() { 
     assertEquals("createFloat(String) failed", Float.valueOf("1234.5"), NumberUtils.createFloat("1234.5")); 
     assertEquals("createFloat(null) failed", null, NumberUtils.createFloat(null)); 
     this.testCreateFloatFailure(""); 
     this.testCreateFloatFailure(" "); 
     this.testCreateFloatFailure("\b\t\n\f\r"); 
     this.testCreateFloatFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testToShortString5188() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testStringToDoubleString5191() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testMaximumLong5244() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testCreateNumberMagnitude5255() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber5262() { 
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
public void testIsNumber5277() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss5319() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testCreateNumberMagnitude5343() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber5353() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testMinInt_emptyArray5361() { 
     NumberUtils.min(new int[0]); 
 }
@Test
public void testIsNumber5368() { 
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
public void testToByteStringI5372() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testMaxDouble5387() { 
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
@Test
public void testConstructor5437() { 
     assertNotNull(new NumberUtils()); 
     final Constructor<?>[] cons = NumberUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(NumberUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(NumberUtils.class.getModifiers())); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss5486() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaxLong5502() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinInt5520() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testCreateNumber5529() { 
     assertEquals("createNumber(String) 1 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5")); 
     assertEquals("createNumber(String) 2 failed", Integer.valueOf("12345"), NumberUtils.createNumber("12345")); 
     assertEquals("createNumber(String) 3 failed", Double.valueOf("1234.5"), NumberUtils.createNumber("1234.5D")); 
     assertEquals("createNumber(String) 3 failed", Double.valueOf("1234.5"), NumberUtils.createNumber("1234.5d")); 
     assertEquals("createNumber(String) 4 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5F")); 
     assertEquals("createNumber(String) 4 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5f")); 
     assertEquals("createNumber(String) 5 failed", Long.valueOf(Integer.MAX_VALUE + 1L), NumberUtils.createNumber("" + (Integer.MAX_VALUE + 1L))); 
     assertEquals("createNumber(String) 6 failed", Long.valueOf(12345), NumberUtils.createNumber("12345L")); 
     assertEquals("createNumber(String) 6 failed", Long.valueOf(12345), NumberUtils.createNumber("12345l")); 
     assertEquals("createNumber(String) 7 failed", Float.valueOf("-1234.5"), NumberUtils.createNumber("-1234.5")); 
     assertEquals("createNumber(String) 8 failed", Integer.valueOf("-12345"), NumberUtils.createNumber("-12345")); 
     assertTrue("createNumber(String) 9a failed", 0xFADE == NumberUtils.createNumber("0xFADE").intValue()); 
     assertTrue("createNumber(String) 9b failed", 0xFADE == NumberUtils.createNumber("0Xfade").intValue()); 
     assertTrue("createNumber(String) 10a failed", -0xFADE == NumberUtils.createNumber("-0xFADE").intValue()); 
     assertTrue("createNumber(String) 10b failed", -0xFADE == NumberUtils.createNumber("-0Xfade").intValue()); 
     assertEquals("createNumber(String) 11 failed", Double.valueOf("1.1E200"), NumberUtils.createNumber("1.1E200")); 
     assertEquals("createNumber(String) 12 failed", Float.valueOf("1.1E20"), NumberUtils.createNumber("1.1E20")); 
     assertEquals("createNumber(String) 13 failed", Double.valueOf("-1.1E200"), NumberUtils.createNumber("-1.1E200")); 
     assertEquals("createNumber(String) 14 failed", Double.valueOf("1.1E-200"), NumberUtils.createNumber("1.1E-200")); 
     assertEquals("createNumber(null) failed", null, NumberUtils.createNumber(null)); 
     assertEquals("createNumber(String) failed", new BigInteger("12345678901234567890"), NumberUtils.createNumber("12345678901234567890L")); 
     assertEquals("createNumber(String) 15 failed", new BigDecimal("1.1E-700"), NumberUtils.createNumber("1.1E-700F")); 
     assertEquals("createNumber(String) 16 failed", Long.valueOf("10" + Integer.MAX_VALUE), NumberUtils.createNumber("10" + Integer.MAX_VALUE + "L")); 
     assertEquals("createNumber(String) 17 failed", Long.valueOf("10" + Integer.MAX_VALUE), NumberUtils.createNumber("10" + Integer.MAX_VALUE)); 
     assertEquals("createNumber(String) 18 failed", new BigInteger("10" + Long.MAX_VALUE), NumberUtils.createNumber("10" + Long.MAX_VALUE)); 
     assertEquals("createNumber(String) LANG-521 failed", Float.valueOf("2."), NumberUtils.createNumber("2.")); 
     assertFalse("createNumber(String) succeeded", checkCreateNumber("1eE")); 
     assertEquals("createNumber(String) LANG-693 failed", Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("" + Double.MAX_VALUE)); 
     final Number bigNum = NumberUtils.createNumber("-1.1E-700F"); 
     assertNotNull(bigNum); 
     assertEquals(BigDecimal.class, bigNum.getClass()); 
 }
@Test
public void testIsNumber5568() { 
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
public void testCreateNumberMagnitude5605() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber5649() { 
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
public void testIsDigits5658() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testToShortString5679() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testCreateNumberMagnitude5690() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaxDouble5715() { 
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
@Test
public void testIsNumber5739() { 
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
public void testCreateNumberMagnitude5743() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinByte5752() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss5783() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber5794() { 
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
public void testMaxDouble5796() { 
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
@Test
public void testMaxFloat5825() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss5868() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaxFloat5900() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testMinDouble5917() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testToIntString5920() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testStringToDoubleString5957() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testCreateNumberMagnitude5961() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss6012() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber6017() { 
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
public void testToIntString6028() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testMinimumLong6093() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test
public void testIsNumber6124() { 
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
public void testIsNumber6164() { 
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
public void testCreateNumberMagnitude6165() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber6175() { 
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
public void testStringCreateNumberEnsureNoPrecisionLoss6215() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss6222() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxDouble_emptyArray6224() { 
     NumberUtils.max(new double[0]); 
 }
@Test
public void testCreateNumber6270() { 
     assertEquals("createNumber(String) 1 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5")); 
     assertEquals("createNumber(String) 2 failed", Integer.valueOf("12345"), NumberUtils.createNumber("12345")); 
     assertEquals("createNumber(String) 3 failed", Double.valueOf("1234.5"), NumberUtils.createNumber("1234.5D")); 
     assertEquals("createNumber(String) 3 failed", Double.valueOf("1234.5"), NumberUtils.createNumber("1234.5d")); 
     assertEquals("createNumber(String) 4 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5F")); 
     assertEquals("createNumber(String) 4 failed", Float.valueOf("1234.5"), NumberUtils.createNumber("1234.5f")); 
     assertEquals("createNumber(String) 5 failed", Long.valueOf(Integer.MAX_VALUE + 1L), NumberUtils.createNumber("" + (Integer.MAX_VALUE + 1L))); 
     assertEquals("createNumber(String) 6 failed", Long.valueOf(12345), NumberUtils.createNumber("12345L")); 
     assertEquals("createNumber(String) 6 failed", Long.valueOf(12345), NumberUtils.createNumber("12345l")); 
     assertEquals("createNumber(String) 7 failed", Float.valueOf("-1234.5"), NumberUtils.createNumber("-1234.5")); 
     assertEquals("createNumber(String) 8 failed", Integer.valueOf("-12345"), NumberUtils.createNumber("-12345")); 
     assertTrue("createNumber(String) 9a failed", 0xFADE == NumberUtils.createNumber("0xFADE").intValue()); 
     assertTrue("createNumber(String) 9b failed", 0xFADE == NumberUtils.createNumber("0Xfade").intValue()); 
     assertTrue("createNumber(String) 10a failed", -0xFADE == NumberUtils.createNumber("-0xFADE").intValue()); 
     assertTrue("createNumber(String) 10b failed", -0xFADE == NumberUtils.createNumber("-0Xfade").intValue()); 
     assertEquals("createNumber(String) 11 failed", Double.valueOf("1.1E200"), NumberUtils.createNumber("1.1E200")); 
     assertEquals("createNumber(String) 12 failed", Float.valueOf("1.1E20"), NumberUtils.createNumber("1.1E20")); 
     assertEquals("createNumber(String) 13 failed", Double.valueOf("-1.1E200"), NumberUtils.createNumber("-1.1E200")); 
     assertEquals("createNumber(String) 14 failed", Double.valueOf("1.1E-200"), NumberUtils.createNumber("1.1E-200")); 
     assertEquals("createNumber(null) failed", null, NumberUtils.createNumber(null)); 
     assertEquals("createNumber(String) failed", new BigInteger("12345678901234567890"), NumberUtils.createNumber("12345678901234567890L")); 
     assertEquals("createNumber(String) 15 failed", new BigDecimal("1.1E-700"), NumberUtils.createNumber("1.1E-700F")); 
     assertEquals("createNumber(String) 16 failed", Long.valueOf("10" + Integer.MAX_VALUE), NumberUtils.createNumber("10" + Integer.MAX_VALUE + "L")); 
     assertEquals("createNumber(String) 17 failed", Long.valueOf("10" + Integer.MAX_VALUE), NumberUtils.createNumber("10" + Integer.MAX_VALUE)); 
     assertEquals("createNumber(String) 18 failed", new BigInteger("10" + Long.MAX_VALUE), NumberUtils.createNumber("10" + Long.MAX_VALUE)); 
     assertEquals("createNumber(String) LANG-521 failed", Float.valueOf("2."), NumberUtils.createNumber("2.")); 
     assertFalse("createNumber(String) succeeded", checkCreateNumber("1eE")); 
     assertEquals("createNumber(String) LANG-693 failed", Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("" + Double.MAX_VALUE)); 
     final Number bigNum = NumberUtils.createNumber("-1.1E-700F"); 
     assertNotNull(bigNum); 
     assertEquals(BigDecimal.class, bigNum.getClass()); 
 }
@Test
public void testToFloatString6293() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testMinLong6332() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testStringToDoubleString6413() { 
     assertTrue("toDouble(String) 1 failed", NumberUtils.toDouble("-1.2345") == -1.2345d); 
     assertTrue("toDouble(String) 2 failed", NumberUtils.toDouble("1.2345") == 1.2345d); 
     assertTrue("toDouble(String) 3 failed", NumberUtils.toDouble("abc") == 0.0d); 
     assertTrue("toDouble(Double.MAX_VALUE) failed", NumberUtils.toDouble(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toDouble(Double.MIN_VALUE) failed", NumberUtils.toDouble(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toDouble(empty) failed", NumberUtils.toDouble("") == 0.0d); 
     assertTrue("toDouble(null) failed", NumberUtils.toDouble(null) == 0.0d); 
 }
@Test
public void testMaxInt6420() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testIsNumber6423() { 
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
public void testMaxByte6471() { 
     assertEquals("max(byte[]) failed for array length 1", 5, NumberUtils.max(new byte[] { 5 })); 
     assertEquals("max(byte[]) failed for array length 2", 9, NumberUtils.max(new byte[] { 6, 9 })); 
     assertEquals("max(byte[]) failed for array length 5", 10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new byte[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testIsNumber6565() { 
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
public void testMaximumByte6577() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss6593() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber6594() { 
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
public void testMinShort6595() { 
     assertEquals("min(short[]) failed for array length 1", 5, NumberUtils.min(new short[] { 5 })); 
     assertEquals("min(short[]) failed for array length 2", 6, NumberUtils.min(new short[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new short[] { -5, 0, -10, 5, 10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxLong_emptyArray6617() { 
     NumberUtils.max(new long[0]); 
 }
@Test
public void testCreateNumberMagnitude6662() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber6669() { 
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
public void testMinimumLong6687() { 
     assertEquals("minimum(long,long,long) 1 failed", 12345L, NumberUtils.min(12345L, 12345L + 1L, 12345L + 2L)); 
     assertEquals("minimum(long,long,long) 2 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345 + 2L)); 
     assertEquals("minimum(long,long,long) 3 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L + 2L, 12345L)); 
     assertEquals("minimum(long,long,long) 4 failed", 12345L, NumberUtils.min(12345L + 1L, 12345L, 12345L)); 
     assertEquals("minimum(long,long,long) 5 failed", 12345L, NumberUtils.min(12345L, 12345L, 12345L)); 
 }
@Test(expected = NumberFormatException.class) 
 public void testCreateNumberFailure_36701() { 
     NumberUtils.createNumber("-11E+0-7e00"); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss6707() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinimumInt6793() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testCreateNumberMagnitude6828() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber6832() { 
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
public void testToShortString6920() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testMaxInt6925() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMaxInt6966() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinimumInt7012() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testMinByte7037() { 
     assertEquals("min(byte[]) failed for array length 1", 5, NumberUtils.min(new byte[] { 5 })); 
     assertEquals("min(byte[]) failed for array length 2", 6, NumberUtils.min(new byte[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new byte[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMaxFloat7052() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testIsNumber7081() { 
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
public void testCreateNumberMagnitude7111() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss7194() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinByte_emptyArray7216() { 
     NumberUtils.min(new byte[0]); 
 }
@Test
public void testCreateNumberMagnitude7218() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinimumDouble7224() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(low, NumberUtils.min(low, mid, high), 0.0001); 
     assertEquals(low, NumberUtils.min(mid, low, high), 0.0001); 
     assertEquals(low, NumberUtils.min(mid, high, low), 0.0001); 
     assertEquals(low, NumberUtils.min(low, mid, low), 0.0001); 
     assertEquals(mid, NumberUtils.min(high, mid, high), 0.0001); 
 }
@Test
public void testIsNumber7255() { 
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
public void testIsNumber7302() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testMaxByte_nullArray7312() { 
     NumberUtils.max((byte[]) null); 
 }
@Test
public void testCreateNumberMagnitude7317() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss7324() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber7338() { 
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
public void testIsNumber7395() { 
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
public void testCreateNumberMagnitude7429() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss7438() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinFloat7486() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss7602() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber7615() { 
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
public void testIsNumber7625() { 
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
public void testIsNumber7655() { 
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
public void testIsNumber7687() { 
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
public void testMinimumFloat7693() { 
     final float low = 12.3f; 
     final float mid = 12.3f + 1; 
     final float high = 12.3f + 2; 
     assertEquals(low, NumberUtils.min(low, mid, high), 0.0001f); 
     assertEquals(low, NumberUtils.min(mid, low, high), 0.0001f); 
     assertEquals(low, NumberUtils.min(mid, high, low), 0.0001f); 
     assertEquals(low, NumberUtils.min(low, mid, low), 0.0001f); 
     assertEquals(mid, NumberUtils.min(high, mid, high), 0.0001f); 
 }
@Test
public void testIsNumber7695() { 
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
public void testIsNumber7708() { 
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
public void testToIntString7711() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testToByteString7721() { 
     assertTrue("toByte(String) 1 failed", NumberUtils.toByte("123") == 123); 
     assertTrue("toByte(String) 2 failed", NumberUtils.toByte("abc") == 0); 
     assertTrue("toByte(empty) failed", NumberUtils.toByte("") == 0); 
     assertTrue("toByte(null) failed", NumberUtils.toByte(null) == 0); 
 }
@Test
public void testIsNumber7795() { 
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
public void testMaximumShort7871() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss7876() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber7904() { 
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
public void testMaxFloat7920() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testIsNumber7996() { 
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
public void testIsNumber8044() { 
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
public void testCreateNumberMagnitude8049() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaxInt8059() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMinDouble8064() { 
     assertEquals("min(double[]) failed for array length 1", 5.12, NumberUtils.min(new double[] { 5.12 }), 0); 
     assertEquals("min(double[]) failed for array length 2", 6.23, NumberUtils.min(new double[] { 6.23, 9.34 }), 0); 
     assertEquals("min(double[]) failed for array length 5", -10.45, NumberUtils.min(new double[] { -10.45, -5.56, 0, 5.67, 10.78 }), 0); 
     assertEquals(-10, NumberUtils.min(new double[] { -10, -5, 0, 5, 10 }), 0.0001); 
     assertEquals(-10, NumberUtils.min(new double[] { -5, 0, -10, 5, 10 }), 0.0001); 
 }
@Test
public void testCreateNumberMagnitude8079() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinimumByte8084() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaximumShort8213() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testMaximumLong8216() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testIsNumber8220() { 
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
public void testCreateNumberMagnitude8237() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMinimumDouble8258() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(low, NumberUtils.min(low, mid, high), 0.0001); 
     assertEquals(low, NumberUtils.min(mid, low, high), 0.0001); 
     assertEquals(low, NumberUtils.min(mid, high, low), 0.0001); 
     assertEquals(low, NumberUtils.min(low, mid, low), 0.0001); 
     assertEquals(mid, NumberUtils.min(high, mid, high), 0.0001); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinLong_nullArray8305() { 
     NumberUtils.min((long[]) null); 
 }
@Test
public void testIsNumber8308() { 
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
public void testMaximumInt8329() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testToLongStringL8336() { 
     assertTrue("toLong(String,long) 1 failed", NumberUtils.toLong("12345", 5l) == 12345l); 
     assertTrue("toLong(String,long) 2 failed", NumberUtils.toLong("1234.5", 5l) == 5l); 
 }
@Test
public void testToFloatString8381() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testMaximumInt8399() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testIsNumber8445() { 
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
public void testMinimumShort8462() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testIsDigits8503() { 
     assertFalse("isDigits(null) failed", NumberUtils.isDigits(null)); 
     assertFalse("isDigits('') failed", NumberUtils.isDigits("")); 
     assertTrue("isDigits(String) failed", NumberUtils.isDigits("12345")); 
     assertFalse("isDigits(String) neg 1 failed", NumberUtils.isDigits("1234.5")); 
     assertFalse("isDigits(String) neg 3 failed", NumberUtils.isDigits("1ab")); 
     assertFalse("isDigits(String) neg 4 failed", NumberUtils.isDigits("abc")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss8515() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber8517() { 
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
public void testCreateNumberMagnitude8533() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testIsNumber8552() { 
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
public void testToShortString8568() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0); 
 }
@Test
public void testMaxFloat8586() { 
     assertEquals("max(float[]) failed for array length 1", 5.1f, NumberUtils.max(new float[] { 5.1f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.2f, NumberUtils.max(new float[] { 6.3f, 9.2f }), 0); 
     assertEquals("max(float[]) failed for float length 5", 10.4f, NumberUtils.max(new float[] { -10.5f, -5.6f, 0, 5.7f, 10.4f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test
public void testCreateNumberMagnitude8611() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testCreateNumberMagnitude8663() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss8693() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaximumByte8711() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(byte,byte,byte) 1 failed", high, NumberUtils.max(high, mid, high)); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss8803() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss8825() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testIsNumber8885() { 
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
public void testCreateDouble8886() { 
     assertEquals("createDouble(String) failed", Double.valueOf("1234.5"), NumberUtils.createDouble("1234.5")); 
     assertEquals("createDouble(null) failed", null, NumberUtils.createDouble(null)); 
     this.testCreateDoubleFailure(""); 
     this.testCreateDoubleFailure(" "); 
     this.testCreateDoubleFailure("\b\t\n\f\r"); 
     this.testCreateDoubleFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss8901() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMinFloat8905() { 
     assertEquals("min(float[]) failed for array length 1", 5.9f, NumberUtils.min(new float[] { 5.9f }), 0); 
     assertEquals("min(float[]) failed for array length 2", 6.8f, NumberUtils.min(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("min(float[]) failed for array length 5", -10.6f, NumberUtils.min(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(-10, NumberUtils.min(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(-10, NumberUtils.min(new float[] { -5, 0, -10, 5, 10 }), 0.0001f); 
 }
@Test
public void testIsNumber8908() { 
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
public void testCreateNumberMagnitude8920() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaximumInt8926() { 
     assertEquals("maximum(int,int,int) 1 failed", 12345, NumberUtils.max(12345, 12345 - 1, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 2 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345 - 2)); 
     assertEquals("maximum(int,int,int) 3 failed", 12345, NumberUtils.max(12345 - 1, 12345 - 2, 12345)); 
     assertEquals("maximum(int,int,int) 4 failed", 12345, NumberUtils.max(12345 - 1, 12345, 12345)); 
     assertEquals("maximum(int,int,int) 5 failed", 12345, NumberUtils.max(12345, 12345, 12345)); 
 }
@Test
public void testMinimumShort8940() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaximumLong8955() { 
     assertEquals("maximum(long,long,long) 1 failed", 12345L, NumberUtils.max(12345L, 12345L - 1L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 2 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L - 2L)); 
     assertEquals("maximum(long,long,long) 3 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L - 2L, 12345L)); 
     assertEquals("maximum(long,long,long) 4 failed", 12345L, NumberUtils.max(12345L - 1L, 12345L, 12345L)); 
     assertEquals("maximum(long,long,long) 5 failed", 12345L, NumberUtils.max(12345L, 12345L, 12345L)); 
 }
@Test
public void testIsNumber8970() { 
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
public void testIsNumber9018() { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testMaxDouble_emptyArray9019() { 
     NumberUtils.max(new double[0]); 
 }
@Test
public void testIsNumber9052() { 
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
public void testMaxInt9060() { 
     assertEquals("max(int[]) failed for array length 1", 5, NumberUtils.max(new int[] { 5 })); 
     assertEquals("max(int[]) failed for array length 2", 9, NumberUtils.max(new int[] { 6, 9 })); 
     assertEquals("max(int[]) failed for array length 5", 10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new int[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testToLongStringL9073() { 
     assertTrue("toLong(String,long) 1 failed", NumberUtils.toLong("12345", 5l) == 12345l); 
     assertTrue("toLong(String,long) 2 failed", NumberUtils.toLong("1234.5", 5l) == 5l); 
 }
@Test
public void testToLongStringL9089() { 
     assertTrue("toLong(String,long) 1 failed", NumberUtils.toLong("12345", 5l) == 12345l); 
     assertTrue("toLong(String,long) 2 failed", NumberUtils.toLong("1234.5", 5l) == 5l); 
 }
@Test
public void testCreateNumberMagnitude9152() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testMaxDouble9204() { 
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
@Test
public void testIsNumber9215() { 
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
public void testMinimumInt9224() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testToLongStringL9239() { 
     assertTrue("toLong(String,long) 1 failed", NumberUtils.toLong("12345", 5l) == 12345l); 
     assertTrue("toLong(String,long) 2 failed", NumberUtils.toLong("1234.5", 5l) == 5l); 
 }
@Test
public void testMinimumInt9243() { 
     assertEquals("minimum(int,int,int) 1 failed", 12345, NumberUtils.min(12345, 12345 + 1, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 2 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345 + 2)); 
     assertEquals("minimum(int,int,int) 3 failed", 12345, NumberUtils.min(12345 + 1, 12345 + 2, 12345)); 
     assertEquals("minimum(int,int,int) 4 failed", 12345, NumberUtils.min(12345 + 1, 12345, 12345)); 
     assertEquals("minimum(int,int,int) 5 failed", 12345, NumberUtils.min(12345, 12345, 12345)); 
 }
@Test
public void testCreateNumberMagnitude9295() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testToLongStringL9310() { 
     assertTrue("toLong(String,long) 1 failed", NumberUtils.toLong("12345", 5l) == 12345l); 
     assertTrue("toLong(String,long) 2 failed", NumberUtils.toLong("1234.5", 5l) == 5l); 
 }
@Test
public void testToLongString9314() { 
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
public void testToFloatString9336() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Float.MAX_VALUE) failed", NumberUtils.toFloat(Float.MAX_VALUE + "") == Float.MAX_VALUE); 
     assertTrue("toFloat(Float.MIN_VALUE) failed", NumberUtils.toFloat(Float.MIN_VALUE + "") == Float.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testCreateNumberMagnitude9346() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss9446() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testToIntString9464() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testIsNumber9496() { 
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
public void testCreateNumberMagnitude9537() { 
     assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.createNumber("3.4028235e+38")); 
     assertEquals(Double.valueOf(3.4028236e+38), NumberUtils.createNumber("3.4028236e+38")); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.createNumber("1.7976931348623157e+308")); 
     assertEquals(new BigDecimal("1.7976931348623159e+308"), NumberUtils.createNumber("1.7976931348623159e+308")); 
     assertEquals(Integer.valueOf(0x12345678), NumberUtils.createNumber("0x12345678")); 
     assertEquals(Long.valueOf(0x123456789L), NumberUtils.createNumber("0x123456789")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("0x7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("0x7fffffffffffffff0")); 
     assertEquals(Long.valueOf(0x7fffffffffffffffL), NumberUtils.createNumber("#7fffffffffffffff")); 
     assertEquals(new BigInteger("7fffffffffffffff0", 16), NumberUtils.createNumber("#7fffffffffffffff0")); 
     assertEquals(Integer.valueOf(017777777777), NumberUtils.createNumber("017777777777")); 
     assertEquals(Long.valueOf(037777777777L), NumberUtils.createNumber("037777777777")); 
     assertEquals(Long.valueOf(0777777777777777777777L), NumberUtils.createNumber("0777777777777777777777")); 
     assertEquals(new BigInteger("1777777777777777777777", 8), NumberUtils.createNumber("01777777777777777777777")); 
 }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss9549() { 
     String shouldBeFloat = "1.23"; 
     String shouldBeDouble = "3.40282354e+38"; 
     String shouldBeBigDecimal = "1.797693134862315759e+308"; 
     assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
     assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
     assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
 }
@Test
public void testMaxShort9651() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss9690(){ 
         String shouldBeFloat = "1.23"; 
         String shouldBeDouble = "3.40282354e+38"; 
         String shouldBeBigDecimal = "1.797693134862315759e+308"; 
          
         assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
         assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
         assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
     } 
     /** 
      * Test for {@link NumberUtils#toDouble(String)}. 
      */
@Test
public void testMaxShort11834() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testMaxShort11835() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testMaxShort11836() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testMaxShort11837() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testMaxShort11838() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testMaxShort11839() { 
         assertEquals( 
             "max(short[]) failed for array length 1", 
             5, 
             NumberUtils.max(new short[] { 5 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 2", 
             9, 
             NumberUtils.max(new short[] { 6, 9 })); 
  
         assertEquals( 
             "max(short[]) failed for array length 5", 
             10, 
             NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
         assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
     }
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss12581(){ 
         String shouldBeFloat = "1.23"; 
         String shouldBeDouble = "3.40282354e+38"; 
         String shouldBeBigDecimal = "1.797693134862315759e+308"; 
          
         assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
         assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
         assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
     } 
     /** 
      * Test for {@link NumberUtils#toDouble(String)}. 
      */
@Test
public void testStringCreateNumberEnsureNoPrecisionLoss12582(){ 
         String shouldBeFloat = "1.23"; 
         String shouldBeDouble = "3.40282354e+38"; 
         String shouldBeBigDecimal = "1.797693134862315759e+308"; 
          
         assertTrue(NumberUtils.createNumber(shouldBeFloat) instanceof Float); 
         assertTrue(NumberUtils.createNumber(shouldBeDouble) instanceof Double); 
         assertTrue(NumberUtils.createNumber(shouldBeBigDecimal) instanceof BigDecimal); 
     } 
     /** 
      * Test for {@link NumberUtils#toDouble(String)}. 
      */
    

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
