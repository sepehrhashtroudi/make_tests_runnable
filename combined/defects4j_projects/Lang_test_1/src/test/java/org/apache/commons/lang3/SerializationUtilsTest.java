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
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests {@link org.apache.commons.lang3.SerializationUtils}.
 *
 * @version $Id$
 */
public class SerializationUtilsTest {

  static final String CLASS_NOT_FOUND_MESSAGE = "ClassNotFoundSerialization.readObject fake exception";
    protected static final String SERIALIZE_IO_EXCEPTION_MESSAGE = "Anonymous OutputStream I/O exception";
  
    private String iString;
    private Integer iInteger;
    private HashMap<Object, Object> iMap;

    @Before
    public void setUp() {
        iString = "foo";
        iInteger = Integer.valueOf(7);
        iMap = new HashMap<Object, Object>();
        iMap.put("FOO", iString);
        iMap.put("BAR", iInteger);
    }

    //-----------------------------------------------------------------------

@Test
public void testDeserializeStream347() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final ByteArrayInputStream inTest = new ByteArrayInputStream(streamReal.toByteArray()); 
     final Object test = SerializationUtils.deserialize(inTest); 
     assertNotNull(test); 
     assertTrue(test instanceof HashMap<?, ?>); 
     assertTrue(test != iMap); 
     final HashMap<?, ?> testMap = (HashMap<?, ?>) test; 
     assertEquals(iString, testMap.get("FOO")); 
     assertTrue(iString != testMap.get("FOO")); 
     assertEquals(iInteger, testMap.get("BAR")); 
     assertTrue(iInteger != testMap.get("BAR")); 
     assertEquals(iMap, testMap); 
 }
@Test
public void testDeserializeStreamBadStream348() throws Exception { 
     try { 
         SerializationUtils.deserialize(new ByteArrayInputStream(new byte[0])); 
     } catch (final SerializationException ex) { 
         return; 
     } 
     fail(); 
 }
    
    
    
    
    //-----------------------------------------------------------------------

    

    

    

    

    
    
    

    //-----------------------------------------------------------------------

    

    

    

    

    

    
    
    //-----------------------------------------------------------------------

    

    

    

    //-----------------------------------------------------------------------

    

    

    

    

    //-----------------------------------------------------------------------

    

    

    
    
    

}

@SuppressWarnings("serial")
class ClassNotFoundSerialization implements Serializable
{

    private void readObject(final ObjectInputStream in) throws ClassNotFoundException    {
        throw new ClassNotFoundException(SerializationUtilsTest.CLASS_NOT_FOUND_MESSAGE);
    }
}
