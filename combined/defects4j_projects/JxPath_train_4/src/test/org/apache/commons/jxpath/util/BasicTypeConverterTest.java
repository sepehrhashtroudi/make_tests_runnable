/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.commons.jxpath.util;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import junit.framework.TestCase;

import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.Pointer;

/**
 * Tests BasicTypeConverter
 * 
 * @author Dmitri Plotnikov
 * @version $Revision$ $Date$
 */

public class BasicTypeConverterTest extends TestCase {
    /**
     * Construct a new instance of this test case.
     *
     * @param name Name of the test case
     */
    public BasicTypeConverterTest(String name) {
        super(name);
    }


public void testInvalidConversion30() { 
     boolean exception = false; 
     try { 
         TypeUtils.convert("'foo'", Date.class); 
     } catch (Throwable ex) { 
         exception = true; 
     } 
     assertTrue("Type conversion exception", exception); 
 } 


public void testSingletonArrayToString95() { 
     assertConversion(new String[] { "Earth" }, String.class, "Earth"); 
 } 


public void testBeanUtilsConverter96() { 
     assertConversion("12", BigDecimal.class, new BigDecimal(12)); 
 } 


public void testListToArray97() { 
     assertConversion(Arrays.asList(new Integer[] { new Integer(1), new Integer(2) }), String[].class, Arrays.asList(new String[] { "1", "2" })); 
     assertConversion(Arrays.asList(new String[] { "1", "2" }), int[].class, Arrays.asList(new Integer[] { new Integer(1), new Integer(2) })); 
 } 


public void testNodeSetToInteger98() { 
     assertConversion(new NodeSet() { 
  
         public List getNodes() { 
             return null; 
         } 
  
         public List getPointers() { 
             return null; 
         } 
  
         public List getValues() { 
             return Collections.singletonList("9"); 
         } 
     }, Integer.class, new Integer(9)); 
 } 


public void testNodeSetToString100() { 
     assertConversion(new NodeSet() { 
  
         public List getNodes() { 
             return null; 
         } 
  
         public List getPointers() { 
             return null; 
         } 
  
         public List getValues() { 
             List list = new ArrayList(); 
             list.add("hello"); 
             list.add("goodbye"); 
             return Collections.singletonList(list); 
         } 
     }, String.class, "hello"); 
 } 


public void testSingletonCollectionToString101() { 
     assertConversion(Collections.singleton("Earth"), String.class, "Earth"); 
 } 


public void testPointerToString102() { 
     assertConversion(new Pointer() { 
  
         public Object getValue() { 
             return "value"; 
         } 
  
         public Object getNode() { 
             return null; 
         } 
  
         public void setValue(Object value) { 
         } 
  
         public Object getRootNode() { 
             return null; 
         } 
  
         public String asPath() { 
             return null; 
         } 
  
         public Object clone() { 
             return null; 
         } 
  
         public int compareTo(Object o) { 
             return 0; 
         } 
     }, String.class, "value"); 
 } 

    

    

    

    

    

    public void assertConversion(Object from, Class toType, Object expected) {
        boolean can = TypeUtils.canConvert(from, toType);
        assertTrue("Can convert: " + from.getClass() + " to " + toType, can);
        Object result = TypeUtils.convert(from, toType);
        if (result.getClass().isArray()) {
            ArrayList list = new ArrayList();
            for (int j = 0; j < Array.getLength(result); j++) {
                list.add(Array.get(result, j));
            }
            result = list;
        }
        assertEquals(
            "Convert: " + from.getClass() + " to " + toType,
            expected,
            result);
    }
    
    

    

    

    

    // succeeds in current version
        
    
    
}
