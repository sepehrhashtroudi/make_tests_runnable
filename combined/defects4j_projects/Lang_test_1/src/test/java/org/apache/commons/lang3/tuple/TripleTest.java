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
package org.apache.commons.lang3.tuple;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.Calendar;
import java.util.HashSet;

import org.junit.Test;

/**
 * Test the Triple class.
 *
 * @version $Id$
 */
public class TripleTest {

@Test
public void testToString137() throws Exception { 
     assertEquals("[null,null,null]", Triple.of(null, null, null).toString()); 
     assertEquals("[null,two,null]", Triple.of(null, "two", null).toString()); 
     assertEquals("[one,null,null]", Triple.of("one", null, null).toString()); 
     assertEquals("[one,two,null]", Triple.of("one", "two", null).toString()); 
     assertEquals("[one,two,three]", Triple.of("one", "two", "three").toString()); 
     assertEquals("[one,two,three]", Triple.of("one", "two", "three").toString()); 
 }
    

    

    

    

    

    

    

    

    

    

}

