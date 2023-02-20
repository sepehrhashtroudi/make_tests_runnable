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
package org.apache.commons.lang3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Class to test BitField functionality
 *
 * @version $Id$
 */
public class BitFieldTest  {

    private static final BitField bf_multi  = new BitField(0x3F80);
    private static final BitField bf_single = new BitField(0x4000);
    private static final BitField bf_zero = new BitField(0);

    /**
     * test the getValue() method
     */
@Test
public void testByte112() { 
     assertEquals(0, new BitField(0).setByteBoolean((byte) 0, true)); 
     assertEquals(1, new BitField(1).setByteBoolean((byte) 0, true)); 
     assertEquals(2, new BitField(2).setByteBoolean((byte) 0, true)); 
     assertEquals(4, new BitField(4).setByteBoolean((byte) 0, true)); 
     assertEquals(8, new BitField(8).setByteBoolean((byte) 0, true)); 
     assertEquals(16, new BitField(16).setByteBoolean((byte) 0, true)); 
     assertEquals(32, new BitField(32).setByteBoolean((byte) 0, true)); 
     assertEquals(64, new BitField(64).setByteBoolean((byte) 0, true)); 
     assertEquals(-128, new BitField(128).setByteBoolean((byte) 0, true)); 
     assertEquals(1, new BitField(0).setByteBoolean((byte) 1, false)); 
     assertEquals(0, new BitField(1).setByteBoolean((byte) 1, false)); 
     assertEquals(0, new BitField(2).setByteBoolean((byte) 2, false)); 
     assertEquals(0, new BitField(4).setByteBoolean((byte) 4, false)); 
     assertEquals(0, new BitField(8).setByteBoolean((byte) 8, false)); 
     assertEquals(0, new BitField(16).setByteBoolean((byte) 16, false)); 
     assertEquals(0, new BitField(32).setByteBoolean((byte) 32, false)); 
     assertEquals(0, new BitField(64).setByteBoolean((byte) 64, false)); 
     assertEquals(0, new BitField(128).setByteBoolean((byte) 128, false)); 
     assertEquals(-2, new BitField(1).setByteBoolean((byte) 255, false)); 
     final byte clearedBit = new BitField(0x40).setByteBoolean((byte) -63, false); 
     assertFalse(new BitField(0x40).isSet(clearedBit)); 
 }
@Test
public void testGetShortValue113() { 
     assertEquals(bf_multi.getShortValue((short) -1), (short) 127); 
     assertEquals(bf_multi.getShortValue((short) 0), (short) 0); 
     assertEquals(bf_single.getShortValue((short) -1), (short) 1); 
     assertEquals(bf_single.getShortValue((short) 0), (short) 0); 
     assertEquals(bf_zero.getShortValue((short) -1), (short) 0); 
     assertEquals(bf_zero.getShortValue((short) 0), (short) 0); 
 }
@Test
public void testGetShortRawValue114() { 
     assertEquals(bf_multi.getShortRawValue((short) -1), (short) 0x3F80); 
     assertEquals(bf_multi.getShortRawValue((short) 0), (short) 0); 
     assertEquals(bf_single.getShortRawValue((short) -1), (short) 0x4000); 
     assertEquals(bf_single.getShortRawValue((short) 0), (short) 0); 
     assertEquals(bf_zero.getShortRawValue((short) -1), (short) 0); 
     assertEquals(bf_zero.getShortRawValue((short) 0), (short) 0); 
 }
@Test
public void testIsSet115() { 
     assertTrue(!bf_multi.isSet(0)); 
     assertTrue(!bf_zero.isSet(0)); 
     for (int j = 0x80; j <= 0x3F80; j += 0x80) { 
         assertTrue(bf_multi.isSet(j)); 
     } 
     for (int j = 0x80; j <= 0x3F80; j += 0x80) { 
         assertTrue(!bf_zero.isSet(j)); 
     } 
     assertTrue(!bf_single.isSet(0)); 
     assertTrue(bf_single.isSet(0x4000)); 
 }
@Test
public void testIsAllSet116() { 
     for (int j = 0; j < 0x3F80; j += 0x80) { 
         assertTrue(!bf_multi.isAllSet(j)); 
         assertTrue(bf_zero.isAllSet(j)); 
     } 
     assertTrue(bf_multi.isAllSet(0x3F80)); 
     assertTrue(!bf_single.isAllSet(0)); 
     assertTrue(bf_single.isAllSet(0x4000)); 
 }
@Test
public void testSetShortValue117() { 
     for (int j = 0; j < 128; j++) { 
         assertEquals(bf_multi.getShortValue(bf_multi.setShortValue((short) 0, (short) j)), (short) j); 
         assertEquals(bf_multi.setShortValue((short) 0, (short) j), (short) (j << 7)); 
     } 
     for (int j = 0; j < 128; j++) { 
         assertEquals(bf_zero.getShortValue(bf_zero.setShortValue((short) 0, (short) j)), (short) 0); 
         assertEquals(bf_zero.setShortValue((short) 0, (short) j), (short) 0); 
     } 
     assertEquals(bf_multi.setShortValue((short) 0x3f80, (short) 128), (short) 0); 
     for (int j = 0; j < 2; j++) { 
         assertEquals(bf_single.getShortValue(bf_single.setShortValue((short) 0, (short) j)), (short) j); 
         assertEquals(bf_single.setShortValue((short) 0, (short) j), (short) (j << 14)); 
     } 
     assertEquals(bf_single.setShortValue((short) 0x4000, (short) 2), (short) 0); 
 }
@Test
public void testSetBoolean118() { 
     assertEquals(bf_multi.set(0), bf_multi.setBoolean(0, true)); 
     assertEquals(bf_single.set(0), bf_single.setBoolean(0, true)); 
     assertEquals(bf_zero.set(0), bf_zero.setBoolean(0, true)); 
     assertEquals(bf_multi.clear(-1), bf_multi.setBoolean(-1, false)); 
     assertEquals(bf_single.clear(-1), bf_single.setBoolean(-1, false)); 
     assertEquals(bf_zero.clear(-1), bf_zero.setBoolean(-1, false)); 
 }
@Test
public void testSetShortBoolean119() { 
     assertEquals(bf_multi.setShort((short) 0), bf_multi.setShortBoolean((short) 0, true)); 
     assertEquals(bf_single.setShort((short) 0), bf_single.setShortBoolean((short) 0, true)); 
     assertEquals(bf_zero.setShort((short) 0), bf_zero.setShortBoolean((short) 0, true)); 
     assertEquals(bf_multi.clearShort((short) -1), bf_multi.setShortBoolean((short) -1, false)); 
     assertEquals(bf_single.clearShort((short) -1), bf_single.setShortBoolean((short) -1, false)); 
     assertEquals(bf_zero.clearShort((short) -1), bf_zero.setShortBoolean((short) -1, false)); 
 }
    

    /**
     * test the getShortValue() method
     */
    

    /**
     * test the getRawValue() method
     */
    

    /**
     * test the getShortRawValue() method
     */
    

    /**
     * test the isSet() method
     */
    

    /**
     * test the isAllSet() method
     */
    

    /**
     * test the setValue() method
     */
    

    /**
     * test the setShortValue() method
     */
    

    

    /**
     * test the clear() method
     */
    

    /**
     * test the clearShort() method
     */
    

    /**
     * test the set() method
     */
    

    /**
     * test the setShort() method
     */
    

    /**
     * test the setBoolean() method
     */
    

    /**
     * test the setShortBoolean() method
     */
    

}
