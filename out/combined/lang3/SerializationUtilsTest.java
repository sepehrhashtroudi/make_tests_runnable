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
public void testClone23() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testPrimitiveTypeClassSerialization45() { 
     final Class<?>[] primitiveTypes = { byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class, char.class, void.class }; 
     for (final Class<?> primitiveType : primitiveTypes) { 
         final Class<?> clone = SerializationUtils.clone(primitiveType); 
         assertEquals(primitiveType, clone); 
     } 
 }
@Test
public void testDeserializeBytesOfNull363() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testSerializeBytes381() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testDeserializeStreamClassNotFound640() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(new ClassNotFoundSerialization()); 
     oos.flush(); 
     oos.close(); 
     final ByteArrayInputStream inTest = new ByteArrayInputStream(streamReal.toByteArray()); 
     try { 
         @SuppressWarnings("unused") 
         final Object test = SerializationUtils.deserialize(inTest); 
     } catch (final SerializationException se) { 
         assertEquals("java.lang.ClassNotFoundException: " + CLASS_NOT_FOUND_MESSAGE, se.getMessage()); 
     } 
 }
@Test
public void testDeserializeBytesOfNull690() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testSerializeBytes695() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testDeserializeBytesOfNull807() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testException838() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testCloneNull1202() throws Exception { 
     final Object test = SerializationUtils.clone(null); 
     assertNull(test); 
 }
@Test
public void testPrimitiveTypeClassSerialization1456() { 
     final Class<?>[] primitiveTypes = { byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class, char.class, void.class }; 
     for (final Class<?> primitiveType : primitiveTypes) { 
         final Class<?> clone = SerializationUtils.clone(primitiveType); 
         assertEquals(primitiveType, clone); 
     } 
 }
@Test
public void testClone1558() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone1605() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone1629() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone1726() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testDeserializeBytesOfNull1744() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testClone1833() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeBytes1893() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testException1909() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testClone1930() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeStreamObjNull1955() throws Exception { 
     try { 
         SerializationUtils.serialize(iMap, null); 
     } catch (final IllegalArgumentException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testClone2056() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone2349() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testDeserializeStreamNull2648() throws Exception { 
     try { 
         SerializationUtils.deserialize((InputStream) null); 
     } catch (final IllegalArgumentException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testException2826() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testDeserializeStreamNull2884() throws Exception { 
     try { 
         SerializationUtils.deserialize((InputStream) null); 
     } catch (final IllegalArgumentException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testDeserializeBytesOfNull2904() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testDeserializeBytesOfNull2947() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testPrimitiveTypeClassSerialization2955() { 
     final Class<?>[] primitiveTypes = { byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class, char.class, void.class }; 
     for (final Class<?> primitiveType : primitiveTypes) { 
         final Class<?> clone = SerializationUtils.clone(primitiveType); 
         assertEquals(primitiveType, clone); 
     } 
 }
@Test
public void testPrimitiveTypeClassSerialization3003() { 
     final Class<?>[] primitiveTypes = { byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class, char.class, void.class }; 
     for (final Class<?> primitiveType : primitiveTypes) { 
         final Class<?> clone = SerializationUtils.clone(primitiveType); 
         assertEquals(primitiveType, clone); 
     } 
 }
@Test
public void testDeserializeBytesNull3090() throws Exception { 
     try { 
         SerializationUtils.deserialize((byte[]) null); 
     } catch (final IllegalArgumentException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testClone3151() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeStreamUnserializable3264() throws Exception { 
     final ByteArrayOutputStream streamTest = new ByteArrayOutputStream(); 
     try { 
         iMap.put(new Object(), new Object()); 
         SerializationUtils.serialize(iMap, streamTest); 
     } catch (final SerializationException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testSerializeBytes3270() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone3319() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone3353() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone3418() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeBytes3605() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testSerializeBytes3708() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone3972() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone4408() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeStreamUnserializable4559() throws Exception { 
     final ByteArrayOutputStream streamTest = new ByteArrayOutputStream(); 
     try { 
         iMap.put(new Object(), new Object()); 
         SerializationUtils.serialize(iMap, streamTest); 
     } catch (final SerializationException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testClone4616() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeBytes4838() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testSerializeBytes4849() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone5090() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone5212() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeBytes5388() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone5408() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testDeserializeBytesOfNull5455() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testSerializeIOException5507() throws Exception { 
     final OutputStream streamTest = new OutputStream() { 
  
         @Override 
         public void write(final int arg0) throws IOException { 
             throw new IOException(SERIALIZE_IO_EXCEPTION_MESSAGE); 
         } 
     }; 
     try { 
         SerializationUtils.serialize(iMap, streamTest); 
     } catch (final SerializationException e) { 
         assertEquals("java.io.IOException: " + SERIALIZE_IO_EXCEPTION_MESSAGE, e.getMessage()); 
     } 
 }
@Test
public void testException5635() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testConstructor5654() { 
     assertNotNull(new SerializationUtils()); 
     final Constructor<?>[] cons = SerializationUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(SerializationUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(SerializationUtils.class.getModifiers())); 
 }
@Test
public void testSerializeBytes5686() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone5747() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone5815() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testDeserializeBytesOfNull5817() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testDeserializeStreamNull5828() throws Exception { 
     try { 
         SerializationUtils.deserialize((InputStream) null); 
     } catch (final IllegalArgumentException ex) { 
         return; 
     } 
     fail(); 
 }
@Test
public void testSerializeBytes6264() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testDeserializeBytesOfNull6286() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testDeserializeBytesOfNull6335() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testPrimitiveTypeClassSerialization6575() { 
     final Class<?>[] primitiveTypes = { byte.class, short.class, int.class, long.class, float.class, double.class, boolean.class, char.class, void.class }; 
     for (final Class<?> primitiveType : primitiveTypes) { 
         final Class<?> clone = SerializationUtils.clone(primitiveType); 
         assertEquals(primitiveType, clone); 
     } 
 }
@Test
public void testDeserializeBytesOfNull6784() throws Exception { 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(null); 
     oos.flush(); 
     oos.close(); 
     final Object test = SerializationUtils.deserialize(streamReal.toByteArray()); 
     assertNull(test); 
 }
@Test
public void testClone7074() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testConstructor7337() { 
     assertNotNull(new SerializationUtils()); 
     final Constructor<?>[] cons = SerializationUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(SerializationUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(SerializationUtils.class.getModifiers())); 
 }
@Test
public void testException7656() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testSerializeBytes7817() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testClone7883() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone8181() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone8550() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone8664() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testSerializeBytes8700() throws Exception { 
     final byte[] testBytes = SerializationUtils.serialize(iMap); 
     final ByteArrayOutputStream streamReal = new ByteArrayOutputStream(); 
     final ObjectOutputStream oos = new ObjectOutputStream(streamReal); 
     oos.writeObject(iMap); 
     oos.flush(); 
     oos.close(); 
     final byte[] realBytes = streamReal.toByteArray(); 
     assertEquals(testBytes.length, realBytes.length); 
     for (int i = 0; i < realBytes.length; i++) { 
         assertEquals(realBytes[i], testBytes[i]); 
     } 
 }
@Test
public void testException8741() { 
     SerializationException serEx; 
     final Exception ex = new Exception(); 
     serEx = new SerializationException(); 
     assertSame(null, serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException("Message"); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(null, serEx.getCause()); 
     serEx = new SerializationException(ex); 
     assertEquals("java.lang.Exception", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
     serEx = new SerializationException("Message", ex); 
     assertSame("Message", serEx.getMessage()); 
     assertSame(ex, serEx.getCause()); 
 }
@Test
public void testClone8907() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
public void testClone9035() throws Exception { 
     final Object test = SerializationUtils.clone(iMap); 
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
