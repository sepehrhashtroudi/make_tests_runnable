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
package org.apache.commons.lang3.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test case for ToStringStyle.
 * 
 * @version $Id$
 */
public class ToStringStyleTest {

    private static class ToStringStyleImpl extends ToStringStyle {
    }

    //-----------------------------------------------------------------------
@Test
public void testSetSummaryObjectEndText1113() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setSummaryObjectEndText(null); 
     assertEquals("", style.getSummaryObjectEndText()); 
 }
@Test
public void testSetArrayEnd1124() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setArrayEnd(null); 
     assertEquals("", style.getArrayEnd()); 
 }
@Test
public void testSetArraySeparator1125() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setArraySeparator(null); 
     assertEquals("", style.getArraySeparator()); 
 }
@Test
public void testSetContentStart1126() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setContentStart(null); 
     assertEquals("", style.getContentStart()); 
 }
@Test
public void testSetFieldSeparator1127() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setFieldSeparator(null); 
     assertEquals("", style.getFieldSeparator()); 
 }
@Test
public void testSetSizeEndText1128() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setSizeEndText(null); 
     assertEquals("", style.getSizeEndText()); 
 }
@Test
public void testSetSummaryObjectStartText1129() { 
     final ToStringStyle style = new ToStringStyleImpl(); 
     style.setSummaryObjectStartText(null); 
     assertEquals("", style.getSummaryObjectStartText()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    /**
     * An object used to test {@link ToStringStyle}.
     * 
     */
    static class Person {
        /**
         * Test String field.
         */
        String name;

        /**
         * Test integer field.
         */
        int age;

        /**
         * Test boolean field.
         */
        boolean smoker;
    }
}
