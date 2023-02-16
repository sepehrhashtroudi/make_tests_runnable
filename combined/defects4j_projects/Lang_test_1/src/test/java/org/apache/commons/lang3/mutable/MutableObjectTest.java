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
public class MutableObjectTest {

    // ----------------------------------------------------------------
@Test
public void testToString141() { 
     assertEquals("null", new MutableObject<String>().toString()); 
     final MutableObject<String> mutNum = new MutableObject<String>("ALPHA"); 
     assertEquals("ALPHA", mutNum.toString()); 
     mutNum.setValue("BAR"); 
     assertEquals("ALPHA", mutNum.toString()); 
     mutNum.setValue(null); 
     assertEquals("null", mutNum.toString()); 
 }
@Test
public void testToString142() { 
     assertEquals("null", new MutableObject<String>().toString()); 
     final MutableObject<String> mutNum = new MutableObject<String>("ALPHA"); 
     assertEquals("ALPHA", mutNum.toString()); 
     mutNum.setValue("ALPHA"); 
     assertEquals("ALPHA", mutNum.toString()); 
     mutNum.setValue(null); 
     assertEquals("null", mutNum.toString()); 
 }
    

    

    

    

    

}
