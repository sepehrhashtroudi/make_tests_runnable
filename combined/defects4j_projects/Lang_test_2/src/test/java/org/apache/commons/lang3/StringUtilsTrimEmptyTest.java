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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.StringUtils} - Trim/Empty methods
 *
 * @version $Id$
 */
public class StringUtilsTrimEmptyTest  {
    private static final String FOO = "foo";

    //-----------------------------------------------------------------------
@Test
public void testTrimToEmpty_String415() { 
     assertEquals("", StringUtils.trimToEmpty(null)); 
     assertEquals("", StringUtils.trimToEmpty("")); 
     assertEquals("", StringUtils.trimToEmpty("        ")); 
     assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.TRIMMABLE)); 
     assertEquals("", StringUtils.trimToEmpty(StringUtilsTest.NON_TRIMMABLE)); 
 }
    

    

    

    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    

    

    
}
