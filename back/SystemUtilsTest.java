/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.apache.commons.lang3;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_4;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.Locale;

import org.junit.Assert;

/**
 * Unit tests {@link org.apache.commons.lang3.SystemUtils}.
 * 
 * Only limited testing can be performed.
 * 
 * @version $Id$
 */
public class SystemUtilsTest {

@Test
public void testToString114() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new String[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString2912() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString2913() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
@Test
public void testToString2914() { 
         assertEquals("{}", ArrayUtils.toString(null)); 
         assertEquals("{}", ArrayUtils.toString(new Object[0])); 
         assertEquals("{}", ArrayUtils.toString(new String[0])); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null})); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"})); 
          
         assertEquals("<empty>", ArrayUtils.toString(null, "<empty>")); 
         assertEquals("{}", ArrayUtils.toString(new Object[0], "<empty>")); 
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
          
         assertEquals("{<null>}", ArrayUtils.toString(new String[] {null}, "<empty>")); 
         assertEquals("{pink,blue}", ArrayUtils.toString(new String[] {"pink","blue"}, "<empty>")); 
     }
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    /**
     * Assums no security manager exists.
     */
    

    

    

    

    

    

    
}
