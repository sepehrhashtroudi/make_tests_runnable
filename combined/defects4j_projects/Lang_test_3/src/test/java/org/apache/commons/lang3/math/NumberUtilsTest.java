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
public void testToIntString26() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("abc") == 0); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testToLongString27() { 
     assertTrue("toLong(String) 1 failed", NumberUtils.toLong("12345") == 12345L); 
     assertTrue("toLong(String) 2 failed", NumberUtils.toLong("abc") == 0L); 
     assertTrue("toLong(empty) failed", NumberUtils.toLong("") == 0L); 
     assertTrue("toLong(null) failed", NumberUtils.toLong(null) == 0L); 
 }
@Test
public void testStringToLongString28() { 
     assertTrue("toLong(String) 1 failed", NumberUtils.toLong("12345") == 12345L); 
     assertTrue("toLong(String) 2 failed", NumberUtils.toLong("abc") == 0L); 
     assertTrue("toLong(empty) failed", NumberUtils.toLong("") == 0L); 
     assertTrue("toLong(null) failed", NumberUtils.toLong(null) == 0L); 
 }
@Test
public void testToFloatString29() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345f); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345f); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Double.MAX_VALUE) failed", NumberUtils.toFloat(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toFloat(Double.MIN_VALUE) failed", NumberUtils.toFloat(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testToFloatString30() { 
     assertTrue("toFloat(String) 1 failed", NumberUtils.toFloat("-1.2345") == -1.2345d); 
     assertTrue("toFloat(String) 2 failed", NumberUtils.toFloat("1.2345") == 1.2345d); 
     assertTrue("toFloat(String) 3 failed", NumberUtils.toFloat("abc") == 0.0f); 
     assertTrue("toFloat(Double.MAX_VALUE) failed", NumberUtils.toFloat(Double.MAX_VALUE + "") == Double.MAX_VALUE); 
     assertTrue("toFloat(Double.MIN_VALUE) failed", NumberUtils.toFloat(Double.MIN_VALUE + "") == Double.MIN_VALUE); 
     assertTrue("toFloat(empty) failed", NumberUtils.toFloat("") == 0.0f); 
     assertTrue("toFloat(null) failed", NumberUtils.toFloat(null) == 0.0f); 
 }
@Test
public void testCreateDouble31() { 
     assertEquals("createDouble(String) failed", Double.valueOf("1234.5"), NumberUtils.createDouble("1234.5")); 
     assertEquals("createDouble(null) failed", null, NumberUtils.createDouble(null)); 
     this.testCreateDoubleFailure(""); 
     this.testCreateDoubleFailure(" "); 
     this.testCreateDoubleFailure("\b\t\n\f\r"); 
     this.testCreateDoubleFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxInt_emptyArray33() { 
     NumberUtils.max(new int[0]); 
 }
@Test
public void testLang38134() { 
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
public void testMaxFloat35() { 
     assertEquals("max(float[]) failed for array length 1", 5.9f, NumberUtils.max(new float[] { 5.9f }), 0); 
     assertEquals("max(float[]) failed for array length 2", 9.8f, NumberUtils.max(new float[] { 6.8f, 9.7f }), 0); 
     assertEquals("max(float[]) failed for array length 5", 10.6f, NumberUtils.max(new float[] { -10.6f, -5.5f, 0, 5.4f, 10.3f }), 0); 
     assertEquals(10, NumberUtils.max(new float[] { -10, -5, 0, 5, 10 }), 0.0001f); 
     assertEquals(10, NumberUtils.max(new float[] { -5, 0, 10, 5, -10 }), 0.0001f); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinLong_nullArray36() { 
     NumberUtils.min((long[]) null); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMinLong_emptyArray37() { 
     NumberUtils.min(new long[0]); 
 }
@Test
public void testMinimumShort38() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(short,short,short) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaximumDouble39() { 
     final double low = 12.3; 
     final double mid = 12.3 + 1; 
     final double high = 12.3 + 2; 
     assertEquals(high, NumberUtils.max(low, mid, high), 0.0001); 
     assertEquals(high, NumberUtils.max(mid, low, high), 0.0001); 
     assertEquals(high, NumberUtils.max(mid, high, low), 0.0001); 
     assertEquals(mid, NumberUtils.max(low, mid, low), 0.0001); 
     assertEquals(high, NumberUtils.max(high, mid, high), 0.0001); 
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
