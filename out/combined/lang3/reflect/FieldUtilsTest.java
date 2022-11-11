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
package org.apache.commons.lang3.reflect;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeNotNull;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.reflect.testbed.Ambig;
import org.apache.commons.lang3.reflect.testbed.Foo;
import org.apache.commons.lang3.reflect.testbed.PrivatelyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.PublicChild;
import org.apache.commons.lang3.reflect.testbed.PubliclyShadowedChild;
import org.apache.commons.lang3.reflect.testbed.StaticContainer;
import org.apache.commons.lang3.reflect.testbed.StaticContainerChild;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit tests FieldUtils
 * 
 * @version $Id$
 */
public class FieldUtilsTest {

    static final String S = "s";
    static final String SS = "ss";
    static final Integer I0 = Integer.valueOf(0);
    static final Integer I1 = Integer.valueOf(1);
    static final Double D0 = Double.valueOf(0.0);
    static final Double D1 = Double.valueOf(1.0);

    private PublicChild publicChild;
    private PubliclyShadowedChild publiclyShadowedChild;
    private PrivatelyShadowedChild privatelyShadowedChild;
    private final Class<?> parentClass = PublicChild.class.getSuperclass();

    @Before
    public void setUp() {
        StaticContainer.reset();
        publicChild = new PublicChild();
        publiclyShadowedChild = new PubliclyShadowedChild();
        privatelyShadowedChild = new PrivatelyShadowedChild();
    }

@Test
public void testGetDeclaredFieldForceAccess5() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteNamedField36() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetDeclaredFieldForceAccess118() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteNamedStaticField221() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetDeclaredFieldForceAccess437() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteDeclaredNamedStaticField480() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticField515() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess598() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetDeclaredFieldAccessIllegalArgumentException1638() { 
     FieldUtils.getDeclaredField(null, "none"); 
 }
@Test
public void testReadStaticField718() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetFieldIllegalArgumentException1940() { 
     FieldUtils.getField(null, "none"); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldForceAccessIllegalArgumentException11096() throws Exception { 
     FieldUtils.readStaticField(null, true); 
 }
@Test
public void testGetAllFields1118() { 
     assertArrayEquals(new Field[0], FieldUtils.getAllFields(Object.class)); 
     final Field[] fieldsNumber = Number.class.getDeclaredFields(); 
     assertArrayEquals(fieldsNumber, FieldUtils.getAllFields(Number.class)); 
     final Field[] fieldsInteger = Integer.class.getDeclaredFields(); 
     assertArrayEquals(ArrayUtils.addAll(fieldsInteger, fieldsNumber), FieldUtils.getAllFields(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFields(PublicChild.class).length); 
 }
@Test
public void testWriteNamedField1155() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testAmbig1200() { 
     FieldUtils.getField(Ambig.class, "VALUE"); 
 }
@Test
public void testReadNamedField1249() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadStaticField1492() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
 }
@Test
public void testGetAllFieldsList1544() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetDeclaredFieldAccessIllegalArgumentException11712() { 
     FieldUtils.getDeclaredField(null, "none"); 
 }
@Test
public void testWriteNamedStaticField1764() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField1806() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField1937() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess1959() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteNamedStaticField1961() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess1962() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadDeclaredNamedStaticField1998() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE")); 
     try { 
         assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetDeclaredFieldForceAccess2044() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedStaticField2054() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE")); 
     try { 
         assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField2163() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadNamedField2175() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadFieldForceAccess2231() throws Exception { 
     final Field parentS = FieldUtils.getDeclaredField(parentClass, "s"); 
     parentS.setAccessible(false); 
     assertEquals("s", FieldUtils.readField(parentS, publicChild, true)); 
     assertEquals("s", FieldUtils.readField(parentS, publiclyShadowedChild, true)); 
     assertEquals("s", FieldUtils.readField(parentS, privatelyShadowedChild, true)); 
     final Field parentB = FieldUtils.getDeclaredField(parentClass, "b", true); 
     parentB.setAccessible(false); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publicChild, true)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publiclyShadowedChild, true)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, privatelyShadowedChild, true)); 
     final Field parentI = FieldUtils.getDeclaredField(parentClass, "i", true); 
     parentI.setAccessible(false); 
     assertEquals(I0, FieldUtils.readField(parentI, publicChild, true)); 
     assertEquals(I0, FieldUtils.readField(parentI, publiclyShadowedChild, true)); 
     assertEquals(I0, FieldUtils.readField(parentI, privatelyShadowedChild, true)); 
     final Field parentD = FieldUtils.getDeclaredField(parentClass, "d", true); 
     parentD.setAccessible(false); 
     assertEquals(D0, FieldUtils.readField(parentD, publicChild, true)); 
     assertEquals(D0, FieldUtils.readField(parentD, publiclyShadowedChild, true)); 
     assertEquals(D0, FieldUtils.readField(parentD, privatelyShadowedChild, true)); 
     try { 
         FieldUtils.readField((Field) null, publicChild, true); 
         fail("a null field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedField2233() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d")); 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList2241() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testWriteNamedField2265() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList2272() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testWriteNamedStaticField2276() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess2289() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteNamedStaticField2380() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess2396() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetFieldForceAccess2449() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess2504() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField2540() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess2599() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadField2795() throws Exception { 
     final Field parentS = FieldUtils.getDeclaredField(parentClass, "s"); 
     assertEquals("s", FieldUtils.readField(parentS, publicChild)); 
     assertEquals("s", FieldUtils.readField(parentS, publiclyShadowedChild)); 
     assertEquals("s", FieldUtils.readField(parentS, privatelyShadowedChild)); 
     final Field parentB = FieldUtils.getDeclaredField(parentClass, "b", true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publicChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publiclyShadowedChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, privatelyShadowedChild)); 
     final Field parentI = FieldUtils.getDeclaredField(parentClass, "i", true); 
     assertEquals(I0, FieldUtils.readField(parentI, publicChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, publiclyShadowedChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, privatelyShadowedChild)); 
     final Field parentD = FieldUtils.getDeclaredField(parentClass, "d", true); 
     assertEquals(D0, FieldUtils.readField(parentD, publicChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, publiclyShadowedChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, privatelyShadowedChild)); 
     try { 
         FieldUtils.readField((Field) null, publicChild); 
         fail("a null field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess2883() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess2902() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteNamedStaticField2948() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField3172() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFields3260() { 
     assertArrayEquals(new Field[0], FieldUtils.getAllFields(Object.class)); 
     final Field[] fieldsNumber = Number.class.getDeclaredFields(); 
     assertArrayEquals(fieldsNumber, FieldUtils.getAllFields(Number.class)); 
     final Field[] fieldsInteger = Integer.class.getDeclaredFields(); 
     assertArrayEquals(ArrayUtils.addAll(fieldsInteger, fieldsNumber), FieldUtils.getAllFields(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFields(PublicChild.class).length); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess3318() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField3424() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetDeclaredFieldForceAccess3476() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadNamedField3798() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedField3947() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s")); 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(privatelyShadowedChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField3994() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticField4117() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField4156() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadStaticField4377() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
 }
@Test
public void testGetAllFieldsList4542() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testGetFieldForceAccess4580() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadNamedField4652() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadNamedField4695() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField4714() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticField4769() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadField4833() throws Exception { 
     final Field parentS = FieldUtils.getDeclaredField(parentClass, "s"); 
     assertEquals("s", FieldUtils.readField(parentS, publicChild)); 
     assertEquals("s", FieldUtils.readField(parentS, publiclyShadowedChild)); 
     assertEquals("s", FieldUtils.readField(parentS, privatelyShadowedChild)); 
     final Field parentB = FieldUtils.getDeclaredField(parentClass, "b", true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publicChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publiclyShadowedChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, privatelyShadowedChild)); 
     final Field parentI = FieldUtils.getDeclaredField(parentClass, "i", true); 
     assertEquals(I0, FieldUtils.readField(parentI, publicChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, publiclyShadowedChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, privatelyShadowedChild)); 
     final Field parentD = FieldUtils.getDeclaredField(parentClass, "d", true); 
     assertEquals(D0, FieldUtils.readField(parentD, publicChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, publiclyShadowedChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, privatelyShadowedChild)); 
     try { 
         FieldUtils.readField((Field) null, publicChild); 
         fail("a null field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField4864() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetDeclaredFieldForceAccess4871() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess4889() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteDeclaredNamedStaticField5061() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess5078() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteNamedField5134() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedField5155() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s")); 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(privatelyShadowedChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteFieldForceAccess5158() throws Exception { 
     Field field = parentClass.getDeclaredField("s"); 
     FieldUtils.writeField(field, publicChild, "S", true); 
     assertEquals("S", field.get(publicChild)); 
     field = parentClass.getDeclaredField("b"); 
     FieldUtils.writeField(field, publicChild, Boolean.TRUE, true); 
     assertEquals(Boolean.TRUE, field.get(publicChild)); 
     field = parentClass.getDeclaredField("i"); 
     FieldUtils.writeField(field, publicChild, Integer.valueOf(Integer.MAX_VALUE), true); 
     assertEquals(Integer.valueOf(Integer.MAX_VALUE), field.get(publicChild)); 
     field = parentClass.getDeclaredField("d"); 
     FieldUtils.writeField(field, publicChild, Double.valueOf(Double.MAX_VALUE), true); 
     assertEquals(Double.valueOf(Double.MAX_VALUE), field.get(publicChild)); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess5303() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testWriteDeclaredNamedStaticField5425() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField5443() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess5557() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadNamedField5558() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess5727() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testGetDeclaredFieldForceAccess5831() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess5887() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess5906() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess5940() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField5988() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess6018() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteNamedStaticField6029() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList6116() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testGetAllFields6220() { 
     assertArrayEquals(new Field[0], FieldUtils.getAllFields(Object.class)); 
     final Field[] fieldsNumber = Number.class.getDeclaredFields(); 
     assertArrayEquals(fieldsNumber, FieldUtils.getAllFields(Number.class)); 
     final Field[] fieldsInteger = Integer.class.getDeclaredFields(); 
     assertArrayEquals(ArrayUtils.addAll(fieldsInteger, fieldsNumber), FieldUtils.getAllFields(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFields(PublicChild.class).length); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess6229() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testGetFieldForceAccess6353() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteNamedStaticField6402() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadStaticField6404() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetFieldIllegalArgumentException16406() { 
     FieldUtils.getField(null, "none"); 
 }
@Test
public void testWriteNamedStaticField6463() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess6494() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess6537() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedField6547() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess6559() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess6634() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testConstructor6699() { 
     assertNotNull(new FieldUtils()); 
     final Constructor<?>[] cons = FieldUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(FieldUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(FieldUtils.class.getModifiers())); 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess6862() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testConstructor6871() { 
     assertNotNull(new FieldUtils()); 
     final Constructor<?>[] cons = FieldUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(FieldUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(FieldUtils.class.getModifiers())); 
 }
@Test
public void testGetAllFieldsList6967() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testReadNamedField6969() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess7020() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess7065() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(Foo.class, "VALUE", true)); 
     assertEquals("child", FieldUtils.readDeclaredStaticField(PublicChild.class, "VALUE", true)); 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PubliclyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Foo.VALUE, FieldUtils.readDeclaredStaticField(PrivatelyShadowedChild.class, "VALUE", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList7256() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testWriteNamedField7257() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publicChild, "s")); 
     try { 
         FieldUtils.writeField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s")); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i")); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d")); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedFieldForceAccess7335() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S", true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE, true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0), true); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testGetFieldForceAccess7341() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadNamedField7409() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedField7411() throws Exception { 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "s", "S"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(publicChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "s", "S"); 
     assertEquals("S", FieldUtils.readDeclaredField(publiclyShadowedChild, "s")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "b", Boolean.FALSE); 
     assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "i", Integer.valueOf(0)); 
     assertEquals(Integer.valueOf(0), FieldUtils.readDeclaredField(publiclyShadowedChild, "i")); 
     FieldUtils.writeDeclaredField(publiclyShadowedChild, "d", Double.valueOf(0.0)); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readDeclaredField(publiclyShadowedChild, "d")); 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "s", "S"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "b", Boolean.TRUE); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "i", Integer.valueOf(1)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredField(privatelyShadowedChild, "d", Double.valueOf(1.0)); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadDeclaredNamedField7643() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s")); 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(privatelyShadowedChild, "s")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField7665() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList7854() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testReadField7914() throws Exception { 
     final Field parentS = FieldUtils.getDeclaredField(parentClass, "s"); 
     assertEquals("s", FieldUtils.readField(parentS, publicChild)); 
     assertEquals("s", FieldUtils.readField(parentS, publiclyShadowedChild)); 
     assertEquals("s", FieldUtils.readField(parentS, privatelyShadowedChild)); 
     final Field parentB = FieldUtils.getDeclaredField(parentClass, "b", true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publicChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, publiclyShadowedChild)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(parentB, privatelyShadowedChild)); 
     final Field parentI = FieldUtils.getDeclaredField(parentClass, "i", true); 
     assertEquals(I0, FieldUtils.readField(parentI, publicChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, publiclyShadowedChild)); 
     assertEquals(I0, FieldUtils.readField(parentI, privatelyShadowedChild)); 
     final Field parentD = FieldUtils.getDeclaredField(parentClass, "d", true); 
     assertEquals(D0, FieldUtils.readField(parentD, publicChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, publiclyShadowedChild)); 
     assertEquals(D0, FieldUtils.readField(parentD, privatelyShadowedChild)); 
     try { 
         FieldUtils.readField((Field) null, publicChild); 
         fail("a null field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess7916() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadDeclaredNamedFieldForceAccess7923() throws Exception { 
     try { 
         FieldUtils.readDeclaredField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readDeclaredField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals("s", FieldUtils.readDeclaredField(publicChild, "s", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals("ss", FieldUtils.readDeclaredField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readDeclaredField(privatelyShadowedChild, "s", true)); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readDeclaredField(publicChild, "b", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readDeclaredField(privatelyShadowedChild, "b", true)); 
     try { 
         assertEquals(I0, FieldUtils.readDeclaredField(publicChild, "i", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readDeclaredField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readDeclaredField(privatelyShadowedChild, "i", true)); 
     try { 
         assertEquals(D0, FieldUtils.readDeclaredField(publicChild, "d", true)); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readDeclaredField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readDeclaredField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testGetDeclaredFieldForceAccess7924() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadNamedField7978() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedStaticField7997() throws Exception { 
     FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeStaticField(StaticContainerChild.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticField8004() throws Exception { 
     FieldUtils.writeStaticField(StaticContainer.class, "mutablePublic", "new"); 
     assertEquals("new", StaticContainer.mutablePublic); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new"); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new"); 
         fail("Expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetFieldForceAccess8055() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetFieldForceAccess8126() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetDeclaredFieldForceAccess8333() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetFieldForceAccess8383() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetFieldForceAccess8427() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testGetFieldForceAccess8555() { 
     assertEquals(PublicChild.class, FieldUtils.getField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "s", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "b", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "i", true).getDeclaringClass()); 
     assertEquals(parentClass, FieldUtils.getField(PublicChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PubliclyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertEquals(Foo.class, FieldUtils.getField(PrivatelyShadowedChild.class, "VALUE", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test
public void testReadNamedField9153() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testReadNamedField9193() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList9238() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testGetDeclaredFieldForceAccess9300() { 
     assertEquals(PublicChild.class, FieldUtils.getDeclaredField(PublicChild.class, "VALUE", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "s", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "b", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "i", true)); 
     assertNull(FieldUtils.getDeclaredField(PublicChild.class, "d", true)); 
     assertNull(FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "VALUE", true)); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PubliclyShadowedChild.class, FieldUtils.getDeclaredField(PubliclyShadowedChild.class, "d", true).getDeclaringClass()); 
     assertNull(FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "VALUE", true)); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "s", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "b", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "i", true).getDeclaringClass()); 
     assertEquals(PrivatelyShadowedChild.class, FieldUtils.getDeclaredField(PrivatelyShadowedChild.class, "d", true).getDeclaringClass()); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testGetDeclaredFieldAccessIllegalArgumentException19308() { 
     FieldUtils.getDeclaredField(null, "none"); 
 }
@Test
public void testReadNamedField9350() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s")); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s")); 
     assertEquals("s", FieldUtils.readField(privatelyShadowedChild, "s")); 
     try { 
         FieldUtils.readField(publicChild, null); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none"); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b")); 
     try { 
         assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(I0, FieldUtils.readField(publicChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i")); 
     try { 
         assertEquals(I0, FieldUtils.readField(privatelyShadowedChild, "i")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         assertEquals(D0, FieldUtils.readField(publicChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d")); 
     try { 
         assertEquals(D0, FieldUtils.readField(privatelyShadowedChild, "d")); 
         fail("expected IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testGetAllFieldsList9541() { 
     assertEquals(0, FieldUtils.getAllFieldsList(Object.class).size()); 
     final List<Field> fieldsNumber = asArrayList(Number.class.getDeclaredFields()); 
     assertEquals(fieldsNumber, FieldUtils.getAllFieldsList(Number.class)); 
     final List<Field> fieldsInteger = asArrayList(Integer.class.getDeclaredFields()); 
     final List<Field> allFieldsInteger = new ArrayList<Field>(fieldsInteger); 
     allFieldsInteger.addAll(fieldsNumber); 
     assertEquals(allFieldsInteger, FieldUtils.getAllFieldsList(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFieldsList(PublicChild.class).size()); 
 }
@Test
public void testReadStaticField9650() throws Exception { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
     }
@Test
public void testInvokeMethod11809() throws Exception { 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) null)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo",  
                 (Object[]) null, (Object[]) null)); 
         assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", 
                 "")); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 new Object())); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 Boolean.TRUE)); 
         assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.INTEGER_ONE)); 
         assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.BYTE_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.LONG_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.DOUBLE_ONE)); 
     }
@Test
public void testReadFieldForceAccess11812() throws Exception { 
         Field field = FieldUtils.getField(publicChild, "s"); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(field, publicChild, false); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(field, publicChild, false); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
          
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         try { 
             FieldUtils.readField(field, null, true); 
             fail("a null field name should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             FieldUtils.readField((Field) null, (Field) null, true); 
             fail("a null target should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
     }
@Test
public void testInvokeMethod11813() throws Exception { 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) null)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo",  
                 (Object[]) null, (Class<?>[]) null)); 
         assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", 
                 "")); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 new Object())); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 Boolean.TRUE)); 
         assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.INTEGER_ONE)); 
         assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.BYTE_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.LONG_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.DOUBLE_ONE)); 
     }
@Test
public void testInvokeMethod11816() throws Exception { 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) null)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo",  
                 (Object[]) null, (Class<?>[]) null)); 
         assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", 
                 "")); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 new Object())); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 Boolean.TRUE)); 
         assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.INTEGER_ONE)); 
         assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.BYTE_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.LONG_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.DOUBLE_ONE)); 
     }
@Test
public void testInvokeMethod11821() throws Exception { 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) ArrayUtils.EMPTY_CLASS_ARRAY)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo", 
                 (Object[]) null)); 
         assertEquals("foo()", MethodUtils.invokeMethod(testBean, "foo",  
                 (Object[]) null, (Class<?>[]) null)); 
         assertEquals("foo(String)", MethodUtils.invokeMethod(testBean, "foo", 
                 "")); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 new Object())); 
         assertEquals("foo(Object)", MethodUtils.invokeMethod(testBean, "foo", 
                 Boolean.TRUE)); 
         assertEquals("foo(Integer)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.INTEGER_ONE)); 
         assertEquals("foo(int)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.BYTE_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.LONG_ONE)); 
         assertEquals("foo(double)", MethodUtils.invokeMethod(testBean, "foo", 
                 NumberUtils.DOUBLE_ONE)); 
     }
@Test(expected = IllegalArgumentException.class) 
     public void testReadStaticFieldAccessIllegalArgumentException111822() throws Exception { 
         FieldUtils.readStaticField(null, true); 
     }
@Test
public void testReadFieldForceAccess11828() throws Exception { 
         Field field = FieldUtils.getField(publicChild, "s"); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(field, publicChild, false); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         field = FieldUtils.getField(field, publicChild, false); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, false)); 
          
         field = FieldUtils.getField(field, publicChild, true); 
         assertEquals(Foo.VALUE, FieldUtils.readField(field, publicChild, true)); 
         try { 
             FieldUtils.readField(field, null, true); 
             fail("a null field name should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
         try { 
             FieldUtils.readField((Field) null, (Field) null, true); 
             fail("a null target should cause an IllegalArgumentException"); 
         } catch (final IllegalArgumentException e) { 
             // expected 
         } 
     }
@Test
public void testReadStaticField11830() throws Exception { 
         assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
     }
    

    

    

    

    

    

    

    

    private <T> List<T> asArrayList(T... values) {
        final ArrayList<T> arrayList = new ArrayList<T>();
        for (T t : values) {
            arrayList.add(t);
        }
        return arrayList;
    }

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
