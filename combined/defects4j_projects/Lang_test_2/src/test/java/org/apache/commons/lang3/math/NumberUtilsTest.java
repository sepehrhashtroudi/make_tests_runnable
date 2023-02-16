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
public void testConstructor25() { 
     assertNotNull(new NumberUtils()); 
     final Constructor<?>[] cons = NumberUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(NumberUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(NumberUtils.class.getModifiers())); 
 }
@Test
public void testToIntString26() { 
     assertTrue("toInt(String) 1 failed", NumberUtils.toInt("12345") == 12345); 
     assertTrue("toInt(String) 2 failed", NumberUtils.toInt("1234.5") == 0); 
     assertTrue("toInt(String) 3 failed", NumberUtils.toInt("1ab") == 0); 
     assertTrue("toInt(String) 4 failed", NumberUtils.toInt("1ab") == 0); 
     assertTrue("toInt(Integer.MAX_VALUE) failed", NumberUtils.toInt(Integer.MAX_VALUE + "") == Integer.MAX_VALUE); 
     assertTrue("toInt(Integer.MIN_VALUE) failed", NumberUtils.toInt(Integer.MIN_VALUE + "") == Integer.MIN_VALUE); 
     assertTrue("toInt(empty) failed", NumberUtils.toInt("") == 0); 
     assertTrue("toInt(null) failed", NumberUtils.toInt(null) == 0); 
 }
@Test
public void testToIntStringI27() { 
     assertTrue("toInt(String,int) 1 failed", NumberUtils.toInt("12345", 5) == 12345); 
     assertTrue("toInt(String,int) 2 failed", NumberUtils.toInt("1234.5", 5) == 5); 
 }
@Test
public void testToByteStringI28() { 
     assertTrue("toByte(String,byte) 1 failed", NumberUtils.toByte("123", (byte) 5) == 123); 
     assertTrue("toByte(String,byte) 2 failed", NumberUtils.toByte("12.3", (byte) 5) == 5); 
 }
@Test
public void testToLongString29() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345l); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0l); 
     assertTrue("toShort(String) 3 failed", NumberUtils.toShort("1L") == 0l); 
     assertTrue("toShort(String) 4 failed", NumberUtils.toShort("1l") == 0l); 
     assertTrue("toShort(Short.MAX_VALUE) failed", NumberUtils.toShort(Short.MAX_VALUE + "") == Short.MAX_VALUE); 
     assertTrue("toShort(Short.MIN_VALUE) failed", NumberUtils.toShort(Short.MIN_VALUE + "") == Short.MIN_VALUE); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0l); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0l); 
 }
@Test
public void testToLongString30() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345l); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0l); 
     assertTrue("toShort(String) 3 failed", NumberUtils.toShort("1ab") == 0l); 
     assertTrue("toShort(String) 4 failed", NumberUtils.toShort("1ab") == 0l); 
     assertTrue("toShort(Short.MAX_VALUE) failed", NumberUtils.toShort(Short.MAX_VALUE + "") == Short.MAX_VALUE); 
     assertTrue("toShort(Short.MIN_VALUE) failed", NumberUtils.toShort(Short.MIN_VALUE + "") == Short.MIN_VALUE); 
     assertTrue("toShort(empty) failed", NumberUtils.toShort("") == 0l); 
     assertTrue("toShort(null) failed", NumberUtils.toShort(null) == 0l); 
 }
@Test
public void testToLongString31() { 
     assertTrue("toShort(String) 1 failed", NumberUtils.toShort("12345") == 12345l); 
     assertTrue("toShort(String) 2 failed", NumberUtils.toShort("abc") == 0l); 
     assertTrue("toShort(String) 3 failed", NumberUtils.toShort("1ab") == 0l); 
     assertTrue("toShort(String) 4 failed", NumberUtils.toShort("1ab") == 0l); 
     assertTrue("toShort(String) 5 failed", NumberUtils.toShort("1 5") == 0l); 
 }
@Test(expected = NumberFormatException.class) 
 public void testCreateNumberFailure_432() { 
     NumberUtils.createNumber("1eE+00001"); 
 }
@Test
public void testCreateInteger33() { 
     assertEquals("createInteger(String) failed", Integer.valueOf("12345"), NumberUtils.createInteger("12345")); 
     assertEquals("createInteger(null) failed", null, NumberUtils.createInteger(null)); 
     this.testCreateIntegerFailure(""); 
     this.testCreateIntegerFailure(" "); 
     this.testCreateIntegerFailure("\b\t\n\f\r"); 
     this.testCreateIntegerFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testCreateLong34() { 
     assertEquals("createLong(String) failed", Long.valueOf("12345"), NumberUtils.createLong("12345")); 
     assertEquals("createLong(null) failed", null, NumberUtils.createLong(null)); 
     this.testCreateLongFailure(""); 
     this.testCreateLongFailure(" "); 
     this.testCreateLongFailure("\b\t\n\f\r"); 
     this.testCreateLongFailure("\u00A0\uFEFF\u000B\u000C\u001C\u001D\u001E\u001F"); 
 }
@Test
public void testMinLong35() { 
     assertEquals("min(long[]) failed for array length 1", 5, NumberUtils.min(new long[] { 5 })); 
     assertEquals("min(long[]) failed for array length 2", 6, NumberUtils.min(new long[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new long[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testMinInt36() { 
     assertEquals("min(int[]) failed for array length 1", 5, NumberUtils.min(new int[] { 5 })); 
     assertEquals("min(int[]) failed for array length 2", 6, NumberUtils.min(new int[] { 6, 9 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -10, -5, 0, 5, 10 })); 
     assertEquals(-10, NumberUtils.min(new int[] { -5, 0, -10, 5, 10 })); 
 }
@Test
public void testLang38137() { 
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
public void testMaxLong38() { 
     assertEquals("max(long[]) failed for array length 1", 5, NumberUtils.max(new long[] { 5 })); 
     assertEquals("max(long[]) failed for array length 2", 9, NumberUtils.max(new long[] { 6, 9 })); 
     assertEquals("max(long[]) failed for array length 5", 10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new long[] { -5, 0, 10, 5, -10 })); 
 }
@Test
public void testMaxShort39() { 
     assertEquals("max(short[]) failed for array length 1", 5, NumberUtils.max(new short[] { 5 })); 
     assertEquals("max(short[]) failed for array length 2", 9, NumberUtils.max(new short[] { 6, 9 })); 
     assertEquals("max(short[]) failed for array length 5", 10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new short[] { -10, -5, 0, 5, 10 })); 
     assertEquals(10, NumberUtils.max(new short[] { -5, 0, 10, 5, -10 })); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testMaxInt_emptyArray40() { 
     NumberUtils.max(new int[0]); 
 }
@Test
public void testMinimumLong41() { 
     final long low = 12345L; 
     final long mid = 12345L + 1L; 
     final long high = 12345L + 2L; 
     assertEquals("minimum(long,long,long) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(long,long,long) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(long,long,long) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(long,long,long) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMinimumInt42() { 
     final int low = 12; 
     final int mid = 12 + 1; 
     final int high = 12 + 2; 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMinimumInt43() { 
     final int low = 123; 
     final int mid = 123 + 1; 
     final int high = 123 + 2; 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(int,int,int) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMinimumByte44() { 
     final byte low = 123; 
     final byte mid = 123 + 1; 
     final byte high = 123 + 2; 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, low, high)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(mid, high, low)); 
     assertEquals("minimum(byte,byte,byte) 1 failed", low, NumberUtils.min(low, mid, low)); 
 }
@Test
public void testMaximumShort45() { 
     final short low = 1234; 
     final short mid = 1234 + 1; 
     final short high = 1234 + 2; 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(low, mid, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, low, high)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(mid, high, low)); 
     assertEquals("maximum(short,short,short) 1 failed", high, NumberUtils.max(high, mid, low)); 
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
