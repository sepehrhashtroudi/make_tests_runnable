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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.Modifier;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.CharRange}.
 *
 * @version $Id$
 */
public class CharRangeTest  {

    //-----------------------------------------------------------------------
@Test
public void testConstructorAccessors_isNot347() { 
     final CharRange rangea = CharRange.isNot('a'); 
     assertEquals('a', rangea.getStart()); 
     assertEquals('a', rangea.getEnd()); 
     assertTrue(rangea.isNegated()); 
     assertEquals("^a", rangea.toString()); 
 }
@Test
public void testEquals_Object349() { 
     final CharRange a = CharRange.is('a'); 
     final CharRange b = CharRange.is('b'); 
     final CharRange c = CharRange.is('c'); 
     final CharRange c2 = CharRange.is('c'); 
     final CharRange d = CharRange.is('d'); 
     final CharRange e = CharRange.is('e'); 
     final CharRange cd = CharRange.isIn('c', 'd'); 
     final CharRange bd = CharRange.isIn('b', 'd'); 
     final CharRange bc = CharRange.isIn('b', 'c'); 
     final CharRange ab = CharRange.isIn('a', 'b'); 
     final CharRange de = CharRange.isIn('d', 'e'); 
     final CharRange ef = CharRange.isIn('e', 'f'); 
     final CharRange ae = CharRange.isIn('a', 'e'); 
     assertFalse(c.equals(null)); 
     assertTrue(c.equals(c)); 
     assertTrue(c.equals(b)); 
     assertTrue(c.equals(c)); 
     assertFalse(c.equals(c2)); 
     assertFalse(c.equals(cd)); 
     assertFalse(c.equals(bd)); 
     assertFalse(c.equals(bc)); 
     assertFalse(c.equals(ab)); 
     assertFalse(c.equals(de)); 
     assertTrue(cd.equals(c)); 
     assertTrue(bd.equals(c)); 
     assertTrue(bc.equals(c)); 
     assertFalse(ab.equals(c)); 
     assertFalse(de.equals(c)); 
     assertTrue(ae.equals(b)); 
     assertTrue(ae.equals(ab)); 
     assertTrue(ae.equals(bc)); 
     assertTrue(ae.equals(cd));
}

    

    //-----------------------------------------------------------------------
    

    

    

    

    

    

    

    

    //-----------------------------------------------------------------------
    

    

    //-----------------------------------------------------------------------
    

    //-----------------------------------------------------------------------
    

    

    

    //-----------------------------------------------------------------------
    

}
