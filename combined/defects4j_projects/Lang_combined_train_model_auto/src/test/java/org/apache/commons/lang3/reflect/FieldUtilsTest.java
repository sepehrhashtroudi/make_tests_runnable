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

@Test(expected = IllegalArgumentException.class) 
 public void testAmbig102() { 
     FieldUtils.getField(Ambig.class, "VALUE"); 
 }
@Test
public void testWriteNamedStaticField127() throws Exception { 
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
public void testWriteNamedField247() throws Exception { 
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
public void testWriteDeclaredNamedField311() throws Exception { 
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
public void testReadDeclaredNamedField315() throws Exception { 
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
public void testReadNamedFieldForceAccess326() throws Exception { 
     assertEquals("s", FieldUtils.readField(publicChild, "s", true)); 
     assertEquals("ss", FieldUtils.readField(publiclyShadowedChild, "s", true)); 
     assertEquals("ss", FieldUtils.readField(privatelyShadowedChild, "s", true)); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publicChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publiclyShadowedChild, "b", true)); 
     assertEquals(Boolean.TRUE, FieldUtils.readField(privatelyShadowedChild, "b", true)); 
     assertEquals(I0, FieldUtils.readField(publicChild, "i", true)); 
     assertEquals(I1, FieldUtils.readField(publiclyShadowedChild, "i", true)); 
     assertEquals(I1, FieldUtils.readField(privatelyShadowedChild, "i", true)); 
     assertEquals(D0, FieldUtils.readField(publicChild, "d", true)); 
     assertEquals(D1, FieldUtils.readField(publiclyShadowedChild, "d", true)); 
     assertEquals(D1, FieldUtils.readField(privatelyShadowedChild, "d", true)); 
     try { 
         FieldUtils.readField(publicChild, null, true); 
         fail("a null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readField((Object) null, "none", true); 
         fail("a null target should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteDeclaredNamedStaticFieldForceAccess368() throws Exception { 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePublic", "new", true); 
     assertEquals("new", StaticContainer.mutablePublic); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutableProtected", "new", true); 
     assertEquals("new", StaticContainer.getMutableProtected()); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePackage", "new", true); 
     assertEquals("new", StaticContainer.getMutablePackage()); 
     FieldUtils.writeDeclaredStaticField(StaticContainer.class, "mutablePrivate", "new", true); 
     assertEquals("new", StaticContainer.getMutablePrivate()); 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PUBLIC", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PROTECTED", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PACKAGE", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
     try { 
         FieldUtils.writeDeclaredStaticField(StaticContainer.class, "IMMUTABLE_PRIVATE", "new", true); 
         fail("Expected IllegalAccessException"); 
     } catch (final IllegalAccessException e) { 
     } 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldIllegalArgumentException2508() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(FieldUtils.getField(Foo.class, "VALUE"))); 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s"); 
     assumeNotNull(nonStaticField); 
     FieldUtils.readStaticField(nonStaticField); 
 }
@Test
public void testReadField596() throws Exception { 
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
public void testWriteDeclaredNamedStaticField660() throws Exception { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldForceAccessIllegalArgumentException2687() throws Exception { 
     final Field nonStaticField = FieldUtils.getField(PublicChild.class, "s", true); 
     assumeNotNull(nonStaticField); 
     FieldUtils.readStaticField(nonStaticField); 
 }
@Test
public void testReadNamedStaticField713() throws Exception { 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(Foo.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PubliclyShadowedChild.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PrivatelyShadowedChild.class, "VALUE")); 
     assertEquals(Foo.VALUE, FieldUtils.readStaticField(PublicChild.class, "VALUE")); 
     try { 
         FieldUtils.readStaticField(null, "none"); 
         fail("null class should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(Foo.class, null); 
         fail("null field name should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(Foo.class, "does_not_exist"); 
         fail("a field that doesn't exist should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
     try { 
         FieldUtils.readStaticField(PublicChild.class, "s"); 
         fail("non-static field should cause an IllegalArgumentException"); 
     } catch (final IllegalArgumentException e) { 
     } 
 }
@Test
public void testWriteNamedFieldForceAccess821() throws Exception { 
     FieldUtils.writeField(publicChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readField(publicChild, "s", true)); 
     FieldUtils.writeField(publicChild, "b", Boolean.TRUE, true); 
     assertEquals(Boolean.TRUE, FieldUtils.readField(publicChild, "b", true)); 
     FieldUtils.writeField(publicChild, "i", Integer.valueOf(1), true); 
     assertEquals(Integer.valueOf(1), FieldUtils.readField(publicChild, "i", true)); 
     FieldUtils.writeField(publicChild, "d", Double.valueOf(1.0), true); 
     assertEquals(Double.valueOf(1.0), FieldUtils.readField(publicChild, "d", true)); 
     FieldUtils.writeField(publiclyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readField(publiclyShadowedChild, "s", true)); 
     FieldUtils.writeField(publiclyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(publiclyShadowedChild, "b", true)); 
     FieldUtils.writeField(publiclyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(publiclyShadowedChild, "i", true)); 
     FieldUtils.writeField(publiclyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(publiclyShadowedChild, "d", true)); 
     FieldUtils.writeField(privatelyShadowedChild, "s", "S", true); 
     assertEquals("S", FieldUtils.readField(privatelyShadowedChild, "s", true)); 
     FieldUtils.writeField(privatelyShadowedChild, "b", Boolean.FALSE, true); 
     assertEquals(Boolean.FALSE, FieldUtils.readField(privatelyShadowedChild, "b", true)); 
     FieldUtils.writeField(privatelyShadowedChild, "i", Integer.valueOf(0), true); 
     assertEquals(Integer.valueOf(0), FieldUtils.readField(privatelyShadowedChild, "i", true)); 
     FieldUtils.writeField(privatelyShadowedChild, "d", Double.valueOf(0.0), true); 
     assertEquals(Double.valueOf(0.0), FieldUtils.readField(privatelyShadowedChild, "d", true)); 
 }
@Test
public void testReadDeclaredNamedStaticField879() throws Exception { 
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
public void testGetAllFieldsList890() { 
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
 public void testGetFieldForceAccessIllegalArgumentException2921() { 
     FieldUtils.getField(PublicChild.class, null, true); 
 }
@Test
public void testReadFieldForceAccess963() throws Exception { 
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
public void testReadNamedField1001() throws Exception { 
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
public void testGetAllFields1010() { 
     assertArrayEquals(new Field[0], FieldUtils.getAllFields(Object.class)); 
     final Field[] fieldsNumber = Number.class.getDeclaredFields(); 
     assertArrayEquals(fieldsNumber, FieldUtils.getAllFields(Number.class)); 
     final Field[] fieldsInteger = Integer.class.getDeclaredFields(); 
     assertArrayEquals(ArrayUtils.addAll(fieldsInteger, fieldsNumber), FieldUtils.getAllFields(Integer.class)); 
     assertEquals(5, FieldUtils.getAllFields(PublicChild.class).length); 
 }
@Test(expected = IllegalArgumentException.class) 
 public void testReadStaticFieldIllegalArgumentException11111() throws Exception { 
     FieldUtils.readStaticField(null); 
 }
@Test
public void testReadDeclaredNamedStaticFieldForceAccess1192() throws Exception { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testGetFieldIllegalArgumentException21210() { 
     FieldUtils.getField(PublicChild.class, null); 
 }
@Test
public void testConstructor1286() { 
     assertNotNull(new FieldUtils()); 
     final Constructor<?>[] cons = FieldUtils.class.getDeclaredConstructors(); 
     assertEquals(1, cons.length); 
     assertTrue(Modifier.isPublic(cons[0].getModifiers())); 
     assertTrue(Modifier.isPublic(FieldUtils.class.getModifiers())); 
     assertFalse(Modifier.isFinal(FieldUtils.class.getModifiers())); 
 }
@Test
public void testWriteFieldForceAccess1314() throws Exception { 
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
@Test(expected = IllegalArgumentException.class) 
 public void testGetDeclaredFieldAccessIllegalArgumentException11339() { 
     FieldUtils.getDeclaredField(null, "none"); 
 }
    

    

    

    

    

    

    

    

    private <T> List<T> asArrayList(T... values) {
        final ArrayList<T> arrayList = new ArrayList<T>();
        for (T t : values) {
            arrayList.add(t);
        }
        return arrayList;
    }

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

    

}
