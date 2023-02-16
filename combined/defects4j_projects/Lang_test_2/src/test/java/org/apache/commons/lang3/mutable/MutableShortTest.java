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
package org.apache.commons.lang3.mutable;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests.
 * 
 * @version $Id$
 * @see MutableShort
 */
public class MutableShortTest {

    // ----------------------------------------------------------------
@Test
public void testGetSet400() { 
     final MutableShort mutNum = new MutableShort((short) 0); 
     assertEquals((short) 0, new MutableShort().shortValue()); 
     assertEquals(Short.valueOf((short) 0), new MutableShort().getValue()); 
     mutNum.setValue((short) 1); 
     assertEquals((short) 1, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 1), mutNum.getValue()); 
     mutNum.setValue(Short.valueOf((short) 2)); 
     assertEquals((short) 2, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 2), mutNum.getValue()); 
     mutNum.setValue(new MutableShort((short) 3)); 
     assertEquals((short) 3, mutNum.shortValue()); 
     assertEquals(Short.valueOf((short) 3), mutNum.getValue()); 
 }
@Test
public void testHashCode402() { 
     final MutableShort mutNumA = new MutableShort((short) 0); 
     final MutableShort mutNumB = new MutableShort((short) 0); 
     final MutableShort mutNumC = new MutableShort((short) 1); 
     assertTrue(mutNumA.hashCode() == mutNumA.hashCode()); 
     assertTrue(mutNumA.hashCode() == mutNumB.hashCode()); 
     assertFalse(mutNumA.hashCode() == mutNumC.hashCode()); 
     assertTrue(mutNumA.hashCode() == Short.valueOf((short) 0).hashCode()); 
 }
    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
