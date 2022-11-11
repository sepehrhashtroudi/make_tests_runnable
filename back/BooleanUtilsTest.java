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
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.BooleanUtils}.
 *
 * @version $Id$
 */
public class BooleanUtilsTest {

    //-----------------------------------------------------------------------
@Test
public void testOr_object_validInput_2items58() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1859() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1860() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1861() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1862() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1863() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1864() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1865() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1866() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1867() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1868() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (false, true)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.TRUE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1869() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void testOr_object_validInput_2items1870() { 
         assertTrue( 
             "True result for (true, true)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.TRUE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "True result for (false, false)", 
             ! BooleanUtils 
                 .or(new Boolean[] { Boolean.FALSE, Boolean.FALSE }) 
                 .booleanValue()); 
  
         assertTrue( 
             "False result for (true, false)", 
             BooleanUtils 
                 .or(new Boolean[] { Boolean.TRUE, Boolean.FALSE }) 
                 .booleanValue()); 
     }
@Test
public void test_toBoolean_String2417() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     }
@Test
public void test_toBoolean_String2421() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     }
@Test
public void test_toBoolean_String2424() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     }
@Test
public void test_toBoolean_String2425() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     }
@Test
public void test_toBoolean_String2427() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     }
@Test
public void test_toBoolean_String2432() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     }
@Test
public void test_toBoolean_String2437() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     }
@Test
public void test_toBoolean_String2439() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     }
@Test
public void test_toBoolean_String2447() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Trueab")); 
         assertFalse(BooleanUtils.toBoolean("Falseab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
         assertFalse(BooleanUtils.toBoolean("Falseabab")); 
     }
@Test
public void test_toBoolean_String2448() { 
         assertTrue(BooleanUtils.toBoolean("true")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertTrue(BooleanUtils.toBoolean("false")); 
         assertTrue(BooleanUtils.toBoolean("TRUE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEA")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSE")); 
         assertFalse(BooleanUtils.toBoolean("FALSEa")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertFalse(BooleanUtils.toBoolean("FALSEab")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertTrue(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("True")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False")); 
         assertFalse(BooleanUtils.toBoolean("False a")); 
     }
    
    
    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    

    
    
    

    

    
    
    //-----------------------------------------------------------------------
    

    
    
    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    //-----------------------------------------------------------------------
    
    
    

    

    

    //-----------------------------------------------------------------------
    

    

    

    

    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //-----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    //  testXor
    //  -----------------------------------------------------------------------
    

    

    

    

    

    
    
    

    

    

    //  testAnd
    //  -----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    //  testOr
    //  -----------------------------------------------------------------------
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
