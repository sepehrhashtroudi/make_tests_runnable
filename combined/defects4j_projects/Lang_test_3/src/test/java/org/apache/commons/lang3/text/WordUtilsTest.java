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
package org.apache.commons.lang3.text;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests for WordUtils class.
 * 
 * @version $Id$
 */
public class WordUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void testCapitalizeFully_String249() { 
     assertEquals(null, WordUtils.capitalizeFully(null)); 
     assertEquals("", WordUtils.capitalizeFully("")); 
     assertEquals("  ", WordUtils.capitalizeFully("  ")); 
     assertEquals("I", WordUtils.capitalizeFully("I")); 
     assertEquals("I", WordUtils.capitalizeFully("i")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I Am Here 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("i am HERE 123")); 
     assertEquals("I Am Here 123", WordUtils.capitalizeFully("I AM HERE 123")); 
 }
@Test
public void testInitials_String250() { 
     assertEquals(null, WordUtils.initials(null)); 
     assertEquals("", WordUtils.initials("")); 
     assertEquals("", WordUtils.initials("  ")); 
     assertEquals("I", WordUtils.initials("I")); 
     assertEquals("i", WordUtils.initials("i")); 
     assertEquals("BJL", WordUtils.initials("Ben John Lee")); 
     assertEquals("BJ", WordUtils.initials("Ben J.Lee")); 
     assertEquals("BJ.L", WordUtils.initials(" Ben   John  . Lee")); 
     assertEquals("iah1", WordUtils.initials("i am here 123")); 
 }
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    

    
    
    

    
    
    

    //-----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

    // -----------------------------------------------------------------------
    

}