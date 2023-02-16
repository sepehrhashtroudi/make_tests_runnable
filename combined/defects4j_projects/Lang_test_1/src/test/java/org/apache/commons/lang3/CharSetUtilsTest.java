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
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharSetUtils}.
 *
 * @version $Id$
 */
public class CharSetUtilsTest  {

    //-----------------------------------------------------------------------
@Test
public void testKeep_StringString423() { 
     assertEquals(null, CharSetUtils.keep(null, (String) null)); 
     assertEquals(null, CharSetUtils.keep(null, "")); 
     assertEquals("", CharSetUtils.keep("", (String) null)); 
     assertEquals("", CharSetUtils.keep("", "")); 
     assertEquals("", CharSetUtils.keep("", "a-e")); 
     assertEquals("hello", CharSetUtils.keep("hello", (String) null)); 
     assertEquals("hello", CharSetUtils.keep("hello", "")); 
     assertEquals("hllo", CharSetUtils.keep("hello", "a-e")); 
     assertEquals("he", CharSetUtils.keep("hello", "l-p")); 
     assertEquals("hello", CharSetUtils.keep("hello", "z")); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    

    //-----------------------------------------------------------------------
    
    
    
    
}
