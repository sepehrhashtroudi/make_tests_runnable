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

import static org.apache.commons.lang3.JavaVersion.JAVA_1_1;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_2;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_3;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Tests CharEncoding.
 * 
 * @see CharEncoding
 * @version $Id$
 */
public class CharEncodingTest  {

    private void assertSupportedEncoding(final String name) {
        assertTrue("Encoding should be supported: " + name, CharEncoding.isSupported(name));
    }

    /**
     * The class can be instantiated.
     */
@Test
public void testSupported765() { 
     assertTrue(CharEncoding.isSupported("UTF8")); 
     assertTrue(CharEncoding.isSupported("UTF-8")); 
     assertTrue(CharEncoding.isSupported("ASCII")); 
 }
@Test
public void testNotSupported766() { 
     assertFalse(CharEncoding.isSupported(null)); 
     assertFalse(CharEncoding.isSupported("")); 
     assertFalse(CharEncoding.isSupported(" ")); 
     assertFalse(CharEncoding.isSupported("\t\r\n")); 
     assertFalse(CharEncoding.isSupported("DOESNOTEXIST")); 
     assertFalse(CharEncoding.isSupported("this is not a valid encoding name")); 
 }
    

    

    

    

    

    

    void warn(final String msg) {
        System.err.println(msg);
    }
}
